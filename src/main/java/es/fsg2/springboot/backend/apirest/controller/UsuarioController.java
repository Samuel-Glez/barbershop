package es.fsg2.springboot.backend.apirest.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.fsg2.springboot.backend.apirest.entity.Usuario;
import es.fsg2.springboot.backend.apirest.services.UsuarioService;
import es.fsg2.springboot.backend.apirest.dao.UsuarioDao;

@RestController
@RequestMapping("/api")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/usuarios")
	public List<Usuario> index(){
		return usuarioService.findAll();
	}
	
	@GetMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Usuario show(@PathVariable Integer id) {
		return usuarioService.findById(id);
	}
	
	@PostMapping("/usuarios")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario create(@RequestBody Usuario usuario) {
		return usuarioService.save(usuario);
	}
	
	@PutMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario update(@RequestBody Usuario usuario, @PathVariable Integer id) {
		Usuario usuarioActual = usuarioService.findById(id);
		
		usuarioActual.setNombre(usuario.getNombre());
		usuarioActual.setApellidos(usuario.getApellidos());
		usuarioActual.setEmail(usuario.getEmail());
		usuarioActual.setTelefono(usuario.getTelefono());
		usuarioActual.setPassword(usuario.getPassword());
		return usuarioService.save(usuarioActual);
	}
	
	@DeleteMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		usuarioService.delete(id);
	}
	

}
