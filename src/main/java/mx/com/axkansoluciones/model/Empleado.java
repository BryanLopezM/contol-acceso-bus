package mx.com.axkansoluciones.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "EMPLEADO")
public class Empleado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_empleado")
	private int id_empleado;
	@Column(name = "cv_empleado")
	private String cv_empleado;
	@Column(name = "fec_alta")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date fec_alta;
	@Column(name = "id_persona")
	private int id_persona;
	@Column(name = "id_area")
	private Integer id_area;
	@Column(name = "id_puesto")
	private Integer id_puesto;
	
	public Empleado() {
		
	}

	public Empleado(String cv_empleado, Date fec_alta, int id_persona, Integer id_area, Integer id_puesto) {
		super();
		this.cv_empleado = cv_empleado;
		this.fec_alta = fec_alta;
		this.id_persona = id_persona;
		this.id_area = id_area;
		this.id_puesto = id_puesto;
	}

	public int getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}

	public String getCv_empleado() {
		return cv_empleado;
	}

	public void setCv_empleado(String cv_empleado) {
		this.cv_empleado = cv_empleado;
	}

	public Date getFec_alta() {
		return fec_alta;
	}

	public void setFec_alta(Date fec_alta) {
		this.fec_alta = fec_alta;
	}

	public int getId_persona() {
		return id_persona;
	}

	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}

	public Integer getId_area() {
		return id_area;
	}

	public void setId_area(Integer id_area) {
		this.id_area = id_area;
	}

	public Integer getId_puesto() {
		return id_puesto;
	}

	public void setId_puesto(Integer id_puesto) {
		this.id_puesto = id_puesto;
	}

	@Override
	public String toString() {
		return "Empleado [id_empleado=" + id_empleado + ", cv_empleado=" + cv_empleado + 
				", fec_alta=" + fec_alta + ", id_persona=" + id_persona + ", id_area=" + 
				id_area + ", id_puesto=" + id_puesto + "]";
	}
	
	

}
