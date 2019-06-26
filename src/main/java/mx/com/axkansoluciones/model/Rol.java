package mx.com.axkansoluciones.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ROL")
public class Rol implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_rol", unique = true, nullable = true)
	private Integer id_rol;
	@Column(name = "rol")
	private String rol;
	/*@Column(name = "id_rol_tp")
	private int id_rol_tp;*/
	
	@ManyToOne
	@JoinColumn(name="id_rol_tp")
	private RolTP roltp;
	
	public Rol() {
		
	}

	

	public Rol(String rol, /*int id_rol_tp*/ RolTP roltp) {
		super();
		//this.id_rol = id_rol;
		this.rol = rol;
		this.roltp = roltp;
		//this.id_rol_tp = id_rol_tp;
	}



	public Integer getId_rol() {
		return id_rol;
	}

	public void setId_rol(Integer id_rol) {
		this.id_rol = id_rol;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	/*public int getId_rol_tp() {
		return id_rol_tp;
	}

	public void setId_rol_tp(int id_rol_tp) {
		this.id_rol_tp = id_rol_tp;
	}*/

	public RolTP getRoltp() {
		return roltp;
	}

	public void setRoltp(RolTP roltp) {
		this.roltp = roltp;
	}



	@Override
	public String toString() {
		return "Rol [id_rol=" + id_rol + ", rol=" + rol + ", roltp =" + roltp + "]";
	}
	
	

}
