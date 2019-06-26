package mx.com.axkansoluciones.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "USUARIO_ROL")
public class UsuarioRol implements Serializable{
	
	@Column(name = "uname")
	private String uname;
	@Id
	@Column(name = "id_rol")
	private int id_rol;
	
	public UsuarioRol() {
		
	}

	public UsuarioRol(String uname, int id_rol) {
		super();
		this.uname = uname;
		this.id_rol = id_rol;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public int getId_rol() {
		return id_rol;
	}

	public void setId_rol(int id_rol) {
		this.id_rol = id_rol;
	}

	@Override
	public String toString() {
		return "UsuarioRol [uname=" + uname + ", id_rol=" + id_rol + "]";
	}
	
	

}
