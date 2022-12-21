package com.LaserCut.demo.util;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.LaserCut.demo.modelo.Rol;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("rol/listarR/")
public class RolPdf extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		@SuppressWarnings("unchecked")
		List<Rol> listadoRol = (List<Rol>) model.get("rol");
		
		PdfPTable tablaRol =new PdfPTable(6);
		
		listadoRol.forEach(rol ->{
			tablaRol.addCell(rol.getNombre());

			 
		 });
		document.add(tablaRol);
	
		
	}

}
