package mx.com.axkansoluciones.data;

import java.util.List;

public interface DAOInterface<T> {
	
		public boolean registrar(T value);
		public List<T> obtener();
		public boolean actualizar(T value);
		public boolean eliminar(T value);

}
