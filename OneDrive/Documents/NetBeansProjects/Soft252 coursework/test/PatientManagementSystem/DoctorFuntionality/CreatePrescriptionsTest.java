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
import PatientManagementSystem.System.Medicine.AllMedicines;
import PatientManagementSystem.System.PatientNote;
import PatientManagementSystem.System.Prescription;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author james
 */
public class CreatePrescriptionsTest {
    AllAccounts allAccounts;
    AllMedicines allMedicines;
    Serialiser serialiser;
    Serialiser medicineSerialiser;
    public CreatePrescriptionsTest() {
        
    }
    
    @Before
    public void setUp() {
        allAccounts = new AllAccounts();
        allMedicines = new AllMedicines();
        serialiser = new Serialiser("TestFile");
        serialiser.writeObject(allAccounts);
        medicineSerialiser = new Serialiser("MedicineTestFile");
        medicineSerialiser.writeObject(allMedicines);
        CreateAccount createAccount = new CreateAccount("Patient");
        createAccount.executeStrategy("Password", "P1", "Address", "TestFile");
        CreateMedicineAndRequestRestock.createNewMedicine("Test", "MedicineTestFile");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of CreatePrescription method, of class CreatePrescriptions.
     */
    @Test
    public void testCreatePrescription() {
        allAccounts = (AllAccounts) serialiser.readObject();
        ArrayList<Patient> patients = allAccounts.getAllPatients();
        ArrayList<Prescription> prescriptions = patients.get(0).getPrescriptions();
        System.out.println("The patient currently has "+prescriptions.size()+" prescriptions");
        CreatePrescriptions.CreatePrescription("P0001", "", "Test", 0, 0, "TestFile", "MedicineTestFile");
        allAccounts = (AllAccounts) serialiser.readObject();
        patients = allAccounts.getAllPatients();
        prescriptions = patients.get(0).getPrescriptions();
        System.out.println("The patient currently has "+prescriptions.size()+" prescriptions");
    }
    
}
