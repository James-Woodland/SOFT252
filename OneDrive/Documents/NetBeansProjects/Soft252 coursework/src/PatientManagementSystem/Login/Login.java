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

    /**
     *
     * @param Password
     * @param Username
     * @param FileName
     * @return
     */
    public final boolean AttemptLogin(String Password, String Username, String FileName){
        boolean password = CheckPassword(Password, FileName);
        boolean username = CheckUsername(Username, FileName);
        return CheckResults(password, username);
    }
    
    /**
     *
     * @param Password
     * @param FileName
     * @return
     */
    protected abstract boolean CheckPassword(String Password, String FileName);

    /**
     *
     * @param Username
     * @param FileName
     * @return
     */
    protected abstract boolean CheckUsername(String Username, String FileName);   

    /**
     *
     * @param password
     * @param username
     * @return
     */
    protected boolean CheckResults(boolean password, boolean username){
        if (username == true && password == true) {            
            return true;
        }
        return false;
    }
}
