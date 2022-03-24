package es.fsg2.springboot.backend.apirest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.fsg2.springboot.backend.apirest.dao.ReservaDao;
import es.fsg2.springboot.backend.apirest.entity.Reserva;

@Service
public class ReservaService implements GenericServiceInterface<Reserva, Integer> {

	@Autowired
	private ReservaDao reservaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Reserva> findAll() {
		return (List<Reserva>) reservaDao.findAll();
	}

	@Override
	public Optional<Reserva> findById(Integer id) {
		return reservaDao.findById(id);
	}
	
	/*@Override
	@Transactional(readOnly = true)
	public Reserva findById(Integer id) {
		return reservaDao.findById(id).orElse(null);
	}*/

	@Override
	public Reserva save(Reserva reserva) {
		return reservaDao.save(reserva);
	}

	@Override
	public void delete(Integer id) {
		reservaDao.deleteById(id);
	}

	
}
