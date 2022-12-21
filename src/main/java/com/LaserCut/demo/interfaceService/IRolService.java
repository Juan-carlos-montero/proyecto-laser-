package com.LaserCut.demo.interfaceService;

import java.util.List;
import java.util.Optional;
import com.LaserCut.demo.modelo.Rol;


public interface IRolService {
	public List<Rol>listar();
	public Optional<Rol>listarId(int id);
	public int save(Rol r);
	public void delete(int id);

}
