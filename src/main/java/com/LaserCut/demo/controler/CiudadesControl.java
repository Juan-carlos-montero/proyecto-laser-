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

import com.LaserCut.demo.interfaceService.ICiudadesService;
import com.LaserCut.demo.modelo.Ciudades;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping
public class CiudadesControl {
	@Autowired
	private ICiudadesService service;
	
	@GetMapping("/listarCi")
	public String listar(Model model) {
		List<Ciudades>ciudades=service.listarci();
		model.addAttribute("ciudades",ciudades);
		return "Ciudades/listarCi";
	}
	
	@GetMapping("/newCi")
	public String agregar(Model model) {
		model.addAttribute("ciudades",new Ciudades());
		return "Ciudades/formCi";	
	}
	
	@PostMapping("/saveCi")
	public String save(@Validated Ciudades ci,Model model) {
		service.save(ci);
		return "redirect:/listarCi";
	}
	@GetMapping("/editarCi/{id}")
	public String editar(@PathVariable int id,  Model model) {
		Optional<Ciudades>ciudades=service.listarId(id);
		model.addAttribute("ciudades",ciudades);
		
		return "Categoria/formCi";
	}
	
	@GetMapping("/eliminarCi/{id}")
	public String delete(@PathVariable int id,  Model model) {
		service.delete(id);
		return "redirect:/listarCi";	
		}
	
	@GetMapping("/exportarPdfCiudades")
	public ResponseEntity<byte[]>generatePdf() throws Exception,JRException{
		
		JRBeanCollectionDataSource beanCollectionDataSource=new JRBeanCollectionDataSource(service.listarci());
		JasperReport compileReport = JasperCompileManager.compileReport(new FileInputStream("src/main/resources/reports/CiudadePdf.jrxml"));
		
		HashMap<String, Object> map=new HashMap<>();
		JasperPrint report = JasperFillManager.fillReport(compileReport, null, beanCollectionDataSource);
		byte[] data = JasperExportManager.exportReportToPdf(report);
		
		HttpHeaders headers=new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_DISPOSITION,"incline;filename=CiudadePdf.pdf");		
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
		
	}



}
