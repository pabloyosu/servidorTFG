package com.pabliyosu.servidorSpring;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

//Buscar estaciones
public interface EstacionRepository extends CrudRepository<Estacion, Integer> {
    Estacion findAllBy(int id);
    Estacion findFirstBy(int id);
    List<Estacion> findAll();

    @Override
    Estacion findOne(Integer id);
}
