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

import com.LaserCut.demo.Service.CategoriaService;
import com.LaserCut.demo.interfaceService.ICategoriaService;
import com.LaserCut.demo.modelo.Categoria;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping
public class CategoriaControl {

	@Autowired
	private ICategoriaService service;
	
	@GetMapping("/listarCa")
	public String listar(Model model) {
		List<Categoria>categoria=service.listarc();
		model.addAttribute("categoria",categoria);
		return "Categoria/listarCa";
	}
	
	@GetMapping("/newCa")
	public String agregar(Model model) {
		model.addAttribute("categoria",new Categoria());
		return "Categoria/formCa";	
	}
	
	@PostMapping("/saveCa")
	public String save(@Validated Categoria c,Model model) {
		service.save(c);
		return "redirect:/listarCa";
	}
	@GetMapping("/editarCa/{id}")
	public String editar(@PathVariable int id,  Model model) {
		Optional<Categoria>categoria=service.listarId(id);
		model.addAttribute("categoria",categoria);
		
		return "Categoria/formCa";
	}
	
	@GetMapping("/eliminarCa/{id}")
	public String delete(@PathVariable int id,  Model model) {
		service.delete(id);
		return "redirect:/listarCa";	
	}
	
	@GetMapping("/exportarPdfCategoria")
	public ResponseEntity<byte[]>generatePdf() throws Exception,JRException{
		
		JRBeanCollectionDataSource beanCollectionDataSource=new JRBeanCollectionDataSource(service.listarc());
		JasperReport compileReport = JasperCompileManager.compileReport(new FileInputStream("src/main/resources/reports/CategoriaPdf.jrxml"));
		
		HashMap<String, Object> map=new HashMap<>();
		JasperPrint report = JasperFillManager.fillReport(compileReport, null, beanCollectionDataSource);
		byte[] data = JasperExportManager.exportReportToPdf(report);
		
		HttpHeaders headers=new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_DISPOSITION,"incline;filename=CategoriaPdf.pdf");		
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
		
	}
	



}
