/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem;

import PatientManagementSystem.Accounts.Admin;
import PatientManagementSystem.Accounts.AllAccounts;
import PatientManagementSystem.Accounts.Doctor;
import PatientManagementSystem.AllUsersFunctionality.Login.AdminLogin;
import PatientManagementSystem.AllUsersFunctionality.Login.DoctorLogin;
import PatientManagementSystem.AllUsersFunctionality.Login.Login;
import PatientManagementSystem.DeleteAccount.Delete;
import PatientManagementSystem.Serialiser.Serialiser;
import PatientManagementSystem.System.DoctorFeedback;
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
        Admin admin = new Admin();
//        Delete delete = new Delete();
//        admin.RemoveAccount("Admin", "A0002", "Password");
//        admin.CreateAccount("Admin", "Password", "Name", "Address");    
//        admin.CreateAccount("Doctor", "Password", "Name", "Address"); 
//        admin.CreateAccount("Doctor", "Password", "Name", "Address"); 
//        admin.CreateAccount("Secretary", "Password", "Name", "Address"); 
//        admin.CreateAccount("Secretary", "Password", "Name", "Address"); 
//        admin.CreateAccount("Secretary", "Password", "Name", "Address"); 
//        AllAccounts allAccounts = (AllAccounts) serialiser.readObject();
//        Doctor doctor = allAccounts.getAllDoctors().get(0);
//        DoctorFeedback doctorfeedback1 = new DoctorFeedback();
//        doctorfeedback1.setDoctorRating(5);
//        doctorfeedback1.setDoctor(doctor);
//        doctor.addDoctorFeedback(doctorfeedback1);
//        DoctorFeedback doctorfeedback2 = new DoctorFeedback();
//        doctorfeedback2.setDoctorRating(0);
//        doctorfeedback2.setDoctor(doctor);
//        doctor.addDoctorFeedback(doctorfeedback2);
//        serialiser.writeObject(allAccounts);
//        AllAccounts ReadAccounts = (AllAccounts) serialiser.readObject();  
        ArrayList<Object> DoctorRatings = admin.GetDoctorRatings();
        
    }    
}

