package mx.com.axkansoluciones.data;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import mx.com.axkansoluciones.model.Empleado;
import mx.com.axkansoluciones.util.HibernateUtil;


public class EmpleadoDAO implements DAOInterface<Empleado>{

	Transaction transaction = null;

	@Override
	public boolean registrar(Empleado value) {
		
		Empleado empleado = new Empleado("Trabajador", Calendar.getInstance().getTime(), 2, 2, 2);
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			
			transaction = session.beginTransaction();
			session.save(empleado);
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
	public List<Empleado> obtener() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			
			List<Empleado> empleado = session.createQuery("FROM Empleado", Empleado.class).list();
			empleado.forEach(em -> System.out.println(em.getId_empleado()+" | "+em.getCv_empleado()
			+" | "+em.getFec_alta()+" | "+em.getId_persona()+" | "+em.getId_area()
			+" | "+em.getId_puesto()));
			Empleado em = session.find(Empleado.class, 1);
			
		} catch (Exception e) {
			
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean actualizar(Empleado value) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			
			//UPDATE EMPLEADO//
			session.beginTransaction();
			  Empleado empleado = (Empleado)session.get(Empleado.class, 1);
			  empleado.setCv_empleado("Emplead@");
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
	public boolean eliminar(Empleado value) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			
			//DELETE EMPLEADO//
			session.beginTransaction();
			Empleado empleado = (Empleado)session.load(Empleado.class, 2);
			  session.delete(empleado);
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
