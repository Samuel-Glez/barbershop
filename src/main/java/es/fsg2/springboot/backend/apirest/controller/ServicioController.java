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

import es.fsg2.springboot.backend.apirest.entity.Servicio;
import es.fsg2.springboot.backend.apirest.services.ServicioService;

@RestController
@RequestMapping("/api")
public class ServicioController {
	
	@Autowired
	private ServicioService servicioService;
	
	@GetMapping("/servicio")
	public List<Servicio> index(){
		return servicioService.findAll();
	}
	
	@GetMapping("/servicio/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Servicio show(@PathVariable Integer id) {
		return servicioService.findById(id);
	}
	
	@PostMapping("/servicio")
	@ResponseStatus(HttpStatus.CREATED)
	public Servicio create(@RequestBody Servicio servicio) {
		return servicioService.save(servicio);
	}
	
	@PutMapping("/servicio/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Servicio update(@RequestBody Servicio servicio, @PathVariable Integer id) {
		Servicio servicioActual = servicioService.findById(id);
		
		servicioActual.setServicio(servicio.getServicio());
		servicioActual.setPrecio(servicio.getPrecio());
		servicioActual.setTiempo(servicio.getTiempo());
		return servicioService.save(servicioActual);
	}
	
	@DeleteMapping("/servicio/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		servicioService.delete(id);
	}

}
