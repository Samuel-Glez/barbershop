package es.fsg2.springboot.backend.apirest.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="reserva")
public class Reserva  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idreserva")
	private Integer idreserva;
	private String fecha;
	private String hora;
	private String horacancelada;
	private Integer duracion;
	private Integer ordenhora;
	private String status;
	
	@JoinColumn(name = "fkidservicio")
	@ManyToOne
	private Servicio servicio;
	
	@JoinColumn(name = "fkidusuario")
	@ManyToOne
	private Usuario usuario;
	
	@JoinColumn(name = "fkidpeluquero")
	@ManyToOne
	private Usuario peluquero;
	
	
	
	public Reserva() {
		super();
	}
	
	

	public Reserva(Integer idreserva, String fecha, String hora, String horacancelada, Integer duracion,
			Integer ordenhora, String status) {
		super();
		this.idreserva = idreserva;
		this.fecha = fecha;
		this.hora = hora;
		this.horacancelada = horacancelada;
		this.duracion = duracion;
		this.ordenhora = ordenhora;
		this.status = status;
	}

	public Integer getIdreserva() {
		return idreserva;
	}

	public void setIdreserva(Integer idreserva) {
		this.idreserva = idreserva;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public Usuario getPeluquero() {
		return peluquero;
	}



	public void setPeluquero(Usuario peluquero) {
		this.peluquero = peluquero;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}



	public Integer getOrdenhora() {
		return ordenhora;
	}



	public void setOrdenhora(Integer ordenhora) {
		this.ordenhora = ordenhora;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getHoracancelada() {
		return horacancelada;
	}



	public void setHoracancelada(String horacancelada) {
		this.horacancelada = horacancelada;
	}
	
	
	
	
	
	
	

}
