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
public class GenerateFeedbackReportTest {
    AllAccounts allAccounts;
    Serialiser serialiser;
    
    public GenerateFeedbackReportTest() {
    }
    
    @Before
    public void setUp() {
        allAccounts = new AllAccounts();
        serialiser = new Serialiser("TestFile");
        serialiser.writeObject(allAccounts);
        CreateAccount createAccount = new CreateAccount("Doctor");
        createAccount.executeStrategy("Password", "D1", "Address", "TestFile");
        RateDoctor.CreateDoctorRating(1, "A very bad Doctor", 0, "TestFile");
        RateDoctor.CreateDoctorRating(2, "A bad Doctor", 0, "TestFile");
        RateDoctor.CreateDoctorRating(3, "An Okay Doctor", 0, "TestFile");
        RateDoctor.CreateDoctorRating(4, "A good Doctor", 0, "TestFile");
        RateDoctor.CreateDoctorRating(5, "A very good Doctor", 0, "TestFile");
        allAccounts = (AllAccounts) serialiser.readObject();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of GenerateNewFeedbackReport method, of class GenerateFeedbackReport.
     */
    @Test
    public void testGenerateNewFeedbackReport() {
        ArrayList<Object> FeedbackReport = GenerateFeedbackReport.GenerateNewFeedbackReport("D0001", "TestFile");
        System.out.println("The Doctor ID is "+FeedbackReport.get(0));
        for (int i = 0; i < 5; i++) {
            System.out.println("Comment "+ (i+1) +" is "+FeedbackReport.get(i+1));
        }
        float Average = (1+2+3+4+5)/5;
        System.out.println("The average should be "+Average+". The Average on the report is "+FeedbackReport.get(6));
    }
    
}
