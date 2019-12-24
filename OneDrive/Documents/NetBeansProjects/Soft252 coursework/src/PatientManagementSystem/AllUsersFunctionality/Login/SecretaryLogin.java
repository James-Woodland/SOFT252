/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.AllUsersFunctionality.Login;


import PatientManagementSystem.Accounts.AllAccounts;
import PatientManagementSystem.Accounts.Secretary;
import PatientManagementSystem.Serialiser.Serialiser;
import java.util.ArrayList;

/**
 *
 * @author james
 */
public class SecretaryLogin extends Login{
    Serialiser serialiser = new Serialiser("AllAccounts");
    AllAccounts allAccounts = (AllAccounts) serialiser.readObject();
    ArrayList<Secretary> secretarys = allAccounts.getAllSecretarys();
    @Override
    protected boolean CheckPassword(String Password){
        for (int i = 0; i < secretarys.size(); i++) {                   
            if (secretarys.get(i).getPassword().equals(Password)) {                                                     
                return true;
            }
            }
        return false;
    }
    @Override
    protected boolean CheckUsername(String Username){
        for (int i = 0; i < secretarys.size(); i++) {                   
            if (secretarys.get(i).getUserID().equals(Username)) {                                                     
                return true;
            }
            }
        return false;
        
    }
}
