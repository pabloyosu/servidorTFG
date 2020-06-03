package com.pabliyosu.servidorSpring;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioBiciRepository extends CrudRepository<UsuarioBici, Integer> {

    public List<UsuarioBici> findAll();
}
