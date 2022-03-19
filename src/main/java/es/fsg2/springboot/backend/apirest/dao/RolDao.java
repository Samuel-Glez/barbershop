package es.fsg2.springboot.backend.apirest.dao;

import org.springframework.data.repository.CrudRepository;

import es.fsg2.springboot.backend.apirest.entity.Rol;

public interface RolDao extends CrudRepository<Rol, Integer>{

}
