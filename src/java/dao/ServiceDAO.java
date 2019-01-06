/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pojo.Service;
import util.HibernateUtil;

/**
 *
 * @author Windows 10 Pro
 */
public class ServiceDAO {
        private static SessionFactory sf = HibernateUtil.getSessionFactory();
	private static Transaction tx;

	public void addNewService(Service service) {
		try {
			Session session = sf.openSession();
			tx = session.beginTransaction();
			session.save(service);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e);
                }
	}
        public List<Service> getAllService() {
            Transaction tx = null;
         Session session = HibernateUtil.getSessionFactory().openSession();
		List<Service> servicelist = new ArrayList<Service>();
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("from Service");
			servicelist = q.list();
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e);
		}
		return servicelist;
	}
        
        public List<Service> getIDService()
        {
            Transaction transObj = null;
            Session sessionObj = HibernateUtil.getSessionFactory().openSession();
            List<Service> listStudent = new ArrayList();
            
            try
            {
                transObj = sessionObj.beginTransaction();
                Query query = sessionObj.createQuery("select serviceId from Service");
                
                listStudent = query.list();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
                transObj.rollback();
            }
            finally
            {
                sessionObj.flush();
                sessionObj.close();
            }
            
            
            return listStudent;
        }
        
        public List<Service> getServiceByID(int selectedID)
        {
            Transaction transObj = null;
            Session sessionObj = HibernateUtil.getSessionFactory().openSession();
            List listStudent = new ArrayList();
            
            try
            {
                transObj = sessionObj.beginTransaction();
                
                Query query = sessionObj.createQuery("from Service where ServiceId = :id");
                query.setInteger("id", selectedID);
                
                listStudent = query.list();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
                transObj.rollback();
            }
            finally
            {
                sessionObj.flush();
                sessionObj.close();
            }
            
            
            return listStudent;
        }
        
        public void updateMahasiswa(Service mhsObj)
        {
        Transaction transObj = null;
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
              transObj = sessionObj.beginTransaction();
              sessionObj.update(mhsObj);
              
              System.out.println("Berhasil mengupdate data baru..");
              
              transObj.commit();
        }
        catch(Exception ex)
        {
              ex.printStackTrace();
              transObj.rollback();
        }
        finally
        {
              sessionObj.flush();
              sessionObj.close();
        }
    }
        
        public void deleteMahasiswa(Service mhsObj)
        {
        Transaction transObj = null;
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
              transObj = sessionObj.beginTransaction();
              sessionObj.delete(mhsObj);
              
              System.out.println("Berhasil mengahapus data baru..");
              
              transObj.commit();
        }
        catch(Exception ex)
        {
              ex.printStackTrace();
              transObj.rollback();
        }
        finally
        {
              sessionObj.flush();
              sessionObj.close();
        }
    }
        
        public Service GetContactLastRecord(){
        Transaction transObj = null;
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        Service ctc = null;
        try{
            transObj = sessionObj.beginTransaction();
            Query q = sessionObj.createQuery("from Service order by ServiceId desc");
            q.setMaxResults(1);
            ctc= (Service) q.uniqueResult();
            transObj.commit();
        }catch (Exception ex){
            ex.printStackTrace();
            transObj.rollback();
            System.out.println(ex);
        }finally{
            sessionObj.flush();
            sessionObj.close();
        }
        return ctc;
    }
        
        
}
