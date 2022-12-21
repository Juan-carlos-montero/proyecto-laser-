package com.LaserCut.demo.interfaceService;

import java.util.List;
import java.util.Optional;
import com.LaserCut.demo.modelo.Usuarios;

public interface IUsuariosService {
	public List<Usuarios>listar();
	public Optional<Usuarios>listarId(int id);
	public int save(Usuarios u);
	public void delete(int id);

}
