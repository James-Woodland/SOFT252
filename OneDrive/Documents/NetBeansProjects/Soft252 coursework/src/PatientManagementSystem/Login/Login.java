/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.Login;

/**
 *
 * @author james
 */
public abstract class Login { 
    public final void AttemptLogin(String Password, String Username){
        boolean password = CheckPassword(Password);
        boolean username = CheckUsername(Username);
        CheckResults(password, username);
    }
    
    protected abstract boolean CheckPassword(String Password);
    protected abstract boolean CheckUsername(String Username);   
    protected boolean CheckResults(boolean password, boolean username){
        if (username == true && password == true) {
            System.out.println("Logged in");
            return true;
        }
        return false;
    }
}
