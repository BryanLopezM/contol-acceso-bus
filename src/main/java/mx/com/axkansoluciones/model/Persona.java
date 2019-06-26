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
@Table(name = "PERSONA")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_persona")
	private int id_persona;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "paterno")
	private String paterno;
	@Column(name = "materno")
	private String materno;
	@Column(name = "fec_nac")
	@Temporal(TemporalType.DATE)
	private Date fec_nac;
	
	public Persona() {
		
	}

	public Persona(String nombre, String paterno, String materno, Date fec_nac) {
		super();
		this.nombre = nombre;
		this.paterno = paterno;
		this.materno = materno;
		this.fec_nac = fec_nac;
	}

	public int getId_persona() {
		return id_persona;
	}

	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public Date getFec_nac() {
		return fec_nac;
	}

	public void setFec_nac(Date fec_nac) {
		this.fec_nac = fec_nac;
	}

	@Override
	public String toString() {
		return "Persona [id_persona=" + id_persona + ", nombre=" + nombre + ", paterno=" + paterno + ", materno="
				+ materno + ", fec_nac=" + fec_nac + "]";
	}
	
	

}
