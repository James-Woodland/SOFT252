/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.DoctorFuntionality;

import PatientManagementSystem.Accounts.AllAccounts;
import PatientManagementSystem.Accounts.Patient;
import PatientManagementSystem.CreateAccount.CreateAccount;
import PatientManagementSystem.Serialiser.Serialiser;
import PatientManagementSystem.System.PatientNote;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author james
 */
public class CreatePatientNotesTest {
    AllAccounts allAccounts;
    Serialiser serialiser;
    public CreatePatientNotesTest() {
    }
    
    @Before
    public void setUp() {
        allAccounts = new AllAccounts();
        serialiser = new Serialiser("TestFile");
        serialiser.writeObject(allAccounts);
        CreateAccount createAccount = new CreateAccount("Patient");
        createAccount.executeStrategy("Password", "P1", "Address", "TestFile");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of CreatePatientNote method, of class CreatePatientNotes.
     */
    @Test
    public void testCreatePatientNote() {
        allAccounts = (AllAccounts) serialiser.readObject();
        ArrayList<Patient> patients = allAccounts.getAllPatients();
        ArrayList<PatientNote> PatientNotes = patients.get(0).getPatientNotes();
        System.out.println("There are currently "+PatientNotes.size()+ " Notes");
        CreatePatientNotes.CreatePatientNote("P0001", "A patient note", "D0001", "TestFile");
        allAccounts = (AllAccounts) serialiser.readObject();
        patients = allAccounts.getAllPatients();
        PatientNotes = patients.get(0).getPatientNotes();
        System.out.println("There are currently "+PatientNotes.size()+ " Notes");
    }   
}
