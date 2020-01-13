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
public class User implements java.io.Serializable{
    private String name = "";
    private String Password = "";
    private String UserID = "";
    private String Address = "";      
    
    /**
     *
     * @param Input
     * @return
     */
    public boolean Login(String Input){
        boolean Login = false;
        if (this.getPassword() == null ? Input == null : this.getPassword().equals(Input)) {
            Login = true;
        }
        return Login;
    };
       
    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return Password;
    }

    /**
     *
     * @param Password
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     *
     * @return
     */
    public String getUserID() {
        return UserID;
    }

    /**
     *
     * @param UserID
     */
    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    /**
     *
     * @return
     */
    public String getAddress() {
        return Address;
    }

    /**
     *
     * @param Address
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }
    
}
