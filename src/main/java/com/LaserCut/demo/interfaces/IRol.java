package com.LaserCut.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.LaserCut.demo.modelo.Rol;

@Repository
public interface IRol extends CrudRepository<Rol, Integer>{

}
