/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.AdminFunctionality;

import PatientManagementSystem.Accounts.Admin;
import PatientManagementSystem.Accounts.AllAccounts;
import PatientManagementSystem.Accounts.Doctor;
import PatientManagementSystem.Accounts.Patient;
import PatientManagementSystem.Accounts.Secretary;
import PatientManagementSystem.CreateAccount.CreateAccount;
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
public class DeleteTest {
    AllAccounts allAccounts;
    Serialiser Serialiser;
    
    public DeleteTest() {
    }
    
    @Before
    public void setUp() {
        Serialiser = new Serialiser("TestFile");
        allAccounts = new AllAccounts();
        Serialiser.writeObject(allAccounts);
        CreateAccount createAccount = new CreateAccount("Doctor");
        createAccount.executeStrategy("Password", "D1", "Address", "TestFile");
        createAccount = new CreateAccount("Secretary");
        createAccount.executeStrategy("Password", "S1", "Address", "TestFile");
        createAccount = new CreateAccount("Patient");
        createAccount.executeStrategy("Password", "P1", "Address", "TestFile");
        allAccounts = (AllAccounts) Serialiser.readObject();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of DeleteAccount method, of class Delete.
     */
    @Test
    public void testDeleteAccount() {
        ArrayList<Doctor> doctors = allAccounts.getAllDoctors();
        System.out.println("There are currently "+doctors.size()+" doctors in the test file");
        Delete.DeleteAccount("Doctor", "D0001", "TestFile");
        allAccounts = (AllAccounts) Serialiser.readObject();
        doctors = allAccounts.getAllDoctors();
        System.out.println("There are now "+doctors.size()+" doctors in the test file");
        ArrayList<Secretary> secretarys = allAccounts.getAllSecretarys();
        System.out.println("There are currently "+secretarys.size()+" secretarys in the test file");
        Delete.DeleteAccount("Secretary", "S0001", "TestFile");
        allAccounts = (AllAccounts) Serialiser.readObject();
        secretarys = allAccounts.getAllSecretarys();
        System.out.println("There are now "+secretarys.size()+" secretarys in the test file");
        ArrayList<Patient> patients = allAccounts.getAllPatients();
        System.out.println("There are currently "+patients.size()+" patients in the test file");
        Delete.DeleteAccount("Patient", "P0001", "TestFile");
        allAccounts = (AllAccounts) Serialiser.readObject();
        patients = allAccounts.getAllPatients();
        System.out.println("There are now "+patients.size()+" patients in the test file");
    }   
}
