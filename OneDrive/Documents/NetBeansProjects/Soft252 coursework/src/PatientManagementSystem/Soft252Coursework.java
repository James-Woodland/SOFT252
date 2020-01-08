/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem;

import PatientManagementSystem.Accounts.Admin;
import PatientManagementSystem.Accounts.AllAccounts;
import PatientManagementSystem.Accounts.Doctor;
import PatientManagementSystem.Accounts.Secretary;
import PatientManagementSystem.Login.AdminLogin;
import PatientManagementSystem.Login.DoctorLogin;
import PatientManagementSystem.Login.Login;
import PatientManagementSystem.AdminFunctionality.Delete;
import PatientManagementSystem.Serialiser.Serialiser;
import PatientManagementSystem.System.DoctorFeedback;
import PatientManagementSystem.System.Medicine.AllMedicines;
import PatientManagementSystem.System.Medicine.Medicine;
import java.time.LocalDate;
import java.util.ArrayList;




/**
 *
 * @author james
 */
        
public class Soft252Coursework {   
    public static void main(String[] args) {
        // TODO code application logic here             
        Serialiser serialiser = new Serialiser("AllAccounts");
//        AllAccounts allaccounts = new AllAccounts();
//        serialiser.writeObject(allaccounts);
////////        allaccounts = (AllAccounts) serialiser.readObject();
//////////        Admin admin = (Admin) allAccounts.getAllAdmins().get(0);        
////////////        admin.RemoveAccount("Admin", "A0002", "Password");
//        Admin admin = new Admin();
//        admin.CreateAccount("Admin", "Password", "Name", "Address");    
//        admin.CreateAccount("Doctor", "Password", "Name", "Address"); 
//        admin.CreateAccount("Doctor", "Password", "Name", "Address"); 
//        admin.CreateAccount("Secretary", "Password", "Name", "Address"); 
//        admin.CreateAccount("Patient", "Password", "Name", "Address"); 
////        admin.CreateAccount("Secretary", "Password", "Name", "Address"); 
//        serialiser.writeObject(allaccounts);
        AllAccounts allaccounts = (AllAccounts) serialiser.readObject();
//        ArrayList<Secretary> Secretarys = allaccounts.getAllSecretarys(); 
//        for (int i = 0; i < Secretarys.size(); i++) {
//            Secretarys.get(i).removeRemoveAccountRequest(0);
//        }
//        serialiser.writeObject(allaccounts);
////        Doctor doctor = allAccounts.getAllDoctors().get(0);
////        DoctorFeedback doctorfeedback1 = new DoctorFeedback();
////        doctorfeedback1.setDoctorRating(5);
////        doctorfeedback1.setDoctor(doctor);
////        doctor.addDoctorFeedback(doctorfeedback1);
////        DoctorFeedback doctorfeedback2 = new DoctorFeedback();
////        doctorfeedback2.setDoctorRating(0);
////        doctorfeedback2.setDoctor(doctor);
////        doctor.addDoctorFeedback(doctorfeedback2);
////        serialiser.writeObject(allAccounts);
//        AllAccounts ReadAccounts = (AllAccounts) serialiser.readObject();  
//        ArrayList<Object> DoctorFeedback = admin.GenerateFeedbackReport("D0001");
//        LocalDate localDate;    
          Serialiser medicineSerialiser = new Serialiser("AllMedicines");         
//          AllMedicines allMedicines = new AllMedicines();
//          medicineSerialiser.writeObject(allMedicines);
//          AllMedicines allMedicines = (AllMedicines) medicineSerialiser.readObject(); 
//          Doctor doctors = new Doctor();
//          doctors.CreateMedicineAndOrder("Test", 2);         
//          AllMedicines allMedicines = new AllMedicines();
//          medicineSerialiser.writeObject(allMedicines);
          AllMedicines allMedicines = (AllMedicines) medicineSerialiser.readObject();
    }    
}

