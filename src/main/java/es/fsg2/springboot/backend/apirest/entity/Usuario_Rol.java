package es.fsg2.springboot.backend.apirest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuariorol")
public class Usuario_Rol {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idusuariorol;
	
	private Integer fkusuario;
	private Integer fkrol;
	
	public Integer getIdusuariorol() {
		return idusuariorol;
	}
	public void setIdusuariorol(Integer idusuariorol) {
		this.idusuariorol = idusuariorol;
	}
	public Integer getFkusuario() {
		return fkusuario;
	}
	public void setFkusuario(Integer fkusuario) {
		this.fkusuario = fkusuario;
	}
	public Integer getFkrol() {
		return fkrol;
	}
	public void setFkrol(Integer fkrol) {
		this.fkrol = fkrol;
	}
	
	

}
