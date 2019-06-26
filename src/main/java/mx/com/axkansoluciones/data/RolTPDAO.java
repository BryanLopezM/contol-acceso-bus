package mx.com.axkansoluciones.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import mx.com.axkansoluciones.model.RolTP;
import mx.com.axkansoluciones.util.HibernateUtil;

public class RolTPDAO implements DAOInterface<RolTP>{
	
	Transaction transaction = null;

	@Override
	public boolean registrar(RolTP value) {
		RolTP roltp = new RolTP("Otro");
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			
			transaction = session.beginTransaction();
			session.save(roltp);
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
	public List<RolTP> obtener() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			
			List<RolTP> roltp = session.createQuery("FROM RolTP", RolTP.class).list();
			roltp.forEach(rtp -> System.out.println(rtp.getId_rol_tp()+" "+rtp.getRol_tp()));
			RolTP rtp = session.find(RolTP.class, 1);
			
		} catch (Exception e) {
			
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean actualizar(RolTP value) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			
			//UPDATE EMPLEADO//
			session.beginTransaction();
			  RolTP roltp = (RolTP)session.get(RolTP.class, 1);
			  roltp.setRol_tp("Externo");
			  System.out.println("Modificacion exitosa");
			  session.getTransaction().commit();
			
		} catch (Exception ex) {
			if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean eliminar(RolTP value) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			
			//DELETE EMPLEADO//
			session.beginTransaction();
			  RolTP roltp = (RolTP)session.load(RolTP.class, 1);
			  session.delete(roltp);
			  System.out.println("Eliminado exitosamente");
			  session.getTransaction().commit();
			
		} catch (Exception ex) {
			if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
		}
		return false;
	}

}
