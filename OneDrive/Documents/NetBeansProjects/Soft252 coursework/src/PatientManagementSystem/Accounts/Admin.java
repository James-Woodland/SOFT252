/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.Accounts;

import PatientManagementSystem.CreateAccount.CreateAccount;
import PatientManagementSystem.CreationStrategies.CreateAdmin;
import PatientManagementSystem.CreationStrategies.CreationStrategy;

/**
 *
 * @author james
 */
public class Admin extends User implements java.io.Serializable{
    public void CreateAccount(String AccountType, String Password, String Name, String Address){
         CreateAccount createAccount = new CreateAccount();
         createAccount.SelectStrategy(AccountType);
         createAccount.executeStrategy(Password, Name, Address);   
    }
       
}
