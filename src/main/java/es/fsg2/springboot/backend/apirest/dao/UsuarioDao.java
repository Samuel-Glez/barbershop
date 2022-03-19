package es.fsg2.springboot.backend.apirest.dao;

import org.springframework.data.repository.CrudRepository;

import es.fsg2.springboot.backend.apirest.entity.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario, Integer> {

}
