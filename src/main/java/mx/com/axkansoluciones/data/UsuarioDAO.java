package mx.com.axkansoluciones.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import mx.com.axkansoluciones.model.Usuario;
import mx.com.axkansoluciones.util.HibernateUtil;

public class UsuarioDAO implements DAOInterface<Usuario>{
	
	Transaction transaction = null;

	@Override
	public boolean registrar(Usuario value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Usuario> obtener() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			
			List<Usuario> usuario = session.createQuery("FROM Usuario", Usuario.class).list();
			usuario.forEach(us -> System.out.println(us.getUname()+" "+us.getPass()+" "+us.getFec_reg()));
			Usuario us = session.find(Usuario.class, 1);
			
		} catch (Exception e) {
			
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean actualizar(Usuario value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Usuario value) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/*public void getUsuario() {
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			
			List<Usuario> usuario = session.createQuery("FROM Usuario", Usuario.class).list();
			usuario.forEach(us -> System.out.println(us.getUname()+" "+us.getPass()+" "+us.getFec_reg()));
			Usuario us = session.find(Usuario.class, 1);
			
		} catch (Exception e) {
			
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
	}
	
	public void insertUsuario() {
		
		Usuario usuario = new Usuario("Finanzas", (byte)16, null);
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			
			transaction = session.beginTransaction();
			session.save(usuario);
			System.out.println("Agregado Exitosamente");
			transaction.commit();
			
		} catch (Exception ex) {
			
			if (transaction != null) {	
				transaction.rollback();
			}
			ex.printStackTrace();
		}
		
	}*/

}
