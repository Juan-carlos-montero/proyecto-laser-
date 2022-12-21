package com.LaserCut.demo.interfaceService;

import java.util.List;
import java.util.Optional;
import com.LaserCut.demo.modelo.Categoria;

public interface ICategoriaService {
public List<Categoria>listarc();
public Optional<Categoria>listarId(int id);
public int save(Categoria c);
public void delete(int id);
	


}
