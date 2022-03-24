package es.fsg2.springboot.backend.apirest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.fsg2.springboot.backend.apirest.dto.RolDTO;
import es.fsg2.springboot.backend.apirest.entity.Rol;
import es.fsg2.springboot.backend.apirest.services.RolService;

@RestController
@RequestMapping("/api")
public class RolController {

	@Autowired
	private RolService rolService;

	@GetMapping("/rol")
	public List<Rol> geList() {
		List l = new ArrayList<RolDTO>();
		for (Rol r : rolService.findAll()) {
			l.add(new RolDTO(r));
		}
		return l;
	}

	@GetMapping("/rol/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getRolById(@PathVariable("id") Integer id) {
		Optional<Rol> optRol = rolService.findById(id);
		return ResponseEntity.ok(new RolDTO(optRol.get()));
	}

	@PostMapping("/rol")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> save(@RequestBody Rol rol) {
		Rol rolActual = new Rol();
		rolActual.setDescripcion(rol.getDescripcion());
		rolActual.setRol(rol.getDescripcion());
		rolService.save(rolActual);
		return ResponseEntity.ok().body(new RolDTO(rolActual));
	}

	@PutMapping("/rol/{id}")
	public ResponseEntity<?> update(@RequestBody RolDTO rol, @PathVariable Integer id) {
		Optional<Rol> optRol = rolService.findById(id);
		if (optRol.isPresent()) {
			Rol rolActual = optRol.get();
			rolActual.setDescripcion(rol.getDescripcion());
			rolActual.setRol(rol.getRol());
			rolService.save(rolActual);
			return ResponseEntity.ok().body(new RolDTO(rolActual));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("el id del registro no existe");
		}
	}

	@DeleteMapping("/rol/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		Optional<Rol> optRol = rolService.findById(id);
		if (optRol.isPresent()) {
			rolService.delete(id);
			return ResponseEntity.ok("Rol borrado");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("el id del registro no existe");
		}
	}
}
