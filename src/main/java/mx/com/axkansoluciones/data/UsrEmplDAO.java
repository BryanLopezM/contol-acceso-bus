package mx.com.axkansoluciones.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import mx.com.axkansoluciones.model.UsrEmpl;
import mx.com.axkansoluciones.util.HibernateUtil;

public class UsrEmplDAO implements DAOInterface<UsrEmpl>{

	Transaction transaction = null;

	@Override
	public boolean registrar(UsrEmpl value) {
		UsrEmpl ue = new UsrEmpl("Pepe", 0, null);
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			
			transaction = session.beginTransaction();
			session.save(ue);
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
	public List<UsrEmpl> obtener() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			
			List<UsrEmpl> usrempl = session.createQuery("FROM UsrEmpl", UsrEmpl.class).list();
			usrempl.forEach(ue -> System.out.println(ue.getUname()+" "+ue.getId_empleado()+" "+ue.getFec_reg()));
			UsrEmpl ue = session.find(UsrEmpl.class, 1);
			
		} catch (Exception e) {
			
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean actualizar(UsrEmpl value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(UsrEmpl value) {
		// TODO Auto-generated method stub
		return false;
	}

}
