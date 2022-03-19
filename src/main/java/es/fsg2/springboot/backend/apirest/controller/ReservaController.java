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

import es.fsg2.springboot.backend.apirest.entity.Reserva;
import es.fsg2.springboot.backend.apirest.services.ReservaService;


@RestController
@RequestMapping("/api")
public class ReservaController {
	
	@Autowired
	private ReservaService reservaService;
	
	@GetMapping("/reserva")
	public List<Reserva> index(){
		return reservaService.findAll();
	}
	
	@GetMapping("/reserva/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Reserva show(@PathVariable Integer id) {
		return reservaService.findById(id);
	}
	
	@PostMapping("/reserva")
	@ResponseStatus(HttpStatus.CREATED)
	public Reserva create(@RequestBody Reserva reserva) {
		return reservaService.save(reserva);
	}
	
	@PutMapping("/reserva/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Reserva update(@RequestBody Reserva reserva, @PathVariable Integer id) {
		Reserva reservaActual = reservaService.findById(id);
		
		reservaActual.setFecha(reserva.getFecha());
		reservaActual.setHora(reserva.getHora());
		
		//Usuario usuarioActual = usuarioService.findById(reserva.getFkusuario());
		reservaActual.setFkusuario(reserva.getFkusuario());
		return reservaService.save(reservaActual);
	}
	
	@DeleteMapping("/reserva/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		reservaService.delete(id);
	}
}
