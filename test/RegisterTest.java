/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.ContactUsDAO;
import dao.RegisterDAO;
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


/**
 *
 * @author Client
 */
public class RegisterTest {
    
    public RegisterTest() {
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
    public void testnambahRegister(){
        String nama = "Tio";
        String alamat = "jakarta";
        String email = "Tio@gmail.com";
        String contact = "089998729872";
        
        Register mhs = new Register();
      
        mhs.setRegisterName(nama);
        mhs.setRegisterAddress(alamat);
        mhs.setRegisterEmail(email);
        mhs.setRegisterContact(contact);

        RegisterDAO dao = new RegisterDAO();
        dao.nambah(mhs);
        //
        Register con = new Register();
        
        
        Register list = dao.GetContactLastRecord();
        
        String expectedNama = list.getRegisterName();
        String expectedAlamat = list.getRegisterAddress();
        String expectedEmail = list.getRegisterEmail();
        String expectedContact = list.getRegisterContact();
        
        assertEquals(expectedNama, nama);
        assertEquals(expectedAlamat, alamat);
        assertEquals(expectedEmail, email);
        assertEquals(expectedContact, contact);
        
        dao.deleteMahasiswa(list);    
    }
    
    @Test
    public void testGetAllRegister(){
        RegisterDAO ctc = new RegisterDAO();
        List<Register> list = ctc.getAllRegister();
        
        assertNotNull(list);
    }
    
    @Test
    public void testGetAllContactID(){
        ContactUsDAO ctc = new ContactUsDAO();
        List<Contactus> list = ctc.getIDContactUs();
        
        assertNotNull(list);
    }
    
    @Test
    public void testGetRegisterByID(){
        RegisterDAO ctc = new RegisterDAO();
        Register reg = new Register();
        reg.setSelectedId(1);
        List<Register> regist = ctc.getRegisterByID(1);
        
        String expected = "aldialdi";
        String actual = regist.get(0).getRegisterName();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testupdateRegister(){
        
        String nama = "Tio";
        String alamat = "jakarta";
        String email = "Tio@gmail.com";
        String contact = "083984723429";
        
        Register mhs = new Register();
      
        mhs.setRegisterName(nama);
        mhs.setRegisterAddress(alamat);
        mhs.setRegisterEmail(email);
        mhs.setRegisterContact(contact);

        RegisterDAO dao = new RegisterDAO();
        dao.nambah(mhs);
        
        Register list = dao.GetContactLastRecord();
        list.setRegisterName(nama);
        list.setRegisterAddress(alamat);
        list.setRegisterEmail(email);
        list.setRegisterContact(contact);
        dao.updateMahasiswa(list);
        
        Register list2 = dao.GetContactLastRecord();
        
        String expectedNama = list.getRegisterName();
        String expectedAlamat = list.getRegisterAddress();
        String expectedEmail = list.getRegisterEmail();
        String expectedContact = list.getRegisterContact();
        
        String ActualNama = list2.getRegisterName();
        String ActualAddress = list2.getRegisterAddress();
        String ActualEmail = list2.getRegisterEmail();
        String ActualPesan = list2.getRegisterContact();
        
        assertEquals(expectedNama, nama);
        assertEquals(expectedAlamat, alamat);
        assertEquals(expectedEmail, email);
        assertEquals(expectedContact, contact);
        
        dao.deleteMahasiswa(list2);
    }
    
    @Test
    public void testdelete(){
        String nama = "Tio";
        String alamat = "jakarta";
        String email = "Tio@gmail.com";
        String contact = "083984723429";
        
        Register mhs = new Register();
      
        mhs.setRegisterName(nama);
        mhs.setRegisterAddress(alamat);
        mhs.setRegisterEmail(email);
        mhs.setRegisterContact(contact);

        RegisterDAO dao = new RegisterDAO();
        dao.nambah(mhs);
        Register list = dao.GetContactLastRecord();
        list.setRegisterName(nama);
        list.setRegisterAddress(alamat);
        list.setRegisterEmail(email);
        list.setRegisterContact(contact);
        dao.deleteMahasiswa(list);
        
        Register list2 = dao.GetContactLastRecord();
        
        String expectedNama = list.getRegisterName();
        String expectedAlamat = list.getRegisterAddress();
        String expectedEmail = list.getRegisterEmail();
        String expectedContact = list.getRegisterContact();
        
        String ActualNama = list2.getRegisterName();
        String ActualAddress = list2.getRegisterAddress();
        String ActualEmail = list2.getRegisterEmail();
        String ActualContact = list2.getRegisterContact();
        
        assertEquals(expectedNama, nama);
        assertEquals(expectedAlamat, alamat);
        assertEquals(expectedEmail, email);
        assertEquals(expectedContact, contact);
    }

    
    @Test
    public void testAllRegister(){
     RegisterDAO ctc = new RegisterDAO();
        List<Register> list = ctc.getAllRegister();
        
        assertTrue(list.size()>0);   
    }
    
    
    
}
