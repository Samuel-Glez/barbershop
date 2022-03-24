package es.fsg2.springboot.backend.apirest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.fsg2.springboot.backend.apirest.dao.ReviewDao;
import es.fsg2.springboot.backend.apirest.entity.Review;
import es.fsg2.springboot.backend.apirest.entity.Rol;

@Service
public class ReviewService implements GenericServiceInterface<Review, Integer> {

	@Autowired
	private ReviewDao reviewDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Review> findAll() {
		return (List<Review>) reviewDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Review> findById(Integer id) {
		return reviewDao.findById(id);
	}

	@Override
	public Review save(Review review) {
		return reviewDao.save(review);
	}

	@Override
	public void delete(Integer id) {
		reviewDao.deleteById(id);
		
	}

}
