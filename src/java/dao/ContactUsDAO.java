/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import pojo.Contactus;
import util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Windows 10 Pro
 */
public class ContactUsDAO {
    public void nambah(Contactus kryObj){
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
            sessionObj.flush();
            sessionObj.close();
        }
    }
    
    public List<Contactus> getAllContactUs()
        {
        Transaction transObj = null;
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        List<Contactus> listMhs = new ArrayList();
        
        try
        {
              transObj = sessionObj.beginTransaction();
              Query query = sessionObj.createQuery("from Contactus");
              
              listMhs =  query.list();
              
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
        return listMhs;
        }
    
    public List<Contactus> getIDContactUs()
        {
            Transaction transObj = null;
            Session sessionObj = HibernateUtil.getSessionFactory().openSession();
            List<Contactus> listStudent = new ArrayList();
            
            try
            {
                transObj = sessionObj.beginTransaction();
                Query query = sessionObj.createQuery("select contactId from Contactus");
                
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
        
        public List<Contactus> getContactUsByID(int selectedID)
        {
            Transaction transObj = null;
            Session sessionObj = HibernateUtil.getSessionFactory().openSession();
            List listStudent = new ArrayList();
            
            try
            {
                transObj = sessionObj.beginTransaction();
                
                Query query = sessionObj.createQuery("from Contactus where ContactId = :id");
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
        
        public void updateMahasiswa(Contactus mhsObj)
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
        
        public void deleteMahasiswa(Contactus mhsObj)
        {
        Transaction transObj = null;
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
              transObj = sessionObj.beginTransaction();
              sessionObj.delete(mhsObj);
              
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
    
        public Contactus GetContactLastRecord(){
        Transaction transObj = null;
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        Contactus ctc = null;
        try{
            transObj = sessionObj.beginTransaction();
            Query q = sessionObj.createQuery("from Contactus order by ContactId desc");
            q.setMaxResults(1);
            ctc= (Contactus) q.uniqueResult();
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
