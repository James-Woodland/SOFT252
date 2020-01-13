/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SecretaryFunctionality;

import PatientManagementSystem.Accounts.AllAccounts;
import PatientManagementSystem.Accounts.Patient;
import PatientManagementSystem.Accounts.Secretary;
import PatientManagementSystem.CreateAccount.CreateAccount;
import PatientManagementSystem.Serialiser.Serialiser;
import PatientManagementSystem.System.AccountRequest;
import java.util.ArrayList;

/**
 *
 * @author james
 */
public class CreatePatientAccount {

    /**
     * Creates a patient account from the information in a given account request then
     * removes the given account request from all secretary accounts
     * @param accountRequest
     * @param index
     * @param FileName
     */
    public static void createPatientAccount(AccountRequest accountRequest, int index, String FileName){
        CreateAccount createAccount = new CreateAccount("Patient");
        createAccount.executeStrategy(accountRequest.getPotentialPassword(), accountRequest.getPotentialPatientName(), accountRequest.getPotentialPatientAddress(), "AllAccounts");
        Serialiser accountSerialiser = new Serialiser(FileName);
        AllAccounts allAccounts = (AllAccounts) accountSerialiser.readObject();
        ArrayList<Patient> Patients = allAccounts.getAllPatients();
        Patient CurrentPatient = Patients.get(Patients.size()-1);
        CurrentPatient.setDob(accountRequest.getDoB());
        CurrentPatient.setGender(accountRequest.getPotentialGender());
        ArrayList<Secretary> Secretarys = allAccounts.getAllSecretarys();        
        for (int i = 0; i < Secretarys.size(); i++) {
            Secretarys.get(i).removeAccountRequest(index);
        }
        accountSerialiser.writeObject(allAccounts);
    }
}
