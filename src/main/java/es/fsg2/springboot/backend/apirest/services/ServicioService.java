package es.fsg2.springboot.backend.apirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fsg2.springboot.backend.apirest.dao.ServicioDao;
import es.fsg2.springboot.backend.apirest.entity.Servicio;

@Service
public class ServicioService implements GenericServiceInterface<Servicio, Integer>{

	@Autowired
	private ServicioDao servicioDao;
	
	@Override
	public List<Servicio> findAll() {
		return (List<Servicio>) servicioDao.findAll();
	}

	@Override
	public Servicio findById(Integer id) {
		return servicioDao.findById(id).orElse(null);
	}

	@Override
	public Servicio save(Servicio servicio) {
		return servicioDao.save(servicio);
	}

	@Override
	public void delete(Integer id) {
		servicioDao.deleteById(id);
		
	}

	

}
