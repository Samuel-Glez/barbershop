package es.fsg2.springboot.backend.apirest.dto;

import es.fsg2.springboot.backend.apirest.entity.Review;

public class ReviewDTO {
	
	private Integer idreview;
	private Integer estrellas;
	private String opiniones;
	private Integer fkidusuario;
	
	public ReviewDTO() {
		super();
	}
	
	public ReviewDTO(Review review) {
		super();
		idreview = review.getIdreview();
		estrellas = review.getEstrellas();
		opiniones = review.getOpiniones();
		fkidusuario = review.getUsuario().getIdusuario();
	}


	public ReviewDTO(Integer idreview, Integer estrellas, String opiniones, Integer fkidusuario) {
		super();
		this.idreview = idreview;
		this.estrellas = estrellas;
		this.opiniones = opiniones;
		this.fkidusuario = fkidusuario;
	}

	public Integer getIdreview() {
		return idreview;
	}

	public void setIdreview(Integer idreview) {
		this.idreview = idreview;
	}

	public Integer getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(Integer estrellas) {
		this.estrellas = estrellas;
	}

	public String getOpiniones() {
		return opiniones;
	}

	public void setOpiniones(String opiniones) {
		this.opiniones = opiniones;
	}

	public Integer getFkidusuario() {
		return fkidusuario;
	}

	public void setFkidusuario(Integer fkidusuario) {
		this.fkidusuario = fkidusuario;
	}
	
	
	

}
