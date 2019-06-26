package mx.com.axkansoluciones.data;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import mx.com.axkansoluciones.model.Persona;
import mx.com.axkansoluciones.util.HibernateUtil;

public class PersonaDAO implements DAOInterface<Persona>{
	
	Transaction transaction = null;

	@Override
	public boolean registrar(Persona value) {
		
		//Date d = new Date(2019, 06, 05
		Calendar d = Calendar.getInstance();
		d.set(1998,5,05);
		
		Persona pe = new Persona("Gerardo", "Aguilar", "Lopez", d.getTime());//Calendar.getInstance().getTime());
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			
			transaction = session.beginTransaction();
			session.save(pe);
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
	public List<Persona> obtener() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			
			List<Persona> persona = session.createQuery("FROM Persona", Persona.class).list();
			persona.forEach(pe -> System.out.println(pe.getId_persona()+" "+pe.getNombre()+" "+pe.getPaterno()+" "+pe.getMaterno()+" "+pe.getFec_nac()));
			Persona pe = session.find(Persona.class, 1);
			
		} catch (Exception e) {
			
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean actualizar(Persona value) {
		
		Calendar d = Calendar.getInstance();
		d.set(1998,5,06);
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			
			//UPDATE EMPLEADO//
			session.beginTransaction();
			  Persona pe = (Persona)session.get(Persona.class, 7);
			  pe.setFec_nac(d.getTime());
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
	public boolean eliminar(Persona value) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			
			//DELETE EMPLEADO//
			session.beginTransaction();
			  Persona pe = (Persona)session.load(Persona.class, 6);
			  Persona pee = (Persona)session.load(Persona.class, 7);
			  session.delete(pe);
			  session.delete(pee);
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
