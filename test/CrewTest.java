/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.CrewDAO;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pojo.Crew;

/**
 *
 * @author Windows 10 Pro
 */
public class CrewTest {
    
    public CrewTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
        @Test
    public void testnambahCrew(){
        String nama = "aldi";
        int admin = 1;
        String image = "image/img.jpg";
        String desc = "Tukang baru";
        
        Crew mhs = new Crew();
      
        mhs.setCrewName(nama);
        mhs.setAdmin(admin);
        mhs.setCrewImage(image);
        mhs.setCrewDesc(desc);

        CrewDAO dao = new CrewDAO();
        dao.addNewServicelist(mhs);
        //
        Crew con = new Crew();
        
        
        Crew list = dao.GetContactLastRecord();
        
        String expectedNama = list.getCrewName();
        int expectedAdmin = list.getAdmin();
        String expectedImage = list.getCrewImage();
        String expectedDesc = list.getCrewDesc();
        
        assertEquals(expectedNama, nama);
        assertEquals(expectedAdmin, admin);
        assertEquals(expectedImage, image);
        assertEquals(expectedDesc, desc);
        
        dao.deleteMahasiswa(list);    
    }
    
    @Test
    public void testGetAllCrew(){
        CrewDAO ctc = new CrewDAO();
        List<Crew> list = ctc.getAllCrew();
        
        assertNotNull(list);
    }
    
    @Test
    public void testGetAllCrewID(){
        CrewDAO ctc = new CrewDAO();
        List<Crew> list = ctc.getIDCrew();
        
        assertNotNull(list);
    }
    
    @Test
    public void testGetCrewByID(){
        CrewDAO ctc = new CrewDAO();
        Crew reg = new Crew();
        reg.setSelectedID(6);
        List<Crew> regist = ctc.getCrewByID(6);
        
        String expected = "Jakson";
        String actual = regist.get(0).getCrewName();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testupdateCrew(){
        
        String nama = "Aldi";
        int admin = 1;
        String image = "image/img.jpg";
        String desc = "Tukang pijat baru";
        
        Crew mhs = new Crew();
      
        mhs.setCrewName(nama);
        mhs.setAdmin(admin);
        mhs.setCrewImage(image);
        mhs.setCrewDesc(desc);

        CrewDAO dao = new CrewDAO();
        dao.addNewServicelist(mhs);
        
        Crew list = dao.GetContactLastRecord();
        list.setCrewName(nama);
        list.setAdmin(admin);
        list.setCrewImage(image);
        list.setCrewDesc(desc);
        dao.updateMahasiswa(list);
        
        Crew list2 = dao.GetContactLastRecord();
        
        String expectedNama = list.getCrewName();
        int expectedAdmin = list.getAdmin();
        String expectedImage = list.getCrewImage();
        String expectedDesc = list.getCrewDesc();
        
        String ActualNama = list2.getCrewName();
        int ActualAdmin = list2.getAdmin();
        String ActualImage = list2.getCrewImage();
        String ActualDesc = list2.getCrewDesc();
        
        assertEquals(expectedNama, nama);
        assertEquals(expectedAdmin, admin);
        assertEquals(expectedImage, image);
        assertEquals(expectedDesc, desc);
        
        dao.deleteMahasiswa(list2);
    }
    
    @Test
    public void testdelete(){
        String nama = "aldi";
        int admin = 1;
        String image = "image/img.jpg";
        String desc = "Tukang pijat baru";
        
        Crew mhs = new Crew();
      
        mhs.setCrewName(nama);
        mhs.setAdmin(admin);
        mhs.setCrewImage(image);
        mhs.setCrewDesc(desc);

        CrewDAO dao = new CrewDAO();
        dao.addNewServicelist(mhs);
        
        Crew list = dao.GetContactLastRecord();
        list.setCrewName(nama);
        list.setAdmin(admin);
        list.setCrewImage(image);
        list.setCrewDesc(desc);
        dao.deleteMahasiswa(list);
        
        Crew list2 = dao.GetContactLastRecord();
        
        String expectedNama = list.getCrewName();
        int expectedAdmin = list.getAdmin();
        String expectedImage = list.getCrewImage();
        String expectedDesc = list.getCrewDesc();
        
        String ActualNama = list2.getCrewName();
        int ActualAdmin = list2.getAdmin();
        String ActualImage = list2.getCrewImage();
        String ActualDesc = list2.getCrewDesc();
        
        assertEquals(expectedNama, nama);
        assertEquals(expectedAdmin, admin);
        assertEquals(expectedImage, image);
        assertEquals(expectedDesc, desc);
    }

    
}
