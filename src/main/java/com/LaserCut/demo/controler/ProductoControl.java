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

import com.LaserCut.demo.interfaceService.IProductoService;
import com.LaserCut.demo.modelo.Producto;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping
public class ProductoControl {
	@Autowired
	private IProductoService service;
	
	@GetMapping("/listarPr")
	public String listar(Model model) {
		List<Producto>producto=service.listar();
		model.addAttribute("producto",producto);
		return "Producto/listarPr";
	}
	
	@GetMapping("/newPr")
	public String agregar(Model model) {
		model.addAttribute("producto",new Producto());
		return "Producto/formPr";	
	}
	
	@PostMapping("/savePr")
	public String save(@Validated Producto p,Model model) {
		service.save(p);
		return "redirect:/listarPr";
	}
	@GetMapping("/editarPr/{id}")
	public String editar(@PathVariable int id,  Model model) {
		Optional<Producto>producto=service.listarId(id);
		model.addAttribute("producto",producto);
		
		return "Producto/formPr";
	}
	
	@GetMapping("/eliminarPr/{id}")
	public String delete(@PathVariable int id,  Model model) {
		service.delete(id);
		return "redirect:/listarPr";	
		}
	@GetMapping("/exportarPdfProducto")
	public ResponseEntity<byte[]>generatePdf() throws Exception,JRException{
		
		JRBeanCollectionDataSource beanCollectionDataSource=new JRBeanCollectionDataSource(service.listar());
		JasperReport compileReport = JasperCompileManager.compileReport(new FileInputStream("src/main/resources/reports/ProductoPdf.jrxml"));
		
		HashMap<String, Object> map=new HashMap<>();
		JasperPrint report = JasperFillManager.fillReport(compileReport, null, beanCollectionDataSource);
		byte[] data = JasperExportManager.exportReportToPdf(report);
		
		HttpHeaders headers=new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_DISPOSITION,"incline;filename=ProductoPdf.pdf");		
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
		
	}
	

}
