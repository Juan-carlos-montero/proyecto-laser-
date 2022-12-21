package com.LaserCut.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.LaserCut.demo.modelo.Permisos;

public interface IPermisosService {
	public List<Permisos>listar();
	public Optional<Permisos>listarId(int id);
	public int save(Permisos pe);
	public void delete(int id);

}
