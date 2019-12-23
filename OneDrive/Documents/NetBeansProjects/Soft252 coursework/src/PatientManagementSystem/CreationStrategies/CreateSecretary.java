/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.CreationStrategies;

import PatientManagementSystem.Accounts.AllAccounts;
import PatientManagementSystem.Accounts.Secretary;
import java.util.ArrayList;

/**
 *
 * @author james
 */
public class CreateSecretary implements CreationStrategy{
    @Override
    public void CreateWorkerAccount(String Password, String Name, String Address){
        AllAccounts Secretarys= AllAccounts.getInstance();
        ArrayList<Secretary> AllSecretarys = Secretarys.getAllSecretarys();
        int NewSecretaryIDGen = AllSecretarys.size();
        NewSecretaryIDGen = NewSecretaryIDGen + 1;
        String NewSecretaryID = String.format("D%05d", NewSecretaryIDGen);
        Secretary secretary= new Secretary();
        secretary.setAddress(Address);
        secretary.setName(Name);
        secretary.setPassword(Password);
        secretary.setUserID(NewSecretaryID);
        Secretarys.addSecretary(secretary);
    }
}
