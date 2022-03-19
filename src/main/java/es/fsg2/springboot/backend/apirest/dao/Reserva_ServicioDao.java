package es.fsg2.springboot.backend.apirest.dao;

import org.springframework.data.repository.CrudRepository;

import es.fsg2.springboot.backend.apirest.entity.Reserva_Servicio;

public interface Reserva_ServicioDao extends CrudRepository<Reserva_Servicio, Integer>{

}
