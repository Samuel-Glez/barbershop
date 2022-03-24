package es.fsg2.springboot.backend.apirest.entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.Collection;
import java.util.Date;

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

import es.fsg2.springboot.backend.apirest.entity.Usuario;

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
	@Temporal(TemporalType.DATE)
	private Date fecha;
	private Time hora;
	
	@JoinColumn(name = "fkidservicio")
	@ManyToOne
	private Servicio servicio;
	
	@JoinColumn(name = "fkidusuario")
	@ManyToOne
	private Usuario usuario;
	
	
	
	public Reserva() {
		super();
	}
	
	

	public Reserva(Integer idreserva, Date fecha, Time hora, Servicio servicio) {
		super();
		this.idreserva = idreserva;
		this.fecha = fecha;
		this.hora = hora;
		this.servicio = servicio;
	}



	public Reserva(Integer idreserva, Date fecha, Time hora, Servicio servicio, Usuario usuario) {
		super();
		this.idreserva = idreserva;
		this.fecha = fecha;
		this.hora = hora;
		this.servicio = servicio;
		this.usuario = usuario;
	}

	public Integer getIdreserva() {
		return idreserva;
	}

	public void setIdreserva(Integer idreserva) {
		this.idreserva = idreserva;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
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

}
