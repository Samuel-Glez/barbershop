package es.fsg2.springboot.backend.apirest.dto;

import es.fsg2.springboot.backend.apirest.entity.Servicio;

public class ServicioDTO {
	
	private Integer idservicio;
	private String servicio;
	private Double precio;
	private Integer tiempo;

	public ServicioDTO() {
		super();
	}
	
	public ServicioDTO(Servicio servicios) {
		super();
		idservicio = servicios.getIdservicio();
		servicio = servicios.getServicio();
		precio = servicios.getPrecio();
		tiempo = servicios.getTiempo();
	}

	public ServicioDTO(Integer idservicio, String servicio, Double precio, Integer tiempo) {
		super();
		this.idservicio = idservicio;
		this.servicio = servicio;
		this.precio = precio;
		this.tiempo = tiempo;
	}

	public Integer getIdservicio() {
		return idservicio;
	}

	public void setIdservicio(Integer idservicio) {
		this.idservicio = idservicio;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getTiempo() {
		return tiempo;
	}

	public void setTiempo(Integer tiempo) {
		this.tiempo = tiempo;
	}

}
