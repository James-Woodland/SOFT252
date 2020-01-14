/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.CreateAccount;

import PatientManagementSystem.Accounts.Admin;
import PatientManagementSystem.Accounts.AllAccounts;
import PatientManagementSystem.Accounts.Doctor;
import PatientManagementSystem.Accounts.Patient;
import PatientManagementSystem.Accounts.Secretary;
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
public class CreateAccountTest {
    AllAccounts allAccounts;
    Serialiser serialiser;
    
    public CreateAccountTest() {
    }
    
    @Before
    public void setUp() {
        allAccounts = new AllAccounts();
        serialiser = new Serialiser("TestFile");
        serialiser.writeObject(allAccounts);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of executeStrategy method, of class CreateAccount.
     */
    @Test
    public void testExecuteStrategy() {
        allAccounts = (AllAccounts) serialiser.readObject();
        ArrayList<Patient> patients = allAccounts.getAllPatients();
        ArrayList<Doctor> doctors = allAccounts.getAllDoctors();
        ArrayList<Admin> admins = allAccounts.getAllAdmins();
        ArrayList<Secretary> secretarys = allAccounts.getAllSecretarys();
        System.out.println("//////////////////////////////////////////////////////////");
        System.out.println("No Accounts Created");
        System.out.println("There are currently "+patients.size()+" patients.");
        System.out.println("There are currently "+doctors.size()+" doctors.");
        System.out.println("There are currently "+admins.size()+" admins.");
        System.out.println("There are currently "+secretarys.size()+" secretarys.");
        CreateAccount PatientAccount = new CreateAccount("Patient");
        PatientAccount.executeStrategy("Password", "P1", "Address", "TestFile");
        allAccounts = (AllAccounts) serialiser.readObject();
        patients = allAccounts.getAllPatients();
        doctors = allAccounts.getAllDoctors();
        admins = allAccounts.getAllAdmins();
        secretarys = allAccounts.getAllSecretarys();
        System.out.println("//////////////////////////////////////////////////////////");
        System.out.println("Patient Account Created");
        System.out.println("There are currently "+patients.size()+" patients.");
        System.out.println("There are currently "+doctors.size()+" doctors.");
        System.out.println("There are currently "+admins.size()+" admins.");
        System.out.println("There are currently "+secretarys.size()+" secretarys.");
        CreateAccount DoctorAccount = new CreateAccount("Doctor");
        DoctorAccount.executeStrategy("Password", "D1", "Address", "TestFile");
        allAccounts = (AllAccounts) serialiser.readObject();
        patients = allAccounts.getAllPatients();
        doctors = allAccounts.getAllDoctors();
        admins = allAccounts.getAllAdmins();
        secretarys = allAccounts.getAllSecretarys();
        System.out.println("//////////////////////////////////////////////////////////");
        System.out.println("Patient and Doctor Account Created");
        System.out.println("There are currently "+patients.size()+" patients.");
        System.out.println("There are currently "+doctors.size()+" doctors.");
        System.out.println("There are currently "+admins.size()+" admins.");
        System.out.println("There are currently "+secretarys.size()+" secretarys.");
        CreateAccount SecretaryAccount = new CreateAccount("Secretary");
        SecretaryAccount.executeStrategy("Password", "S1", "Address", "TestFile");
        allAccounts = (AllAccounts) serialiser.readObject();
        patients = allAccounts.getAllPatients();
        doctors = allAccounts.getAllDoctors();
        admins = allAccounts.getAllAdmins();
        secretarys = allAccounts.getAllSecretarys();
        System.out.println("//////////////////////////////////////////////////////////");
        System.out.println("Patient, Doctor and Secretary Account Created");
        System.out.println("There are currently "+patients.size()+" patients.");
        System.out.println("There are currently "+doctors.size()+" doctors.");
        System.out.println("There are currently "+admins.size()+" admins.");
        System.out.println("There are currently "+secretarys.size()+" secretarys.");
        CreateAccount AdminAccount = new CreateAccount("Admin");
        AdminAccount.executeStrategy("Password", "A1", "Address", "TestFile");
        allAccounts = (AllAccounts) serialiser.readObject();
        patients = allAccounts.getAllPatients();
        doctors = allAccounts.getAllDoctors();
        admins = allAccounts.getAllAdmins();
        secretarys = allAccounts.getAllSecretarys();
        System.out.println("//////////////////////////////////////////////////////////");
        System.out.println("All Accounts Created");
        System.out.println("There are currently "+patients.size()+" patients.");
        System.out.println("There are currently "+doctors.size()+" doctors.");
        System.out.println("There are currently "+admins.size()+" admins.");
        System.out.println("There are currently "+secretarys.size()+" secretarys.");
    }
    
}
