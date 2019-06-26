package mx.com.axkansoluciones.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.omg.CORBA.Request;

import mx.com.axkansoluciones.model.Rol;
import mx.com.axkansoluciones.model.RolTP;
import mx.com.axkansoluciones.util.HibernateUtil;

public class RolDAO implements DAOInterface<Rol>{
	
	Transaction transaction = null;

	@Override
	public boolean registrar(Rol value) {
		
		Rol rol = new Rol();
		RolTP roltp = new RolTP();
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			
			transaction = session.beginTransaction();
			rol.setRol("prueba");
			roltp.setId_rol_tp(2);
			rol.setRoltp(roltp);
			session.save(rol);
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
	public List<Rol> obtener() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			
			/*List<Rol> rol = session.createQuery("FROM Rol AS rol inner join rol.roltp AS rtp", Rol.class).list();
			rol.forEach(ro -> System.out.println(ro.getId_rol()+" "+ro.getRol()+" "+ro.getRoltp()));
			Rol ro = session.find(Rol.class, 1);*/
			
			String hql = "from Rol";
			List<Rol> list = session.createQuery(hql,Rol.class).list();
			list.forEach(item->{
				System.out.println(item);
			});
			
			/*
			 * for(Rol item:list) { System.out.println(item); }
			 */
			/*
			 * for(int i=0; i<list.size(); i++) { Object[] row = (Object[]) list.get(i); Rol
			 * rol = (Rol)row[0]; RolTP roltp = (RolTP)row[1];
			 * System.out.println("ID:"+rol.getId_rol()+", ROL:"+ rol.getRol()+ ", ID:"+
			 * roltp.getId_rol_tp()+", EmpName:"+ roltp.getRol_tp()); }
			 */
			
		} catch (Exception e) {
			
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean actualizar(Rol value) {
		RolTP roltp = new RolTP();
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			
			//UPDATE EMPLEADO//
			session.beginTransaction();
			  Rol rol = (Rol)session.get(Rol.class, 2);
			  rol.setRol("Prueba1");
			  roltp.setId_rol_tp(4);
			  rol.setRoltp(roltp);
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
	public boolean eliminar(Rol value) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			
			//DELETE EMPLEADO//
			session.beginTransaction();
			  Rol rol = (Rol)session.load(Rol.class, 2);
			  session.delete(rol);
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
