package es.fsg2.springboot.backend.apirest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.fsg2.springboot.backend.apirest.dto.ServicioDTO;
import es.fsg2.springboot.backend.apirest.entity.Servicio;
import es.fsg2.springboot.backend.apirest.services.ServicioService;

@RestController
@RequestMapping("/api")
public class ServicioController {

	@Autowired
	private ServicioService servicioService;

	@CrossOrigin("http://localhost:8100/")
	@GetMapping("/servicio")
	public List<Servicio> getList() {
		List l = new ArrayList<ServicioDTO>();
		for (Servicio s : servicioService.findAll()) {
			l.add(new ServicioDTO(s));
		}
		return l;
	}
	
	@CrossOrigin("http://localhost:8100/")
	@GetMapping("/servicio/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getServicioById(@PathVariable("id") Integer id) {
		Optional<Servicio> optServicio = servicioService.findById(id);
		return ResponseEntity.ok(new ServicioDTO(optServicio.get()));
	}
	
	@CrossOrigin("http://localhost:8100/")
	@PostMapping("/servicio")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> save(@RequestBody Servicio servicio) {
		Servicio servicioActual = new Servicio();
		servicioActual.setPrecio(servicio.getPrecio());
		servicioActual.setServicio(servicio.getServicio());
		servicioActual.setTiempo(servicio.getTiempo());
		servicioService.save(servicioActual);
		return ResponseEntity.ok().body(new ServicioDTO(servicioActual));
	}
	
	@CrossOrigin("http://localhost:8100/")
	@PutMapping("/servicio/{id}")
	public ResponseEntity<?> update(@RequestBody ServicioDTO servicio, @PathVariable Integer id) {
		Optional<Servicio> optServicio = servicioService.findById(id);
		if (optServicio.isPresent()) {
			Servicio servicioActual = optServicio.get();
			servicioActual.setServicio(servicio.getServicio());
			servicioActual.setPrecio(servicio.getPrecio());
			servicioActual.setTiempo(servicio.getTiempo());
			servicioService.save(servicioActual);
			return ResponseEntity.ok().body(new ServicioDTO(servicioActual));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("el id del registro no existe");
	}
	
	@CrossOrigin("http://localhost:8100/")
	@DeleteMapping("/servicio/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		Optional<Servicio> optServicio = servicioService.findById(id);
		if (optServicio.isPresent()) {
			servicioService.delete(id);
			return ResponseEntity.ok("Servicio borrado");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("el id del registro no existe");
		}
	}

}
