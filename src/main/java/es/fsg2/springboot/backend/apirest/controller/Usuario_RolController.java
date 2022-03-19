package es.fsg2.springboot.backend.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import es.fsg2.springboot.backend.apirest.entity.Usuario_Rol;
import es.fsg2.springboot.backend.apirest.services.Usuario_RolService;

@RestController
@RequestMapping("/api")
public class Usuario_RolController {
	
	@Autowired
	private Usuario_RolService usuario_RolService;
	
	@GetMapping("/usuariorol")
	public List<Usuario_Rol> index(){
		return usuario_RolService.findAll();
	}
	
	@GetMapping("/usuariorol/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Usuario_Rol show(@PathVariable Integer id) {
		return usuario_RolService.findById(id);
	}
	
	@PostMapping("/usuariorol")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario_Rol create(@RequestBody Usuario_Rol reserva_Servicio) {
		return usuario_RolService.save(reserva_Servicio);
	}
	
	@PutMapping("/usuariorol/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario_Rol update(@RequestBody Usuario_Rol usuario_Rol, @PathVariable Integer id) {
		Usuario_Rol usuario_RolActual = usuario_RolService.findById(id);
		
		usuario_RolActual.setFkusuario(usuario_Rol.getFkusuario());
		usuario_RolActual.setFkrol(usuario_Rol.getFkrol());
		return usuario_RolService.save(usuario_RolActual);
	}
	
	@DeleteMapping("/usuariorol/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		usuario_RolService.delete(id);
	}

}
