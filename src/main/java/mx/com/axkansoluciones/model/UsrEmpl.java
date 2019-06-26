package mx.com.axkansoluciones.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "USR_EMPL")
public class UsrEmpl implements Serializable{

	@Column(name = "uname")
	private String uname;
	@Id
	@Column(name = "id_empleado")
	private int id_empleado;
	@Column(name = "fec_reg")
	private Date fec_reg;
	
	public UsrEmpl() {
		
	}

	public UsrEmpl(String uname, int id_empleado, Date fec_reg) {
		super();
		this.uname = uname;
		this.id_empleado = id_empleado;
		this.fec_reg = fec_reg;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public int getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}

	public Date getFec_reg() {
		return fec_reg;
	}

	public void setFec_reg(Date fec_reg) {
		this.fec_reg = fec_reg;
	}

	@Override
	public String toString() {
		return "UsrEmpl [uname=" + uname + ", id_empleado=" + id_empleado + ", fec_reg=" + fec_reg + "]";
	}
	
	
	
}
