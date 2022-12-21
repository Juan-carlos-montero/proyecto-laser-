package com.LaserCut.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.LaserCut.demo.modelo.Categoria;

@Repository
public interface ICategoria extends CrudRepository<Categoria, Integer>{

}
