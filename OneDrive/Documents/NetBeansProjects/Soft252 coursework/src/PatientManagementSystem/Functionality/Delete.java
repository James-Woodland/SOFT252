/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.Functionality;

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
public class Delete {

    /**
     * This function will delete an account given the correct userID for that account is given(All UserIDs are unique) 
     * @param AccountType The type of account that is going to be deleted 
     * @param Username The Username of that account
     * @param Password  The Password of that account
     */
    public void DeleteAccount(String AccountType, String Username, String Password){
        Serialiser serialiser = new Serialiser("AllAccounts");
        AllAccounts allAccounts = (AllAccounts) serialiser.readObject();
        switch(AccountType){           
            case "Doctor":                
                ArrayList<Doctor> doctors = allAccounts.getAllDoctors();
                for (int i = 0; i < doctors.size(); i++) {
                if ((doctors.get(i).getPassword().equals(Password)) && (doctors.get(i).getUserID().equals(Username))) 
                    allAccounts.removeDoctor(doctors.get(i));                                        
                }
            case "Secretary":
                ArrayList<Secretary> secretarys = allAccounts.getAllSecretarys();
                for (int i = 0; i < secretarys.size(); i++) {
                if ((secretarys.get(i).getPassword().equals(Password)) && (secretarys.get(i).getUserID().equals(Username))) 
                    allAccounts.removeSecretary(secretarys.get(i));                                         
                }
            default:
                ArrayList<Patient> patients = allAccounts.getAllPatients();
                for (int i = 0; i < patients.size(); i++) {
                if ((patients.get(i).getPassword().equals(Password)) && (patients.get(i).getUserID().equals(Username)))
                    allAccounts.removePatient(patients.get(i));                                 
                }
            } 
        serialiser.writeObject(allAccounts);
        System.out.println("Account not found");    
    }
}
