package mx.com.axkansoluciones.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import mx.com.axkansoluciones.model.UsuarioRol;
import mx.com.axkansoluciones.util.HibernateUtil;

public class UsuarioRolDAO implements DAOInterface<UsuarioRol>{

	Transaction transaction = null;

	@Override
	public boolean registrar(UsuarioRol value) {
		UsuarioRol usr = new UsuarioRol("Empleado", 1);
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			
			transaction = session.beginTransaction();
			session.save(usr);
			System.out.println("Agregado Exitosamente");
			transaction.commit();
			
		} catch (Exception ex) {
			
			if (transaction != null) {	
				transaction.rollback();
			}
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public List<UsuarioRol> obtener() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			
			List<UsuarioRol> usuariorol = session.createQuery("FROM UsuarioRol", UsuarioRol.class).list();
			usuariorol.forEach(usr -> System.out.println(usr.getUname()+" "+usr.getId_rol()));
			UsuarioRol usr = session.find(UsuarioRol.class, 1);
			
		} catch (Exception e) {
			
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean actualizar(UsuarioRol value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(UsuarioRol value) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
