package com.LaserCut.demo.interfaceService;

import java.util.List;
import java.util.Optional;
import com.LaserCut.demo.modelo.Tipodocumento;

public interface ITipodocumentoService {
	public List<Tipodocumento>listar();
	public Optional<Tipodocumento>listarId(int id);
	public int save(Tipodocumento t);
	public void delete(int id);

}
