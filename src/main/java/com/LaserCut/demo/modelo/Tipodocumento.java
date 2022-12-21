package com.LaserCut.demo.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tipodocumento")
public class Tipodocumento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String siglas_tdoc;
	
	public Tipodocumento() {
		super();
	}

	public Tipodocumento(int id, String nombre, String siglas_tdoc) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.siglas_tdoc = siglas_tdoc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSiglas_tdoc() {
		return siglas_tdoc;
	}

	public void setSiglas_tdoc(String siglas_tdoc) {
		this.siglas_tdoc = siglas_tdoc;
	}



	
	

}
