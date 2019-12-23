/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.CreationStrategies;

import PatientManagementSystem.Accounts.Admin;
import PatientManagementSystem.Accounts.AllAccounts;
import java.util.ArrayList;
/**
 *
 * @author james
 */
public class CreateAdmin implements CreationStrategy{
    @Override
    public void CreateWorkerAccount(String Password, String Name, String Address){       
        AllAccounts Admins = AllAccounts.getInstance();
        ArrayList<Admin> AllAdmins = Admins.getAllAdmins();
        int NewAdminIDGen = AllAdmins.size();
        NewAdminIDGen = NewAdminIDGen + 1;
        String NewAdminID = String.format("A%05d", NewAdminIDGen);
        Admin admin = new Admin();
        admin.setAddress(Address);
        admin.setName(Name);
        admin.setPassword(Password);
        admin.setUserID(NewAdminID);
        Admins.addAdmin(admin);
    }
}
