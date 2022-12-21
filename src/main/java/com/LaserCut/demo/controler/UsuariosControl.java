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

import com.LaserCut.demo.interfaceService.IUsuariosService;
import com.LaserCut.demo.modelo.Usuarios;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping
public class UsuariosControl {
	
	@Autowired
	private IUsuariosService service;
	
	@GetMapping("/listarU")
	public String listar(Model model) {
		List<Usuarios>usuarios=service.listar();
		model.addAttribute("usuarios",usuarios);
		return "Usuarios/listarU";
	}
	
	@GetMapping("/newU")
	public String agregar(Model model) {
		model.addAttribute("usuarios",new Usuarios());
		return "Usuarios/formU";	
	}
	
	@PostMapping("/saveU")
	public String save(@Validated Usuarios u,Model model) {
		service.save(u);
		return "redirect:/listarU";
	}
	@GetMapping("/editarU/{id}")
	public String editar(@PathVariable int id,  Model model) {
		Optional<Usuarios>usuarios=service.listarId(id);
		model.addAttribute("usuarios",usuarios);
		
		return "Usuarios/formU";
	}
	
	@GetMapping("/eliminarU/{id}")
	public String delete(@PathVariable int id,  Model model) {
		service.delete(id);
		return "redirect:/listarU";	
		}
	@GetMapping("/exportarPdfUsuarios")
	public ResponseEntity<byte[]>generatePdf() throws Exception,JRException{
		
		JRBeanCollectionDataSource beanCollectionDataSource=new JRBeanCollectionDataSource(service.listar());
		JasperReport compileReport = JasperCompileManager.compileReport(new FileInputStream("src/main/resources/reports/UsuariosPdf.jrxml"));
		
		HashMap<String, Object> map=new HashMap<>();
		JasperPrint report = JasperFillManager.fillReport(compileReport, null, beanCollectionDataSource);
		byte[] data = JasperExportManager.exportReportToPdf(report);
		
		HttpHeaders headers=new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_DISPOSITION,"incline;filename=UsuariosPdf.pdf");		
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
		
	}
	
	

}
