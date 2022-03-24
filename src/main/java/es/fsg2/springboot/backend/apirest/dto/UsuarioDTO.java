package es.fsg2.springboot.backend.apirest.dto;

import es.fsg2.springboot.backend.apirest.entity.Usuario;

public class UsuarioDTO {

private Integer idusuario;
	
	private String nombre;
	private String apellidos;
	private String email;
	private Integer telefono;
	private String password;
	private Integer fkidrol;
	
	public UsuarioDTO() {
		super();
	}
	
	public UsuarioDTO(Usuario usuario) {
		super();
		idusuario = usuario.getIdusuario();
		nombre = usuario.getNombre();
		apellidos = usuario.getApellidos();
		email = usuario.getEmail();
		telefono = usuario.getTelefono();
		password = usuario.getPassword();
		fkidrol = usuario.getRol().getIdrol();
	}

	public UsuarioDTO(Integer idusuario, String nombre, String apellidos, String email, Integer telefono,
			String password, Integer fkidrol) {
		super();
		this.idusuario = idusuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.telefono = telefono;
		this.password = password;
		this.fkidrol = fkidrol;
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

	public Integer getFkidrol() {
		return fkidrol;
	}

	public void setFkidrol(Integer fkidrol) {
		this.fkidrol = fkidrol;
	}
	
	
	
	
	
	
	
}
