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

import es.fsg2.springboot.backend.apirest.entity.Rol;
import es.fsg2.springboot.backend.apirest.services.RolService;

@RestController
@RequestMapping("/api")
public class RolController {

	@Autowired
	private RolService rolService;
	
	@GetMapping("/rol")
	public List<Rol> index(){
		return rolService.findAll();
	}
	
	@GetMapping("/rol/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Rol show(@PathVariable Integer id) {
		return rolService.findById(id);
	}
	
	@PostMapping("/rol")
	@ResponseStatus(HttpStatus.CREATED)
	public Rol create(@RequestBody Rol rol) {
		return rolService.save(rol);
	}
	
	@PutMapping("/rol/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Rol update(@RequestBody Rol rol, @PathVariable Integer id) {
		Rol rolActual = rolService.findById(id);
		
		rolActual.setRol(rol.getRol());
		rolActual.setDescripcion(rol.getDescripcion());
		return rolService.save(rolActual);
	}
	
	@DeleteMapping("/rol/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		rolService.delete(id);
	}
}
