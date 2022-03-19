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

import es.fsg2.springboot.backend.apirest.entity.Reserva_Servicio;
import es.fsg2.springboot.backend.apirest.entity.Reserva_Servicio;
import es.fsg2.springboot.backend.apirest.services.Reserva_ServicioService;

@RestController
@RequestMapping("/api")
public class Reserva_ServicioController {
	
	@Autowired
	private Reserva_ServicioService reserva_ServicioService;
	
	@GetMapping("/reservaservicio")
	public List<Reserva_Servicio> index(){
		return reserva_ServicioService.findAll();
	}
	
	@GetMapping("/reservaservicio/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Reserva_Servicio show(@PathVariable Integer id) {
		return reserva_ServicioService.findById(id);
	}
	
	@PostMapping("/reservaservicio")
	@ResponseStatus(HttpStatus.CREATED)
	public Reserva_Servicio create(@RequestBody Reserva_Servicio reserva_Servicio) {
		return reserva_ServicioService.save(reserva_Servicio);
	}
	
	@PutMapping("/reservaservicio/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Reserva_Servicio update(@RequestBody Reserva_Servicio reserva_Servicio, @PathVariable Integer id) {
		Reserva_Servicio reserva_ServicioActual = reserva_ServicioService.findById(id);
		
		reserva_ServicioActual.setFkreserva(reserva_Servicio.getFkreserva());
		reserva_ServicioActual.setFkservicio(reserva_Servicio.getFkservicio());
		return reserva_ServicioService.save(reserva_ServicioActual);
	}
	
	@DeleteMapping("/reservaservicio/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		reserva_ServicioService.delete(id);
	}

}
