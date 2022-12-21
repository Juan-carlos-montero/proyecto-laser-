package com.LaserCut.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LaserCut.demo.interfaceService.IProductoService;
import com.LaserCut.demo.interfaces.IProducto;
import com.LaserCut.demo.modelo.Producto;

@Service
public class ProductoService implements IProductoService {

	@Autowired
	private IProducto data;

	@Override
	public List<Producto> listar() {
		return (List<Producto>)data.findAll();
	}

	@Override
	public Optional<Producto> listarId(int id) {
		// TODO Auto-generated method stub
		return data.findById(id);
	}

	@Override
	public int save(Producto p) {
		int res=0;
		Producto producto=data.save(p);
		if(!producto.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);		
	}

}
