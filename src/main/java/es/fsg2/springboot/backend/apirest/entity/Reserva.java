package es.fsg2.springboot.backend.apirest.entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private Integer idreserva;
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	private Time hora;
	
	//@ManyToOne(optional = false)
	private Integer fkusuario;

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

	public Integer getFkusuario() {
		return fkusuario;
	}

	public void setFkusuario(Integer fkusuario) {
		this.fkusuario = fkusuario;
	}

	

	


}
