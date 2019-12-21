/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.Accounts;

/**
 *
 * @author james
 */
public class User {
    private String name = "";
    private String Password = "";
    private String UserID = "";
    private String Address = "";

    public boolean Login(String Input){
        boolean Login = false;
        if (this.getPassword() == null ? Input == null : this.getPassword().equals(Input)) {
            Login = true;
        }
        return Login;
    };
       
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }
    
}
