package com.pabliyosu.servidorSpring;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

//Buscar carreras
public interface CarreraRepository extends CrudRepository<Carrera, Integer> {
    Carrera findAllBy(int id);
    Carrera findFirstBy(int id);
    List<Carrera> findAll();
    ArrayList<Carrera> findByUsuario(Usuario id);

    @Override
    Carrera findOne(Integer id);

    ArrayList<Carrera> findByBicicleta(Bicicleta bicicleta);
}
