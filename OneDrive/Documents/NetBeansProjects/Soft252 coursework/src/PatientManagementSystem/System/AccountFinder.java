/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.System;

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
public class AccountFinder {
    public String FindAccount(String UserID, String AccountType){
        Serialiser accountSerialiser = new Serialiser("AllAccounts");
        AllAccounts allAccounts = (AllAccounts) accountSerialiser.readObject();        
        switch(AccountType){
            case("Patient"):
                ArrayList<Patient> patientAccounts;
                patientAccounts = allAccounts.getAllPatients();
                for (int i = 0; i < patientAccounts.size(); i++) {
                    Patient patient = patientAccounts.get(i);
                    if (patient.getUserID().equals(UserID)) {
                        return patient.getName();
                    }
                }
                break;
            case("Admin"):
                ArrayList<Admin> adminAccounts;
                adminAccounts = allAccounts.getAllAdmins();
                for (int i = 0; i < adminAccounts.size(); i++) {
                    Admin admin = adminAccounts.get(i);
                    if (admin.getUserID().equals(UserID)) {
                        return admin.getName();
                    }
                }
                break;
            case("Doctor"):
                ArrayList<Doctor> doctorAccounts;
                doctorAccounts = allAccounts.getAllDoctors();
                for (int i = 0; i < doctorAccounts.size(); i++) {
                    Doctor doctor = doctorAccounts.get(i);
                    if (doctor.getUserID().equals(UserID)) {
                        return doctor.getName();
                    }
                }
                break;
            default:
                ArrayList<Secretary> secretaryAccounts;
                secretaryAccounts = allAccounts.getAllSecretarys();
                for (int i = 0; i < secretaryAccounts.size(); i++) {
                    Secretary secretary = secretaryAccounts.get(i);
                    if (secretary.getUserID().equals(UserID)) {
                        return secretary.getName();
                    }
                }
                break;
        
        }
    return null; 
    } 
}
