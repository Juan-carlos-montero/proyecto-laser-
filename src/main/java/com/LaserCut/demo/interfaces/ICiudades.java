package com.LaserCut.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.LaserCut.demo.modelo.Ciudades;

@Repository
public interface ICiudades extends CrudRepository<Ciudades, Integer> {

}
