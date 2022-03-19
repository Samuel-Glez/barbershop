package es.fsg2.springboot.backend.apirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.fsg2.springboot.backend.apirest.dao.RolDao;
import es.fsg2.springboot.backend.apirest.entity.Rol;

@Service
public class RolService implements GenericServiceInterface<Rol, Integer>{
	
	@Autowired
	private RolDao rolDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Rol> findAll() {	
		return  (List<Rol>) rolDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Rol findById(Integer id) {
		return rolDao.findById(id).orElse(null);
	}

	@Override
	public Rol save(Rol rol) {
		return rolDao.save(rol);
	}

	@Override
	public void delete(Integer id) {
		rolDao.deleteById(id);
		
	}

}
