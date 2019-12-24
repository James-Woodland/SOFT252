/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.CreationStrategies;

import PatientManagementSystem.Accounts.Admin;
import PatientManagementSystem.Accounts.AllAccounts;
import PatientManagementSystem.Serialiser.Serialiser;
import java.util.ArrayList;
/**
 *
 * @author james
 */
public class CreateAdmin implements CreationStrategy{
    @Override
    public void CreateWorkerAccount(String Password, String Name, String Address){   
        Serialiser serialiser = new Serialiser("AllAccounts");
        AllAccounts Admins = (AllAccounts) serialiser.readObject();
        ArrayList<Admin> AllAdmins = Admins.getAllAdmins();
        Admin admin = new Admin();
        //for loop used to generate UserIDs. Checks each version of of a Admin User id from A0001 - A9999 to make sure all possible values can be used 
        //and the assigned UserID is unique.
        for (int i = 0; i <= AllAdmins.size(); i++) {
            int NewAdminIDGen = i + 1; 
            //generates a string in format A(0001-9999)
            String NewAdminID = String.format("A%04d", NewAdminIDGen);
            if (AllAdmins.isEmpty() || i == AllAdmins.size()) {
                admin.setUserID(NewAdminID);
                break;
            }
            else if (!AllAdmins.get(i).getUserID().equals(NewAdminID)) {
                admin.setUserID(NewAdminID);
                break;
            }      
        }                     
        admin.setAddress(Address);
        admin.setName(Name);
        admin.setPassword(Password);
        Admins.addAdmin(admin);
        serialiser.writeObject(Admins);
    }
}
