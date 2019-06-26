package mx.com.axkansoluciones.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable{
	@Id
	@Column(name = "uname")
	private String uname;
	@Column(name = "pass")
	private byte pass;
	@Column(name = "fec_reg")
	private Date fec_reg;
	
	public Usuario() {
		
	}

	public Usuario(String uname, byte pass, Date fec_reg) {
		super();
		this.uname = uname;
		this.pass = pass;
		this.fec_reg = fec_reg;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public byte getPass() {
		return pass;
	}

	public void setPass(byte pass) {
		this.pass = pass;
	}

	public Date getFec_reg() {
		return fec_reg;
	}

	public void setFec_reg(Date fec_reg) {
		this.fec_reg = fec_reg;
	}

	@Override
	public String toString() {
		return "Usuario [uname=" + uname + ", pass=" + pass + ", fec_reg=" + fec_reg + "]";
	}
	
	
	
}
