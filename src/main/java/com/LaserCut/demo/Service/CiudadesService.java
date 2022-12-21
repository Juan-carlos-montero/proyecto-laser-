package com.LaserCut.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LaserCut.demo.interfaceService.ICiudadesService;
import com.LaserCut.demo.interfaces.ICiudades;
import com.LaserCut.demo.modelo.Ciudades;

@Service
public class CiudadesService  implements ICiudadesService{

	@Autowired
	private ICiudades data;
	
	@Override
	public List<Ciudades> listarci() {
		return (List<Ciudades>)data.findAll();
	}

	

	@Override
	public Optional<Ciudades> listarId(int id) {
		return data.findById(id) ;
	}

	@Override
	public int save(Ciudades ci) {
		int res=0;
		Ciudades ciudades=data.save(ci);
		if(!ciudades.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);			
	}

}
