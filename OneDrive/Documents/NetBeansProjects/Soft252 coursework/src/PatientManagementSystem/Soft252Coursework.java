/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem;

import PatientManagementSystem.Accounts.Admin;
import PatientManagementSystem.Accounts.AllAccounts;
import PatientManagementSystem.Accounts.Doctor;
import PatientManagementSystem.Accounts.Patient;
import PatientManagementSystem.Accounts.Secretary;
import PatientManagementSystem.Serialiser.Serialiser;
import java.util.ArrayList;




/**
 *
 * @author james
 */
public class Soft252Coursework {

    
    public static void main(String[] args) {
        // TODO code application logic here      
        Serialiser serialiser = new Serialiser("AllAccounts");      
        AllAccounts allAccounts = (AllAccounts) serialiser.readObject();
        System.out.println(allAccounts.getAllAdmins().get(0).getName());
    }
    
    public boolean Login(String AccountType, String Username, String Password){
        AllAccounts allAccounts = AllAccounts.getInstance();
        switch(AccountType){
            case "Admin":               
                ArrayList<Admin> admins = allAccounts.getAllAdmins();
                for (int i = 0; i < admins.size(); i++) {
                if ((admins.get(i).getPassword().equals(Password)) && (admins.get(i).getUserID().equals(Username))) {
                    return true;
                }
                }
                break;
            case "Doctor":                
                ArrayList<Doctor> doctors = allAccounts.getAllDoctors();
                for (int i = 0; i < doctors.size(); i++) {
                if ((doctors.get(i).getPassword().equals(Password)) && (doctors.get(i).getUserID().equals(Username))) 
                    return true;                      
                }
            case "Secretary":
                ArrayList<Secretary> secretarys = allAccounts.getAllSecretarys();
                for (int i = 0; i < secretarys.size(); i++) {
                if ((secretarys.get(i).getPassword().equals(Password)) && (secretarys.get(i).getUserID().equals(Username))) 
                    return true;                      
                }
            default:
                ArrayList<Patient> patients = allAccounts.getAllPatients();
                for (int i = 0; i < patients.size(); i++) {
                if ((patients.get(i).getPassword().equals(Password)) && (patients.get(i).getUserID().equals(Username))) 
                    return true;                   
                }
            }        
        return false;
    }
}

