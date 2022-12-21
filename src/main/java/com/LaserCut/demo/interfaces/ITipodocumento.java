package com.LaserCut.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.LaserCut.demo.modelo.Tipodocumento;

@Repository
public interface ITipodocumento extends CrudRepository<Tipodocumento, Integer> {

}
