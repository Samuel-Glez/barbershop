package es.fsg2.springboot.backend.apirest.dao;

import org.springframework.data.repository.CrudRepository;

import es.fsg2.springboot.backend.apirest.entity.Reserva;

public interface ReservaDao extends CrudRepository<Reserva, Integer>{

}
