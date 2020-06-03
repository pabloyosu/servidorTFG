package com.pabliyosu.servidorSpring;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

//Buscar bicicletas
public interface BicicletaRepository extends CrudRepository<Bicicleta, Integer> {
    Bicicleta findAllBy(int id);
    Bicicleta findFirstBy(int id);
    List<Bicicleta> findAll();

    @Override
    Bicicleta findOne(Integer id);
}
