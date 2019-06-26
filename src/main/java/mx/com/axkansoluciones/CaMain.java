package mx.com.axkansoluciones;

import mx.com.axkansoluciones.data.AreaDAO;
import mx.com.axkansoluciones.data.DAOInterface;
import mx.com.axkansoluciones.data.EmpleadoDAO;
import mx.com.axkansoluciones.data.PersonaDAO;
import mx.com.axkansoluciones.data.RolDAO;
import mx.com.axkansoluciones.data.UsuarioDAO;

public class CaMain {

	public static void main(String[] args) {

		DAOInterface dao = new RolDAO();
		//dao.registrar(null);
		//dao.actualizar(null);
		//dao.eliminar(null);
		dao.obtener();
		
	}

}
