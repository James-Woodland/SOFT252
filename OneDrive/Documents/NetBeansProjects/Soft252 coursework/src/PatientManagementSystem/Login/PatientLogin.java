/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.Login;


import PatientManagementSystem.Accounts.AllAccounts;
import PatientManagementSystem.Accounts.Patient;
import PatientManagementSystem.Serialiser.Serialiser;
import java.util.ArrayList;

/**
 *
 * @author james
 */
public class PatientLogin extends Login{
    Serialiser serialiser;
    AllAccounts allAccounts;
    ArrayList<Patient> patients;

    /**
     *
     * @param Password
     * @param FileName
     * @return
     */
    @Override
    protected boolean CheckPassword(String Password, String FileName){
        serialiser = new Serialiser(FileName);
        allAccounts = (AllAccounts) serialiser.readObject();
        patients = allAccounts.getAllPatients();
        for (int i = 0; i < patients.size(); i++) {                   
            if (patients.get(i).getPassword().equals(Password)) {                                                     
                return true;
            }
            }
        return false;
    }

    /**
     *
     * @param Username
     * @param FileName
     * @return
     */
    @Override
    protected boolean CheckUsername(String Username, String FileName){
        for (int i = 0; i < patients.size(); i++) {                   
            if (patients.get(i).getUserID().equals(Username)) {                                                     
                return true;
            }
            }
        return false;
        
    }
}
