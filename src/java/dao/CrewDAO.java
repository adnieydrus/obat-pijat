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
import org.hibernate.Transaction;
import pojo.Crew;
import util.HibernateUtil;

/**
 *
 * @author Windows 10 Pro
 */
public class CrewDAO {
    
    public void nambah(Crew kryObj){
         Transaction transObj = null;
         Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        
        try{
            transObj = sessionObj.beginTransaction();
            sessionObj.save(kryObj);
            transObj.commit();
            System.out.println("Berhasil memasukkan data baru..");
        }catch(Exception ex){
            ex.printStackTrace();
            transObj.rollback();
            System.out.println("gagal");
        }finally{
//            sessionObj.flush();
            sessionObj.close();
        }
    }
    
        public void addNewServicelist(Crew servicelist) {
            Transaction tx = null;
         Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			session.save(servicelist);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e);
		}
	}
        
        public List<Crew> getAllCrew() {
            Transaction tx = null;
         Session session = HibernateUtil.getSessionFactory().openSession();
		List<Crew> servicelist = new ArrayList<Crew>();
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("from Crew");
			servicelist = q.list();
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e);
		}
		return servicelist;
	}
        
        public List<Crew> getIDCrew()
        {
            Transaction transObj = null;
            Session sessionObj = HibernateUtil.getSessionFactory().openSession();
            List<Crew> listStudent = new ArrayList();
            
            try
            {
                transObj = sessionObj.beginTransaction();
                Query query = sessionObj.createQuery("select crewId from Crew");
                
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
        
        public List<Crew> getCrewByID(int selectedID)
        {
            Transaction transObj = null;
            Session sessionObj = HibernateUtil.getSessionFactory().openSession();
            List listStudent = new ArrayList();
            
            try
            {
                transObj = sessionObj.beginTransaction();
                
                Query query = sessionObj.createQuery("from Crew where CrewId = :id");
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
        
        public void updateMahasiswa(Crew mhsObj)
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
        
        public void deleteMahasiswa(Crew mhsObj)
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
        
        public Crew GetContactLastRecord(){
        Transaction transObj = null;
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        Crew ctc = null;
        try{
            transObj = sessionObj.beginTransaction();
            Query q = sessionObj.createQuery("from Crew order by CrewId desc");
            q.setMaxResults(1);
            ctc= (Crew) q.uniqueResult();
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
