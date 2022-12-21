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

import com.LaserCut.demo.interfaceService.IRolService;
import com.LaserCut.demo.modelo.Rol;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping
public class RolControl {
	
	@Autowired
	private IRolService service;
	
	@GetMapping("/listarR")
	public String listadoRol(Model model) {
		List<Rol>listadoRol=service.listar();
		model.addAttribute("rol",listadoRol);
		return "rol/listarR";
	}
	
	@GetMapping("/newR")
	public String agregar(Model model) {
		model.addAttribute("rol",new Rol());
		return "rol/formR";	
	}
	
	@PostMapping("/saveR")
	public String save(@Validated Rol r,Model model) {
		service.save(r);
		return "redirect:/listarR";
	}
	@GetMapping("/editarR/{id}")
	public String editar(@PathVariable int id,  Model model) {
		Optional<Rol>rol=service.listarId(id);
		model.addAttribute("rol",rol);
		
		return "rol/formR";
	}
	
	@GetMapping("/eliminarR/{id}")
	public String delete(@PathVariable int id,  Model model) {
		service.delete(id);
		return "redirect:/listarR";	
		}
	
	@GetMapping("/exportarPdfRol")
	public ResponseEntity<byte[]>generatePdf() throws Exception,JRException{
		
		JRBeanCollectionDataSource beanCollectionDataSource=new JRBeanCollectionDataSource(service.listar());
		JasperReport compileReport = JasperCompileManager.compileReport(new FileInputStream("src/main/resources/reports/rolpdf1.jrxml"));
		
		HashMap<String, Object> map=new HashMap<>();
		JasperPrint report = JasperFillManager.fillReport(compileReport, null, beanCollectionDataSource);
		byte[] data = JasperExportManager.exportReportToPdf(report);
		
		HttpHeaders headers=new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_DISPOSITION,"incline;filename=rolpdf1.pdf");		
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
		
	}
	
	

}
