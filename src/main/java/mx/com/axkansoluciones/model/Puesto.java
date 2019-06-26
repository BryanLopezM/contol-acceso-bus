package mx.com.axkansoluciones.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PUESTO")
public class Puesto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_puesto")
	private int id_puesto;
	@Column(name = "puesto")
	private String puesto;
	
	public Puesto() {
		
	}

	public Puesto(String puesto) {
		super();
		this.puesto = puesto;
	}

	public int getId_puesto() {
		return id_puesto;
	}

	public void setId_puesto(int id_puesto) {
		this.id_puesto = id_puesto;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	@Override
	public String toString() {
		return "Puesto [id_puesto=" + id_puesto + ", puesto=" + puesto + "]";
	}
	
	

}
