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

import es.fsg2.springboot.backend.apirest.dto.ReservaDTO;
import es.fsg2.springboot.backend.apirest.entity.Reserva;
import es.fsg2.springboot.backend.apirest.entity.Servicio;
import es.fsg2.springboot.backend.apirest.entity.Usuario;
import es.fsg2.springboot.backend.apirest.services.ReservaService;
import es.fsg2.springboot.backend.apirest.services.ServicioService;
import es.fsg2.springboot.backend.apirest.services.UsuarioService;

@RestController
@RequestMapping("/api")
public class ReservaController {

	@Autowired
	private ReservaService reservaService;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private ServicioService servicioService;

	@GetMapping("/reserva")
	public List<Reserva> getList() {
		List l = new ArrayList<ReservaDTO>();
		for (Reserva r : reservaService.findAll()) {
			l.add(new ReservaDTO(r));
		}
		return l;
	}

	@GetMapping("/reserva/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getReservaById(@PathVariable("id") Integer id) {
		Optional<Reserva> optReserva = reservaService.findById(id);
		return ResponseEntity.ok(new ReservaDTO(optReserva.get()));
	}

	@PostMapping("/reserva")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> save(@RequestBody ReservaDTO reserva) {
		Reserva reservaActual = new Reserva();
		reservaActual.setFecha(reserva.getFecha());
		reservaActual.setHora(reserva.getHora());
		Optional<Servicio> optServicio = servicioService.findById(reserva.getFkidservicio());
		if (optServicio.isPresent()) {
			reservaActual.setServicio(optServicio.get());
			Optional<Usuario> optUsuario = usuarioService.findById(reserva.getFkidusuario());
			if (optUsuario.isPresent()) {
				reservaActual.setUsuario(optUsuario.get());
				reservaService.save(reservaActual);
				return ResponseEntity.ok().body(new ReservaDTO(reservaActual));
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El usuario referenciado no existe");
			}
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El servicio referenciado no existe");
		}
	}

	@PutMapping("/reserva/{id}")
	public ResponseEntity<?> update(@RequestBody ReservaDTO reserva, @PathVariable Integer id) {
		Optional<Reserva> optReserva = reservaService.findById(id);
		if (optReserva.isPresent()) {
			Reserva reservaActual = optReserva.get();
			reservaActual.setFecha(reserva.getFecha());
			reservaActual.setHora(reserva.getHora());
			Optional<Servicio> optServicio = servicioService.findById(reserva.getFkidservicio());
			if (optServicio.isPresent()) {
				reservaActual.setServicio(optServicio.get());
				Optional<Usuario> optUsuario = usuarioService.findById(reserva.getFkidusuario());
				if (optUsuario.isPresent()) {
					reservaActual.setUsuario(optUsuario.get());
					reservaService.save(reservaActual);
					return ResponseEntity.ok().body(new ReservaDTO(reservaActual));
				} else {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El usuario referenciado no existe");
				}
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El servicio referenciado no existe");
			}

		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("el id del registro no existe");
		}
	}

	@DeleteMapping("/reserva/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		Optional<Reserva> optReserva = reservaService.findById(id);
		if (optReserva.isPresent()) {
			reservaService.delete(id);
			return ResponseEntity.ok("Reserva borrada");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("el id del registro no existe");
		}

	}
}
