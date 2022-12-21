package com.LaserCut.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LaserCut.demo.interfaceService.ITipodocumentoService;
import com.LaserCut.demo.interfaces.ITipodocumento;
import com.LaserCut.demo.modelo.Tipodocumento;

@Service
public class TipodocumentoService implements ITipodocumentoService {

	@Autowired
	private ITipodocumento data;
	
	@Override
	public List<Tipodocumento> listar() {
		return (List<Tipodocumento>)data.findAll();
	}

	@Override
	public Optional<Tipodocumento> listarId(int id) {
		// TODO Auto-generated method stub
		return data.findById(id);
	}

	@Override
	public int save(Tipodocumento t) {
		int res=0;
		Tipodocumento tipodocumento=data.save(t);
		if(!tipodocumento.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
		
	}

}
