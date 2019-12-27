/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.PatientFunctionality;

import PatientManagementSystem.Accounts.AllAccounts;
import PatientManagementSystem.Accounts.Secretary;
import PatientManagementSystem.Serialiser.Serialiser;
import PatientManagementSystem.System.AccountRequest;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author james
 */
public class CreateAccountRequest {

    /**
     * generate an account request and give that account request to every secretary
     * an account request type of 1 indicates that it is a request to create an account.
     * @param PotentialPatientName
     * @param PotentialPatientAddress
     * @param PotentialPassword
     * @param PotentialGender
     * @param DoB
     * @param AccountRequestType
     */
    public void CreateNewAccountRequest(String PotentialPatientName, String PotentialPatientAddress, String PotentialPassword, int PotentialGender, String DoB){
        AccountRequest accountRequest = new AccountRequest();       
        accountRequest.setDoB(LocalDate.parse(DoB));
        accountRequest.setPotentialPassword(PotentialPassword);
        accountRequest.setPotentialPatientName(PotentialPatientName);
        accountRequest.setPotentialPatientAddress(PotentialPatientAddress);
        accountRequest.setProtentialGender(PotentialGender);   
        Serialiser accountSerialiser = new Serialiser("AllAccounts");
        AllAccounts allAccounts = (AllAccounts) accountSerialiser.readObject();
        ArrayList<Secretary> secretarys = allAccounts.getAllSecretarys();
        for (int i = 0; i < secretarys.size(); i++) {
            Secretary secretary = secretarys.get(i);
            secretary.addAccountRequest(accountRequest);
        }
        accountSerialiser.writeObject(allAccounts);
    }
}
