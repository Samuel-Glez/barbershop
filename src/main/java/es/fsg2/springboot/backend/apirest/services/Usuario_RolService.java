package es.fsg2.springboot.backend.apirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fsg2.springboot.backend.apirest.dao.Usuario_RolDao;
import es.fsg2.springboot.backend.apirest.entity.Usuario_Rol;

@Service
public class Usuario_RolService implements GenericServiceInterface<Usuario_Rol, Integer> {

	@Autowired
	private Usuario_RolDao usuario_RolDao;
	
	@Override
	public List<Usuario_Rol> findAll() {
		return (List<Usuario_Rol>) usuario_RolDao.findAll();
	}

	@Override
	public Usuario_Rol findById(Integer id) {
		return usuario_RolDao.findById(id).orElse(null);
	}

	@Override
	public Usuario_Rol save(Usuario_Rol usuario_Rol) {
		return usuario_RolDao.save(usuario_Rol);
	}

	@Override
	public void delete(Integer id) {
		usuario_RolDao.deleteById(id);
		
	}

}
