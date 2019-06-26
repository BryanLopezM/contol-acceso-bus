package mx.com.axkansoluciones.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import mx.com.axkansoluciones.model.Puesto;
import mx.com.axkansoluciones.util.HibernateUtil;

public class PuestoDAO implements DAOInterface<Puesto>{

	Transaction transaction = null;

	@Override
	public boolean registrar(Puesto value) {
		
		Puesto puesto = new Puesto("Administrador");
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			
			transaction = session.beginTransaction();
			session.save(puesto);
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
	public List<Puesto> obtener() {
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			
			List<Puesto> puesto = session.createQuery("FROM Puesto", Puesto.class).list();
			puesto.forEach(pu -> System.out.println(pu.getId_puesto()+" "+pu.getPuesto()));
			Puesto pu = session.find(Puesto.class, 1);
			
		} catch (Exception e) {
			
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean actualizar(Puesto value) {
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			
			//UPDATE EMPLEADO//
			session.beginTransaction();
			Puesto puesto = (Puesto)session.get(Puesto.class, 1);
			  puesto.setPuesto("Ventas");
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
	public boolean eliminar(Puesto value) {
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			
			//DELETE EMPLEADO//
			session.beginTransaction();
			Puesto puesto = (Puesto)session.load(Puesto.class, 1);
			  session.delete(puesto);
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
