package com.LaserCut.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LaserCut.demo.interfaceService.IPermisosService;
import com.LaserCut.demo.interfaces.IPermisos;
import com.LaserCut.demo.modelo.Permisos;

@Service
public class PermisosService implements IPermisosService{

	@Autowired
	private IPermisos data;
	
	@Override
	public List<Permisos> listar() {
		return (List<Permisos>)data.findAll();
	}

	@Override
	public Optional<Permisos> listarId(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Permisos pe) {
		int res=0;
		Permisos permisos=data.save(pe);
		if(!permisos.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
	}
	

	
}
