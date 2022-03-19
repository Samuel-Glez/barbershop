package es.fsg2.springboot.backend.apirest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reservaservicio")
public class Reserva_Servicio {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idreservaservicio;
	
	private Integer fkreserva;
	private Integer fkservicio;
	
	public Integer getIdreservaservicio() {
		return idreservaservicio;
	}
	public void setIdreservaservicio(Integer idreservaservicio) {
		this.idreservaservicio = idreservaservicio;
	}
	public Integer getFkreserva() {
		return fkreserva;
	}
	public void setFkreserva(Integer fkreserva) {
		this.fkreserva = fkreserva;
	}
	public Integer getFkservicio() {
		return fkservicio;
	}
	public void setFkservicio(Integer fkservicio) {
		this.fkservicio = fkservicio;
	}
	
	
	

}
