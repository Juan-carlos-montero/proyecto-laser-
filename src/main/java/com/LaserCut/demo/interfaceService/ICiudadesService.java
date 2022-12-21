package com.LaserCut.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.LaserCut.demo.modelo.Ciudades;

public interface ICiudadesService {
public List<Ciudades>listarci();
public Optional<Ciudades>listarId(int id);
public int save(Ciudades ci);
public void delete(int id);


}
