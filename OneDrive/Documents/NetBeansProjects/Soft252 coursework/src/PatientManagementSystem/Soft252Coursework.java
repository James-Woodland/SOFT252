/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem;

import PatientManagementSystem.Accounts.Admin;
import PatientManagementSystem.Accounts.AllAccounts;
import java.util.ArrayList;


/**
 *
 * @author james
 */
public class Soft252Coursework {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AllAccounts allAccounts = AllAccounts.getInstance();
        ArrayList<Admin> Admins = allAccounts.getAllAdmins();
        Admin admin = new Admin();
        admin.setName("Bob");
        admin.setAddress("1 Larch Close");
        admin.setUserID("A0001");
        admin.setPassword("Boris");
        allAccounts.addAdmin(admin);
        
        admin.CreateAccount("Admin", "test", "James", "2 Larch Close");
        for (int i = 0; i < Admins.size(); i++) {
            System.out.println(Admins.get(i).getName());
        }
    }
}
