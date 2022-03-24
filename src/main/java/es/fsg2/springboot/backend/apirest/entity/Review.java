package es.fsg2.springboot.backend.apirest.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@Column(name = "idreview")
	private Integer idreview;
	
	private Integer estrellas;
	private String opiniones;
	
	@JoinColumn(name = "fkidusuario")
	@ManyToOne
	private Usuario usuario;
	
	public Review() {
		super();
	}
	
	public Review(Integer idreview, Integer estrellas, String opiniones, Usuario usuario) {
		super();
		this.idreview = idreview;
		this.estrellas = estrellas;
		this.opiniones = opiniones;
		this.usuario = usuario;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	

	
}
