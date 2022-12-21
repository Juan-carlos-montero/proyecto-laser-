package com.LaserCut.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.LaserCut.demo.modelo.Producto;

public interface IProductoService {
	public List<Producto>listar();
	public Optional<Producto>listarId(int id);
	public int save(Producto pr);
	public void delete(int id);

}
