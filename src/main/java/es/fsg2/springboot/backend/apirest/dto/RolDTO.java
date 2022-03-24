package es.fsg2.springboot.backend.apirest.dto;

import es.fsg2.springboot.backend.apirest.entity.Rol;

public class RolDTO {

	private Integer idrol;
	private String rol;
	private String descripcion;

	public RolDTO() {
		super();
	}
	
	public RolDTO(Rol rols) {
		super();
		idrol = rols.getIdrol();
		rol = rols.getRol();
		descripcion = rols.getDescripcion();
	}

	public RolDTO(Integer idrol, String rol, String descripcion) {
		super();
		this.idrol = idrol;
		this.rol = rol;
		this.descripcion = descripcion;
	}

	public Integer getIdrol() {
		return idrol;
	}

	public void setIdrol(Integer idrol) {
		this.idrol = idrol;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
