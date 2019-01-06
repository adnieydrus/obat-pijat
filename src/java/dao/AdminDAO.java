/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import pojo.Admin;
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
public class AdminDAO {
    public boolean validateLogin(Admin admin){
        Transaction transObj = null;
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        List<Admin> listadm = new ArrayList<Admin>();
        try{
            transObj = sessionObj.beginTransaction();
            Query query = sessionObj.createQuery("from Admin where adminUsername = :adminUsername and adminPassword = :adminPassword and adminStatus = :adminStatus");
            query.setParameter("adminUsername", admin.getAdminUsername());
            query.setParameter("adminPassword", admin.getAdminPassword());
            query.setParameter("adminStatus", "Aktif");
            listadm = query.list();
            
            
            transObj.commit();
            System.out.println("Sukses");
        }catch(Exception ex){
            ex.printStackTrace();
            transObj.rollback();
        }
        
        if(listadm.size()>0){
            return true;
        }else{
            return false;
        }
    }
    
    
    
}
