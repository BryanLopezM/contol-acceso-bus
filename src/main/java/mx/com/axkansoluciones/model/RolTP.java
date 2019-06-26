package mx.com.axkansoluciones.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ROL_TP")
public class RolTP implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_rol_tp", unique = true, nullable = true)
	private Integer id_rol_tp;
	@Column(name = "rol_tp")
	private String rol_tp;
	
	public RolTP() {
		
	}

	public RolTP(String rol_tp) {
		super();
		this.rol_tp = rol_tp;
	}

	public Integer getId_rol_tp() {
		return id_rol_tp;
	}

	public void setId_rol_tp(Integer id_rol_tp) {
		this.id_rol_tp = id_rol_tp;
	}

	public String getRol_tp() {
		return rol_tp;
	}

	public void setRol_tp(String rol_tp) {
		this.rol_tp = rol_tp;
	}

	@Override
	public String toString() {
		return "RolTP [id_rol_tp=" + id_rol_tp + ", rol_tp=" + rol_tp + "]";
	}
	
	

}
