package com.LaserCut.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LaserCut.demo.interfaceService.IUsuariosService;
import com.LaserCut.demo.interfaces.IUsuarios;
import com.LaserCut.demo.modelo.Usuarios;

@Service
public class UsuariosService implements IUsuariosService{

	@Autowired
	private IUsuarios data;
	
	@Override
	public List<Usuarios> listar() {
		return (List<Usuarios>)data.findAll();
	}

	@Override
	public Optional<Usuarios> listarId(int id) {
		// TODO Auto-generated method stub
		return data.findById(id);
	}

	@Override
	public int save(Usuarios u) {
		int res=0;
		Usuarios usuarios=data.save(u);
		if(!usuarios.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
		
	}

}
