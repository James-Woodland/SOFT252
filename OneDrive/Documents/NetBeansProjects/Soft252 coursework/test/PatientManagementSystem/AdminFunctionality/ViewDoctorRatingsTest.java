/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.AdminFunctionality;

import PatientManagementSystem.Accounts.AllAccounts;
import PatientManagementSystem.CreateAccount.CreateAccount;
import PatientManagementSystem.PatientFunctionality.RateDoctor;
import PatientManagementSystem.Serialiser.Serialiser;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author james
 */
public class ViewDoctorRatingsTest {
    AllAccounts allAccounts;
    Serialiser serialiser;
    public ViewDoctorRatingsTest() {
        
    }
    
    @Before
    public void setUp() {
        allAccounts = new AllAccounts();
        serialiser = new Serialiser("TestFile");
        serialiser.writeObject(allAccounts);
        CreateAccount createAccount = new CreateAccount("Doctor");
        createAccount.executeStrategy("Password", "D1", "Address", "TestFile");
        createAccount.executeStrategy("Password", "D2", "Address", "TestFile");
        RateDoctor.CreateDoctorRating(1, "", 0, "TestFile");
        RateDoctor.CreateDoctorRating(2, "", 0, "TestFile");
        RateDoctor.CreateDoctorRating(3, "", 0, "TestFile");
        RateDoctor.CreateDoctorRating(4, "", 0, "TestFile");
        RateDoctor.CreateDoctorRating(5, "", 0, "TestFile");
        RateDoctor.CreateDoctorRating(1, "", 1, "TestFile");
        RateDoctor.CreateDoctorRating(1, "", 1, "TestFile");
        RateDoctor.CreateDoctorRating(1, "", 1, "TestFile");
        RateDoctor.CreateDoctorRating(1, "", 1, "TestFile");
        RateDoctor.CreateDoctorRating(4, "", 1, "TestFile");
        allAccounts = (AllAccounts) serialiser.readObject();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of GetDoctorRatings method, of class ViewDoctorRatings.
     */
    @Test
    public void testGetDoctorRatings() {
        ArrayList<Object> Ratings = ViewDoctorRatings.GetDoctorRatings("TestFile");
        System.out.println("The Doctor ID is " + Ratings.get(1));
        float Average = (1+2+3+4+5)/5;
        System.out.println("The average should be "+Average+". The Average on the report is "+Ratings.get(2));
        System.out.println("The Doctor ID is " + Ratings.get(4));
        float value = 1+1+1+4+1;
        Average = value/5;
        System.out.println("The average should be "+Average+". The Average on the report is "+Ratings.get(5));
        
    }
    
}
