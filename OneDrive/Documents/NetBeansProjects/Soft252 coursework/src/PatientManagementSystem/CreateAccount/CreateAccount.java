/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.CreateAccount;

import PatientManagementSystem.CreationStrategies.CreationStrategy;
import PatientManagementSystem.CreationStrategies.CreateSecretary;
import PatientManagementSystem.CreationStrategies.CreateDoctor;
import PatientManagementSystem.CreationStrategies.CreateAdmin;

/**
 *
 * @author james
 */
public class CreateAccount {
    private CreationStrategy Strategy; 
          
    public CreateAccount(){
        this.Strategy = new CreateAdmin();
    }

    public void setStrategy(CreationStrategy Strategy) {
        this.Strategy = Strategy;
    }
    
    public static CreationStrategy SelectStrategy(String AccountType){
        CreationStrategy Strategy;
        switch(AccountType){
            case "Admin":
                Strategy = new CreateAdmin();
                break;
            case "Secretary":
                Strategy = new CreateSecretary();
                break;
            case "Doctor":
                Strategy = new CreateDoctor();
                break;
            default:
                Strategy = null;
                System.out.println("No Strategy selected");
                break;
        }
        return Strategy;
    }
    
    public void executeStrategy(String Password, String Name, String Address){
        Strategy.CreateWorkerAccount(Password, Name, Address);
    }
}
