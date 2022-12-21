package com.LaserCut.demo.controler;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.LaserCut.demo.interfaceService.ITipodocumentoService;
import com.LaserCut.demo.modelo.Tipodocumento;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping
public class TipodocumentoControl {
	@Autowired
	private ITipodocumentoService service;
	
	@GetMapping("/listarTD")
	public String listar(Model model) {
		List<Tipodocumento>tipodocumento=service.listar();
		model.addAttribute("tipodocumento",tipodocumento);
		return "TDocumentos/listarTD";
	}
	
	@GetMapping("/newTD")
	public String agregar(Model model) {
		model.addAttribute("tipodocumento",new Tipodocumento());
		return "TDocumentos/formTD";	
	}
	
	@PostMapping("/saveTD")
	public String save(@Validated Tipodocumento t,Model model) {
		service.save(t);
		return "redirect:/listarTD";
	}
	@GetMapping("/editarTD/{id}")
	public String editar(@PathVariable int id,  Model model) {
		Optional<Tipodocumento>tipodocumento=service.listarId(id);
		model.addAttribute("tipodocumento",tipodocumento);
		
		return "TDocumentos/formTD";
	}
	
	@GetMapping("/eliminarTD/{id}")
	public String delete(@PathVariable int id,  Model model) {
		service.delete(id);
		return "redirect:/listarTD";	
		}
	
	@GetMapping("/exportarPdfTD")
	public ResponseEntity<byte[]>generatePdf() throws Exception,JRException{
		
		JRBeanCollectionDataSource beanCollectionDataSource=new JRBeanCollectionDataSource(service.listar());
		JasperReport compileReport = JasperCompileManager.compileReport(new FileInputStream("src/main/resources/reports/TDPdf.jrxml"));
		
		HashMap<String, Object> map=new HashMap<>();
		JasperPrint report = JasperFillManager.fillReport(compileReport, null, beanCollectionDataSource);
		byte[] data = JasperExportManager.exportReportToPdf(report);
		
		HttpHeaders headers=new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_DISPOSITION,"incline;filename=TDPdf.pdf");		
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
		
	}
	
	

}
