package com.pabliyosu.servidorSpring;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    Usuario findAllBy(int id);
    Usuario findFirstBy(int id);
    List<Usuario> findAll();
    Usuario findUsuarioByEmailAndContrasenia(String email, String contrasenia);

    @Override
    Usuario findOne(Integer id);


}
