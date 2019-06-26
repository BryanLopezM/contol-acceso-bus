package mx.com.axkansoluciones.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import mx.com.axkansoluciones.model.Area;
import mx.com.axkansoluciones.util.HibernateUtil;

public class AreaDAO implements DAOInterface<Area>{

	Transaction transaction = null;

	@Override
	public boolean registrar(Area value) {
		
		Area area = new Area("Ventas");
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			
			transaction = session.beginTransaction();
			session.save(area);
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
	public List<Area> obtener() {
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			
			List<Area> area = session.createQuery("FROM Area", Area.class).list();
			area.forEach(ar -> System.out.println(ar.getId_area()+" "+ ar.getArea()));
			Area ar = session.find(Area.class, 1);
			
		} catch (Exception e) {
			
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean actualizar(Area value) {
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			
			session.beginTransaction();
			  Area area = (Area)session.get(Area.class, 3);
			  area.setArea("Recursos Humanos");
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
	public boolean eliminar(Area value) {
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			
			session.beginTransaction();
			  Area area = (Area)session.load(Area.class, 4);
			  session.delete(area);
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