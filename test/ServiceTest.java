/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.ContactUsDAO;
import dao.RegisterDAO;
import dao.ServiceDAO;
import pojo.Contactus;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.*;
import pojo.Register;
import pojo.Service;


/**
 *
 * @author Client
 */
public class ServiceTest {
    
    public ServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testnambahService(){
        String nama = "massage";
        int admin = 1;
        String image = "image/img.jpg";
        String desc = "pelayanan";
        
        Service mhs = new Service();
      
        mhs.setServiceName(nama);
        mhs.setAdmin(admin);
        mhs.setServiceImage(image);
        mhs.setServiceDesc(desc);

        ServiceDAO dao = new ServiceDAO();
        dao.addNewService(mhs);
        //
        Service con = new Service();
        
        
        Service list = dao.GetContactLastRecord();
        
        String expectedNama = list.getServiceName();
        int expectedAdmin = list.getAdmin();
        String expectedImage = list.getServiceImage();
        String expectedDesc = list.getServiceDesc();
        
        assertEquals(expectedNama, nama);
        assertEquals(expectedAdmin, admin);
        assertEquals(expectedImage, image);
        assertEquals(expectedDesc, desc);
        
        dao.deleteMahasiswa(list);    
    }
    
    @Test
    public void testGetAllService(){
        ServiceDAO ctc = new ServiceDAO();
        List<Service> list = ctc.getAllService();
        
        assertNotNull(list);
    }
    
    @Test
    public void testGetAllServiceID(){
        ServiceDAO ctc = new ServiceDAO();
        List<Service> list = ctc.getIDService();
        
        assertNotNull(list);
    }
    
    @Test
    public void testGetServiceByID(){
        ServiceDAO ctc = new ServiceDAO();
        Service reg = new Service();
        reg.setSelectedID(8);
        List<Service> regist = ctc.getServiceByID(8);
        
        String expected = "Indonesian Massage";
        String actual = regist.get(0).getServiceName();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testupdateService(){
        
        String nama = "Massage";
        int admin = 1;
        String image = "image/img.jpg";
        String desc = "description";
        
        Service mhs = new Service();
      
        mhs.setServiceName(nama);
        mhs.setAdmin(admin);
        mhs.setServiceImage(image);
        mhs.setServiceDesc(desc);

        ServiceDAO dao = new ServiceDAO();
        dao.addNewService(mhs);
        
        Service list = dao.GetContactLastRecord();
        list.setServiceName(nama);
        list.setAdmin(admin);
        list.setServiceImage(image);
        list.setServiceDesc(desc);
        dao.updateMahasiswa(list);
        
        Service list2 = dao.GetContactLastRecord();
        
        String expectedNama = list.getServiceName();
        int expectedAdmin = list.getAdmin();
        String expectedImage = list.getServiceImage();
        String expectedDesc = list.getServiceDesc();
        
        String ActualNama = list2.getServiceName();
        int ActualAdmin = list2.getAdmin();
        String ActualImage = list2.getServiceImage();
        String ActualDesc = list2.getServiceDesc();
        
        assertEquals(expectedNama, nama);
        assertEquals(expectedAdmin, admin);
        assertEquals(expectedImage, image);
        assertEquals(expectedDesc, desc);
        
        dao.deleteMahasiswa(list2);
    }
    
    @Test
    public void testdelete(){
        String nama = "Massage";
        int admin = 1;
        String image = "image/img.jpg";
        String desc = "description";
        
        Service mhs = new Service();
      
        mhs.setServiceName(nama);
        mhs.setAdmin(admin);
        mhs.setServiceImage(image);
        mhs.setServiceDesc(desc);

        ServiceDAO dao = new ServiceDAO();
        dao.addNewService(mhs);
        
        Service list = dao.GetContactLastRecord();
        list.setServiceName(nama);
        list.setAdmin(admin);
        list.setServiceImage(image);
        list.setServiceDesc(desc);
        dao.deleteMahasiswa(list);
        
        Service list2 = dao.GetContactLastRecord();
        
        String expectedNama = list.getServiceName();
        int expectedAdmin = list.getAdmin();
        String expectedImage = list.getServiceImage();
        String expectedDesc = list.getServiceDesc();
        
        String ActualNama = list2.getServiceName();
        int ActualAdmin = list2.getAdmin();
        String ActualImage = list2.getServiceImage();
        String ActualDesc = list2.getServiceDesc();
        
        assertEquals(expectedNama, nama);
        assertEquals(expectedAdmin, admin);
        assertEquals(expectedImage, image);
        assertEquals(expectedDesc, desc);
    }

    
    
    
    
    
}
