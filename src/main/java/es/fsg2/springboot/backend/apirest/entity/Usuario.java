package es.fsg2.springboot.backend.apirest.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idusuario")
	private Integer idusuario;

	private String nombre;
	private String apellidos;
	private String email;
	private Integer telefono;
	private String password;

	@JoinColumn(name = "fkidrol")
	@ManyToOne
	private Rol rol;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private Set<Review> reviews = new HashSet<>();

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private Set<Reserva> reservas = new HashSet<>();
	
	@OneToMany(mappedBy = "peluquero", cascade = CascadeType.ALL)
	private Set<Reserva> reservas2 = new HashSet<>();

	public Usuario() {
		super();
	}
	
	public Usuario(String nombre, String apellidos, String email, Integer telefono, String password, Rol rol) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.telefono = telefono;
		this.password = password;
		this.rol = rol;
	}

	public Integer getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@JsonIgnore
	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

	@JsonIgnore
	public Set<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(Set<Reserva> reservas) {
		this.reservas = reservas;
	}

	@JsonIgnore
	public Set<Reserva> getReserva() {
		return reservas2;
	}


	public void setReserva(Set<Reserva> reserva) {
		this.reservas2 = reserva;
	}

	
}
