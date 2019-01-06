/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.AdminDAO;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pojo.Admin;

/**
 *
 * @author Windows 10 Pro
 */
public class AdminTest {
    
    public AdminTest() {
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
    public void testvalidateLogin(){
        AdminDAO hry = new AdminDAO();
        Admin hairstylist = new Admin();
        hairstylist.setAdminUsername("aldialdi");
        hairstylist.setAdminPassword("aldialdi");
        boolean list = hry.validateLogin(hairstylist);
        
        assertTrue(list);
        
    }
    
}
