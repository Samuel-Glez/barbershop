package es.fsg2.springboot.backend.apirest.dto;

import java.sql.Time;
import java.util.Date;

import es.fsg2.springboot.backend.apirest.entity.Reserva;

public class ReservaDTO {

	
	private Integer idreserva;
	
	private Date fecha;
	private Time hora;
    private Integer fkidservicio;
	private Integer fkidusuario;

	

	public ReservaDTO() {
	}
	
	public ReservaDTO(Reserva reserva) {
		super();
		idreserva = reserva.getIdreserva();
		fecha = reserva.getFecha();
		hora = reserva.getHora();
		fkidservicio = reserva.getServicio().getIdservicio();
		fkidusuario = reserva.getUsuario().getIdusuario();
	}
	
	public ReservaDTO(Integer idreserva, Date fecha, Time hora, Integer servicio, Integer usuario) {
		super();
		this.idreserva = idreserva;
		this.fecha = fecha;
		this.hora = hora;
		this.fkidservicio = servicio;
		this.fkidusuario = usuario;
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

	public Integer getFkidservicio() {
		return fkidservicio;
	}

	public void setFkidservicio(Integer fkidservicio) {
		this.fkidservicio = fkidservicio;
	}

	public Integer getFkidusuario() {
		return fkidusuario;
	}

	public void setFkidusuario(Integer fkidusuario) {
		this.fkidusuario = fkidusuario;
	}



	
	
}
