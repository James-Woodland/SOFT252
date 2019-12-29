/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem;

import PatientManagementSystem.Accounts.Admin;
import PatientManagementSystem.Accounts.AllAccounts;
import PatientManagementSystem.Accounts.Doctor;
import PatientManagementSystem.Login.AdminLogin;
import PatientManagementSystem.Login.DoctorLogin;
import PatientManagementSystem.Login.Login;
import PatientManagementSystem.AdminFunctionality.Delete;
import PatientManagementSystem.Serialiser.Serialiser;
import PatientManagementSystem.System.DoctorFeedback;
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
////        serialiser.writeObject(allaccounts);
        AllAccounts allAccounts = (AllAccounts) serialiser.readObject();
//        Admin admin = (Admin) allAccounts.getAllAdmins().get(0);        
////        admin.RemoveAccount("Admin", "A0002", "Password");
////        Admin admin = new Admin();
////        admin.CreateAccount("Admin", "Password", "Name", "Address");    
////        admin.CreateAccount("Doctor", "Password", "Name", "Address"); 
////        admin.CreateAccount("Doctor", "Password", "Name", "Address"); 
////        admin.CreateAccount("Secretary", "Password", "Name", "Address"); 
////        admin.CreateAccount("Secretary", "Password", "Name", "Address");         
////        allAccounts = (AllAccounts) serialiser.readObject();
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
////        AllAccounts ReadAccounts = (AllAccounts) serialiser.readObject();  
//        ArrayList<Object> DoctorFeedback = admin.GenerateFeedbackReport("D0001");
//        LocalDate localDate;    
          ArrayList<Doctor> doctors = allAccounts.getAllDoctors();
          ArrayList<DoctorFeedback> feedbackReport = doctors.get(0).getDoctorFeedback();
          feedbackReport.get(0).setFeedbackNotes("This is the First Comment");
          feedbackReport.get(1).setFeedbackNotes("This is the Second Comment");
          serialiser.writeObject(allAccounts);
          allAccounts = (AllAccounts) serialiser.readObject();
    }    
}

