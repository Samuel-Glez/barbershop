package es.fsg2.springboot.backend.apirest.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="review")
public class Review implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idreview;
	
	private Integer estrellas;
	private String opiniones;
	
	private Integer fkusuario;

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

	public Integer getFkusuario() {
		return fkusuario;
	}

	public void setFkusuario(Integer fkusuario) {
		this.fkusuario = fkusuario;
	}
	
	

}
