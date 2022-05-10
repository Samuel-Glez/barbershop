package es.fsg2.springboot.backend.apirest.dto;

import java.sql.Time;
import java.util.Date;

import es.fsg2.springboot.backend.apirest.entity.Reserva;

public class ReservaDTO {

	
	private Integer idreserva;
	private String fecha;
	private String hora;
	private String horacancelada;
	private Integer ordenhora;
	private Integer duracion;
    private Integer fkidservicio;
	private Integer fkidusuario;
	private Integer fkidpeluquero;
	private String status;

	

	public ReservaDTO() {
	}
	
	public ReservaDTO(Reserva reserva) {
		super();
		idreserva = reserva.getIdreserva();
		fecha = reserva.getFecha();
		hora = reserva.getHora();
		horacancelada = reserva.getHoracancelada();
		ordenhora = reserva.getOrdenhora();
		duracion = reserva.getDuracion();
		fkidservicio = reserva.getServicio().getIdservicio();
		fkidusuario = reserva.getUsuario().getIdusuario();
		fkidpeluquero = reserva.getPeluquero().getIdusuario();
		status = reserva.getStatus();
	}
	
	public ReservaDTO(Integer idreserva, String fecha, String hora, String horacancelada, Integer ordenhora,
			Integer duracion, Integer fkidservicio, Integer fkidusuario, Integer fkidpeluquero, String status) {
		super();
		this.idreserva = idreserva;
		this.fecha = fecha;
		this.hora = hora;
		this.horacancelada = horacancelada;
		this.ordenhora = ordenhora;
		this.duracion = duracion;
		this.fkidservicio = fkidservicio;
		this.fkidusuario = fkidusuario;
		this.fkidpeluquero = fkidpeluquero;
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

	public String getHoracancelada() {
		return horacancelada;
	}

	public void setHoracancelada(String horacancelada) {
		this.horacancelada = horacancelada;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
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

	public Integer getFkidpeluquero() {
		return fkidpeluquero;
	}

	public void setFkidpeluquero(Integer fkidpeluquero) {
		this.fkidpeluquero = fkidpeluquero;
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
	
	

}
