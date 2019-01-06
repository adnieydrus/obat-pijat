/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import pojo.Register;
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
public class RegisterDAO {
    public void nambah(Register kryObj){
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
            sessionObj.close();
    }
    }
    
    public List<Register> getAllRegister()
        {
        Transaction transObj = null;
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        List<Register> listMhs = new ArrayList();
        
        try
        {
              transObj = sessionObj.beginTransaction();
              Query query = sessionObj.createQuery("from Register");
              
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
    
    public List<Register> getIDRegister()
        {
            Transaction transObj = null;
            Session sessionObj = HibernateUtil.getSessionFactory().openSession();
            List<Register> listStudent = new ArrayList();
            
            try
            {
                transObj = sessionObj.beginTransaction();
                Query query = sessionObj.createQuery("select RegisterId from Register");
                
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
        
        public List<Register> getRegisterByID(Integer selectedID)
        {
            Transaction transObj = null;
            Session sessionObj = HibernateUtil.getSessionFactory().openSession();
            List listStudent = new ArrayList();
            
            try
            {
                transObj = sessionObj.beginTransaction();
                
                Query query = sessionObj.createQuery("from Register where registerId = :id");
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
        
        public void updateMahasiswa(Register mhsObj)
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
        
        public void deleteMahasiswa(Register mhsObj)
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
        
    public Register GetContactLastRecord(){
        Transaction transObj = null;
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        Register ctc = null;
        try{
            transObj = sessionObj.beginTransaction();
            Query q = sessionObj.createQuery("from Register order by RegisterId desc");
            q.setMaxResults(1);
            ctc= (Register) q.uniqueResult();
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
