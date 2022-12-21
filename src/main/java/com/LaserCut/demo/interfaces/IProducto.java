package com.LaserCut.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.LaserCut.demo.modelo.Producto;

@Repository
public interface IProducto extends CrudRepository<Producto, Integer>{

}
