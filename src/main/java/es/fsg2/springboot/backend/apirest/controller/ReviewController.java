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

import es.fsg2.springboot.backend.apirest.dto.ReviewDTO;
import es.fsg2.springboot.backend.apirest.entity.Review;
import es.fsg2.springboot.backend.apirest.entity.Usuario;
import es.fsg2.springboot.backend.apirest.services.ReviewService;
import es.fsg2.springboot.backend.apirest.services.UsuarioService;

@RestController
@RequestMapping("/api")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/review")
	public List<Review> getList() {
		List l = new ArrayList<ReviewDTO>();
		for (Review r : reviewService.findAll()) {
			l.add(new ReviewDTO(r));
		}
		return l;
	}

	@GetMapping("/review/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getReviewById(@PathVariable("id") Integer id) {
		Optional<Review> optReview = reviewService.findById(id);
		return ResponseEntity.ok(new ReviewDTO(optReview.get()));
	}

	@PostMapping("/review")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> save(@RequestBody ReviewDTO review) {
		Review reviewActual = new Review();
		reviewActual.setEstrellas(review.getEstrellas());
		reviewActual.setOpiniones(review.getOpiniones());
		Optional<Usuario> optUsuario = usuarioService.findById(review.getFkidusuario());
		if (optUsuario.isPresent()) {
			reviewActual.setUsuario(optUsuario.get());
			reviewService.save(reviewActual);
			return ResponseEntity.ok().body(new ReviewDTO(reviewActual));
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El usuario referenciado no existe");
		}
	}

	@PutMapping("/review/{id}")
	public ResponseEntity<?> update(@RequestBody ReviewDTO review, @PathVariable Integer id) {
		Optional<Review> optReview = reviewService.findById(id);
		if (optReview.isPresent()) {
			Review reviewActual = optReview.get();
			reviewActual.setEstrellas(review.getEstrellas());
			reviewActual.setOpiniones(review.getOpiniones());
			Optional<Usuario> optUsuario = usuarioService.findById(review.getFkidusuario());
			if (optUsuario.isPresent()) {
				reviewActual.setUsuario(optUsuario.get());
				reviewService.save(reviewActual);
				return ResponseEntity.ok().body(new ReviewDTO(reviewActual));
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El usuario referenciado no existe");
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("el id del registro no existe");
	}

	@DeleteMapping("/review/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		Optional<Review> optReview = reviewService.findById(id);
		if (optReview.isPresent()) {
			reviewService.delete(id);
			return ResponseEntity.ok("Review borrada");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("el id del registro no existe");
		}

	}
}
