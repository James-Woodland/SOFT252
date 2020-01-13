/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.CreationStrategies;

import PatientManagementSystem.Accounts.AllAccounts;
import PatientManagementSystem.Accounts.Secretary;
import PatientManagementSystem.Serialiser.Serialiser;
import java.util.ArrayList;

/**
 *
 * @author james
 */
public class CreateSecretary implements CreationStrategy{

    /**
     * Creates an secretary account with a given, name, address and password.
     * Auto generates the lowest available secretary ID.
     * @param Password
     * @param Name
     * @param Address
     * @param FileName
     */
    @Override
    public void CreateWorkerAccount(String Password, String Name, String Address, String FileName){
        Serialiser serialiser = new Serialiser(FileName);
        AllAccounts Secretarys= (AllAccounts) serialiser.readObject();
        ArrayList<Secretary> AllSecretarys = Secretarys.getAllSecretarys();       
        Secretary secretary= new Secretary();
        //for loop used to generate UserIDs. Checks each version of of a Secretary User id from S0001 - S9999 to make sure all possible values can be used 
        //and the assigned UserID is unique.
        for (int i = 0; i <= AllSecretarys.size(); i++) {
            int NewSecretaryIDGen = i + 1;  
            //generates a string in format S(0001-9999)
            String NewSecretaryID = String.format("S%04d", NewSecretaryIDGen);
            if (AllSecretarys.isEmpty() || i == AllSecretarys.size()) {
                secretary.setUserID(NewSecretaryID);
                break;
            }
            else if (!AllSecretarys.get(i).getUserID().equals(NewSecretaryID)) {
                secretary.setUserID(NewSecretaryID);
                break;
            }      
        }     
        secretary.setAddress(Address);
        secretary.setName(Name);
        secretary.setPassword(Password);      
        Secretarys.addSecretary(secretary);
        serialiser.writeObject(Secretarys);
    }
}
