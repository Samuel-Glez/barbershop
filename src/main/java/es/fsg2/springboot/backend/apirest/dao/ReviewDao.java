package es.fsg2.springboot.backend.apirest.dao;

import org.springframework.data.repository.CrudRepository;

import es.fsg2.springboot.backend.apirest.entity.Review;

public interface ReviewDao extends CrudRepository<Review, Integer>{

}
