/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.Serialiser;

import PatientManagementSystem.Accounts.Admin;
import PatientManagementSystem.Accounts.AllAccounts;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author james
 */
public class SerialiserTest {
    Serialiser serialiser;
    
    public SerialiserTest() {
    }
    
    @Before
    public void setUp() {
        serialiser = new Serialiser("TestFile");
    }
    
    @After
    public void tearDown() {
    }    
    
    /**
     * Test of writeObject and ReadObject method, of class Serialiser.
     */
    @Test
    public void testWriteAndReadObject() {
        AllAccounts allAccounts = new AllAccounts();
        Admin admin = new Admin();
        allAccounts.addAdmin(admin);
        serialiser.writeObject(allAccounts);
        AllAccounts ReadAccounts = (AllAccounts) serialiser.readObject();
        if (allAccounts.getAllAdmins().get(0).getPassword().equals(ReadAccounts.getAllAdmins().get(0).getPassword())) {
            System.out.println("The 2 objects contain the same data");
        }
    }
         
}
