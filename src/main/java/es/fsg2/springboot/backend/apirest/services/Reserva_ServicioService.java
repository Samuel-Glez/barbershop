package es.fsg2.springboot.backend.apirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fsg2.springboot.backend.apirest.dao.Reserva_ServicioDao;
import es.fsg2.springboot.backend.apirest.entity.Reserva_Servicio;

@Service
public class Reserva_ServicioService implements GenericServiceInterface<Reserva_Servicio, Integer> {

	@Autowired
	private Reserva_ServicioDao reserva_ServicioDao;
	
	@Override
	public List<Reserva_Servicio> findAll() {
		return (List<Reserva_Servicio>) reserva_ServicioDao.findAll();
	}

	@Override
	public Reserva_Servicio findById(Integer id) {
		return reserva_ServicioDao.findById(id).orElse(null);
	}

	@Override
	public Reserva_Servicio save(Reserva_Servicio reserva_Servicio) {
		return reserva_ServicioDao.save(reserva_Servicio);
	}

	@Override
	public void delete(Integer id) {
		reserva_ServicioDao.deleteById(id);
		
	}

	

}
