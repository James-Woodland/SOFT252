/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SecretaryFunctionality;

import PatientManagementSystem.Accounts.AllAccounts;
import PatientManagementSystem.Accounts.Secretary;
import PatientManagementSystem.AdminFunctionality.Delete;
import PatientManagementSystem.Serialiser.Serialiser;
import PatientManagementSystem.System.RemoveAccountRequest;
import java.util.ArrayList;

/**
 *
 * @author james
 */
public class RemovePatientAccount {

    /**
     * removes an account using the information from a given account request 
     * then removes that account removal request from every secretary account
     * @param removeAccountRequest
     * @param index
     * @param FileName
     */
    public static void removePatientAccount(RemoveAccountRequest removeAccountRequest, int index, String FileName){        
        Delete.DeleteAccount("Patient", removeAccountRequest.getAccountToBeRemoved().getUserID(), FileName);
        Serialiser accountSerialiser = new Serialiser(FileName);
        AllAccounts allAccounts = (AllAccounts) accountSerialiser.readObject();
        ArrayList<Secretary> Secretarys = allAccounts.getAllSecretarys(); 
        for (int i = 0; i < Secretarys.size(); i++) {
            Secretarys.get(i).removeRemoveAccountRequest(index);
        }
        accountSerialiser.writeObject(allAccounts);
    }
}
