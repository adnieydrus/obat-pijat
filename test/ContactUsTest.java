/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.ContactUsDAO;
import pojo.Contactus;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Windows 10
 */
public class ContactUsTest {
   
    public ContactUsTest() {
    
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
    public void testGetAllContactUs(){
        ContactUsDAO obj = new ContactUsDAO();
        List<Contactus> list = obj.getAllContactUs();
        
        assertNotNull(list);
    }
    
    @Test
    public void testGetIDContactUs(){
        ContactUsDAO obj = new ContactUsDAO();
        List<Contactus> list = obj.getIDContactUs();
        
        assertNotNull(list);
    }
    
    @Test
    public void testGetContactUsByID(){
        ContactUsDAO obj = new ContactUsDAO();
        List<Contactus> list = obj.getContactUsByID(11);
        
        String expected = "manda";
        String actual = list.get(0).getContactName();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testnambah(){
        int id = 15;
        String nama = "Aldi";
        String email = "Aldi@gmail.com";
        String pesan = "Aldi lagi ngoding";
        
        Contactus mhs = new Contactus();
        mhs.setContactId(id);
        mhs.setContactName(nama);
        mhs.setContactEmail(email);
        mhs.setContactMessage(pesan);    
        
        ContactUsDAO dao = new ContactUsDAO();
        dao.nambah(mhs);
        
        List<Contactus> list = dao.getContactUsByID(id);
        String expectedName = list.get(0).getContactName();
        String expectedEmail = list.get(0).getContactEmail();
        String expectedPesan = list.get(0).getContactMessage();
        
        assertEquals(expectedName, nama);
        assertEquals(expectedEmail, email);
        assertEquals(expectedPesan, pesan);
        
        dao.deleteMahasiswa(mhs);
        
    }

    @Test
    public void testupdateContactUs(){
        
        ContactUsDAO dao = new ContactUsDAO();
        
        List<Contactus> list = dao.getContactUsByID(15);
        String BeforeName = list.get(0).getContactName();
        String BeforeEmail = list.get(0).getContactEmail();
        String BeforePesan = list.get(0).getContactMessage();
        
        int id = 15;
        String nama = "Aldi";
        String email = "aldi@gmail.com";
        String pesan = "Aldi bagus";
        
        Contactus mhs = new Contactus();
        mhs.setContactId(id);
        mhs.setContactName(nama);
        mhs.setContactEmail(email);
        mhs.setContactMessage(pesan);
    
        dao.updateMahasiswa(mhs);
        
        List<Contactus> list2 = dao.getContactUsByID(id);
        String expectedName = list2.get(0).getContactName();
        String expectedEmail = list2.get(0).getContactEmail();
        String expectedPesan = list2.get(0).getContactMessage();
        
        assertEquals(expectedName, nama);
        assertEquals(expectedEmail, email);
        assertEquals(expectedPesan, pesan);
        
        mhs.setContactId(id);
        mhs.setContactName(BeforeName);
        mhs.setContactEmail(BeforeEmail);
        mhs.setContactMessage(BeforePesan);
        
        dao.updateMahasiswa(mhs);
        
    }
    
    @Test
    public void testdeleteContact(){
        String nama = "Tio";
        String email = "Tio@gmail.com";
        String pesan = "Bagus cuy";
        
        Contactus mhs = new Contactus();
      
        mhs.setContactName(nama);
        mhs.setContactEmail(email);
        mhs.setContactMessage(pesan);

        ContactUsDAO dao = new ContactUsDAO();
        dao.nambah(mhs);
        Contactus list = dao.GetContactLastRecord();
        list.setContactName(nama);
        list.setContactEmail(email);
        list.setContactMessage(pesan);
        dao.deleteMahasiswa(list);
        
        Contactus list2 = dao.GetContactLastRecord();
        
        String expectedNama = list.getContactName();
        String expectedEmail = list.getContactEmail();
        String expectedPesan = list.getContactMessage();
        
        String ActualNama = list2.getContactName();
        String ActualEmail = list2.getContactEmail();
        String ActualPesan = list2.getContactMessage();
        
        assertEquals(expectedNama, nama);
        assertEquals(expectedEmail, email);
        assertEquals(expectedPesan, pesan);
    }
}