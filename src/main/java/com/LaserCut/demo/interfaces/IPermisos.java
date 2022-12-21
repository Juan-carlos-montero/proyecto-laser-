package com.LaserCut.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.LaserCut.demo.modelo.Permisos;


@Repository
public interface IPermisos  extends CrudRepository<Permisos, Integer>{

}
