package es.fsg2.springboot.backend.apirest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.fsg2.springboot.backend.apirest.entity.Reserva;

public interface GenericServiceInterface <T,E> {

	public List<T> findAll();
	
	public Optional<T> findById(E id);
	
	public T save(T objeto);

	public void delete(Integer id);
}
