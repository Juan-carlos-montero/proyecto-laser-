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

import com.LaserCut.demo.interfaceService.IPermisosService;
import com.LaserCut.demo.modelo.Permisos;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping
public class PermisosControl {
	
	@Autowired
	private IPermisosService service;
	
	@GetMapping("/listarP")
	public String listar(Model model) {
		List<Permisos>permisos=service.listar();
		model.addAttribute("permisos",permisos);
		return "Permisos/listarP";
	}
	
	@GetMapping("/newP")
	public String agregar(Model model) {
		model.addAttribute("permisos",new Permisos());
		return "Permisos/formP";	
	}
	
	@PostMapping("/saveP")
	public String save(@Validated Permisos Pe,Model model) {
		service.save(Pe);
		return "redirect:/listarP";
	}
	@GetMapping("/editarP/{id}")
	public String editar(@PathVariable int id,  Model model) {
		Optional<Permisos>permisos=service.listarId(id);
		model.addAttribute("permisos",permisos);
		
		return "Permisos/formP";
	}
	
	@GetMapping("/eliminarP/{id}")
	public String delete(@PathVariable int id,  Model model) {
		service.delete(id);
		return "redirect:/listarP";	
		}
	
	@GetMapping("/exportarPdfPermisos")
	public ResponseEntity<byte[]>generatePdf() throws Exception,JRException{
		
		JRBeanCollectionDataSource beanCollectionDataSource=new JRBeanCollectionDataSource(service.listar());
		JasperReport compileReport = JasperCompileManager.compileReport(new FileInputStream("src/main/resources/reports/PermisosPdf.jrxml"));
		
		HashMap<String, Object> map=new HashMap<>();
		JasperPrint report = JasperFillManager.fillReport(compileReport, null, beanCollectionDataSource);
		byte[] data = JasperExportManager.exportReportToPdf(report);
		
		HttpHeaders headers=new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_DISPOSITION,"incline;filename=PermisosPdf.pdf");		
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
		
	}
}
	
