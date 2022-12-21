package com.LaserCut.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LaserCut.demo.interfaceService.ICategoriaService;
import com.LaserCut.demo.interfaces.ICategoria;
import com.LaserCut.demo.modelo.Categoria;

@Service
public class CategoriaService implements ICategoriaService{

	@Autowired
	private ICategoria data;
	
	@Override
	public List<Categoria>listarc() {
		return (List<Categoria>)data.findAll();
	}

	@Override
	public Optional<Categoria> listarId(int id) {
		return data.findById(id) ;
	}

	@Override
	public int save(Categoria c) {
		int res=0;
		Categoria categoria=data.save(c);
		if(!categoria.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);		
	}
	
	
	


}
