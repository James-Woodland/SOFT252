/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.PatientFunctionality;

import PatientManagementSystem.Accounts.AllAccounts;
import PatientManagementSystem.Accounts.Patient;
import PatientManagementSystem.Accounts.Secretary;
import PatientManagementSystem.Serialiser.Serialiser;
import PatientManagementSystem.System.RemoveAccountRequest;
import java.util.ArrayList;

/**
 *
 * @author james
 */
public class CreateRemovalRequest {

    /**
     * Allows a patient to create a removal request
     * then gives this removal request to all secretarys
     * @param AccountPassword
     * @param PatientAccount
     * @param FileName
     */
    public static void RemoveAccount(String AccountPassword, Patient PatientAccount, String FileName){
        if (AccountPassword.equals(PatientAccount.getPassword())) {
            RemoveAccountRequest removeAccountRequest = new RemoveAccountRequest();
            removeAccountRequest.setAccountToBeRemoved(PatientAccount);
            Serialiser accountSerialiser = new Serialiser(FileName);
            AllAccounts allAccounts = (AllAccounts) accountSerialiser.readObject();
            ArrayList<Secretary> Secretarys = allAccounts.getAllSecretarys();
            for (int i = 0; i < Secretarys.size(); i++) {
                Secretarys.get(i).addRemoveAccountRequest(removeAccountRequest);
                Secretarys.get(i).setRemovalRequestNotification(true);
            }
            accountSerialiser.writeObject(allAccounts);
        }        
    }
}
