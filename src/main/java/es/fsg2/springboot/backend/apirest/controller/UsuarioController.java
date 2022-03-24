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

import es.fsg2.springboot.backend.apirest.dto.UsuarioDTO;
import es.fsg2.springboot.backend.apirest.entity.Rol;
import es.fsg2.springboot.backend.apirest.entity.Usuario;
import es.fsg2.springboot.backend.apirest.services.RolService;
import es.fsg2.springboot.backend.apirest.services.UsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private RolService rolService;

	@GetMapping("/usuarios")
	public List<Usuario> geList() {
		List l = new ArrayList<UsuarioDTO>();
		for (Usuario u : usuarioService.findAll()) {
			l.add(new UsuarioDTO(u));
		}
		return l;
	}

	@GetMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getUsuarioById(@PathVariable("id") Integer id) {
		Optional<Usuario> optUsuario = usuarioService.findById(id);
		return ResponseEntity.ok(new UsuarioDTO(optUsuario.get()));
	}

	@PostMapping("/usuarios")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> save(@RequestBody UsuarioDTO usuario) {
		Usuario usuarioActual = new Usuario();
		usuarioActual.setNombre(usuario.getNombre());
		usuarioActual.setApellidos(usuario.getApellidos());
		usuarioActual.setEmail(usuario.getEmail());
		usuarioActual.setTelefono(usuario.getTelefono());
		usuarioActual.setPassword(usuario.getPassword());
		Optional<Rol> optRol = rolService.findById(usuario.getFkidrol());
		if (optRol.isPresent()) {
			usuarioActual.setRol(optRol.get());
			usuarioService.save(usuarioActual);
			return ResponseEntity.ok().body(new UsuarioDTO(usuarioActual));
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El rol referenciado no existe");
		}
	}

	@PutMapping("/usuarios/{id}")
	public ResponseEntity<?> update(@RequestBody UsuarioDTO usuario, @PathVariable Integer id) {
		Optional<Usuario> optUsuario = usuarioService.findById(id);
		if (optUsuario.isPresent()) {
			Usuario usuarioActual = optUsuario.get();
			usuarioActual.setNombre(usuario.getNombre());
			usuarioActual.setApellidos(usuario.getApellidos());
			usuarioActual.setEmail(usuario.getEmail());
			usuarioActual.setTelefono(usuario.getTelefono());
			usuarioActual.setPassword(usuario.getPassword());
			Optional<Rol> optRol = rolService.findById(usuario.getFkidrol());
			if (optRol.isPresent()) {
				usuarioActual.setRol(optRol.get());
				usuarioService.save(usuarioActual);
				return ResponseEntity.ok().body(new UsuarioDTO(usuarioActual));
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El rol referenciado no existe");
			}
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("el id del registro no existe");
		}

	}

	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		Optional<Usuario> optUsuario = usuarioService.findById(id);
		if (optUsuario.isPresent()) {
			usuarioService.delete(id);
			return ResponseEntity.ok("Usuario borrado");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("el id del registro no existe");
		}
	}

}
