package es.fsg2.springboot.backend.apirest.controller;

import java.util.List;

import javax.print.DocFlavor.READER;

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

import es.fsg2.springboot.backend.apirest.entity.Review;
import es.fsg2.springboot.backend.apirest.entity.Rol;
import es.fsg2.springboot.backend.apirest.services.ReviewService;

@RestController
@RequestMapping("/api")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	@GetMapping("/review")
	public List<Review> index(){
		return reviewService.findAll();
	}
	
	@GetMapping("/review/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Review show(@PathVariable Integer id) {
		return reviewService.findById(id);
	}
	
	@PostMapping("/review")
	@ResponseStatus(HttpStatus.CREATED)
	public Review create(@RequestBody Review review) {
		return reviewService.save(review);
	}
	
	@PutMapping("/review/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Review update(@RequestBody Review review, @PathVariable Integer id) {
		Review reviewActual = reviewService.findById(id);
		
		reviewActual.setEstrellas(review.getEstrellas());
		reviewActual.setOpiniones(review.getOpiniones());
		reviewActual.setFkusuario(review.getFkusuario());
		return reviewService.save(reviewActual);
	}
	
	@DeleteMapping("/review/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		reviewService.delete(id);
	}
}
