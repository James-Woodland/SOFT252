/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.DoctorFuntionality;

import PatientManagementSystem.Accounts.AllAccounts;
import PatientManagementSystem.Accounts.Secretary;
import PatientManagementSystem.CreateAccount.CreateAccount;
import PatientManagementSystem.Serialiser.Serialiser;
import PatientManagementSystem.System.Medicine.AllMedicines;
import PatientManagementSystem.System.Medicine.Medicine;
import PatientManagementSystem.System.MedicineRequest;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author james
 */
public class CreateMedicineAndRequestRestockTest {
    AllAccounts allAccounts;
    AllMedicines allMedicines;
    Serialiser serialiser;
    Serialiser medicineSerialiser;
    public CreateMedicineAndRequestRestockTest() {
    }
    
    @Before
    public void setUp() {
        allAccounts = new AllAccounts();
        allMedicines = new AllMedicines();
        serialiser = new Serialiser("TestFile");
        serialiser.writeObject(allAccounts);
        medicineSerialiser = new Serialiser("MedicineTestFile");
        medicineSerialiser.writeObject(allMedicines);
        CreateAccount createAccount = new CreateAccount("Secretary");
        createAccount.executeStrategy("Password", "S1", "Address", "TestFile");
    }
    
    @After
    public void tearDown() {
        
    }

    /**
     * Test of createNewMedicine method, of class CreateMedicineAndRequestRestock.
     */
    @Test
    public void testCreateNewMedicine() {
        allMedicines = (AllMedicines) medicineSerialiser.readObject();
        ArrayList<Medicine> medicines = allMedicines.getAllMedicines();
        System.out.println("There are currently "+medicines.size()+" medicines");
        CreateMedicineAndRequestRestock.createNewMedicine("Test", "MedicineTestFile");
        allMedicines = (AllMedicines) medicineSerialiser.readObject();
        medicines = allMedicines.getAllMedicines();
        System.out.println("There are currently "+medicines.size()+" medicines");
        allMedicines = (AllMedicines) medicineSerialiser.readObject();
    }

    /**
     * Test of createMedicineRestockRequest method, of class CreateMedicineAndRequestRestock.
     */
    @Test
    public void testCreateMedicineRestockRequest() {
        CreateMedicineAndRequestRestock.createNewMedicine("Test", "MedicineTestFile");
        allAccounts = (AllAccounts) serialiser.readObject();
        ArrayList<Secretary> secretarys = allAccounts.getAllSecretarys();
        System.out.println("The Secretary has "+secretarys.get(0).getMedicineRequests().size()+" Restock Requests");
        CreateMedicineAndRequestRestock.createMedicineRestockRequest("Test", 2, "TestFile", "MedicineTestFile");
        allAccounts = (AllAccounts) serialiser.readObject();
        secretarys = allAccounts.getAllSecretarys();
        System.out.println("The Secretary has "+secretarys.get(0).getMedicineRequests().size()+" Restock Requests");
        ArrayList<MedicineRequest> medicineRequest = secretarys.get(0).getMedicineRequests();        
    }   
}
