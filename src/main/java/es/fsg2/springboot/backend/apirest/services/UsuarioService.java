package es.fsg2.springboot.backend.apirest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.fsg2.springboot.backend.apirest.dao.UsuarioDao;
import es.fsg2.springboot.backend.apirest.entity.Usuario;

@Service
public class UsuarioService implements GenericServiceInterface<Usuario, Integer>{


	@Autowired
	private UsuarioDao usuarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> findById(Integer id) {
		return usuarioDao.findById(id);
	}

	@Override
	public Usuario save(Usuario usuario) {
		return usuarioDao.save(usuario);
	}

	@Transactional
	public void delete(Integer id) {
		usuarioDao.deleteById(id);
	}

}
