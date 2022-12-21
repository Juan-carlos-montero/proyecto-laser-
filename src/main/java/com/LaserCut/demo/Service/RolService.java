package com.LaserCut.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LaserCut.demo.interfaceService.IRolService;
import com.LaserCut.demo.interfaces.IRol;
import com.LaserCut.demo.modelo.Rol;


@Service
public class RolService implements IRolService {
	
	@Autowired
	private IRol data;

	@Override
	public List<Rol> listar() {
		return (List<Rol>)data.findAll();
	}

	@Override
	public Optional<Rol> listarId(int id) {
		// TODO Auto-generated method stub
		return data.findById(id);
	}

	@Override
	public int save(Rol r) {
		int res=0;
		Rol rol=data.save(r);
		if(!rol.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
	}

}
