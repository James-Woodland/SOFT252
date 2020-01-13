/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.Accounts;

import PatientManagementSystem.CreateAccount.CreateAccount;
import PatientManagementSystem.AdminFunctionality.Delete;
import PatientManagementSystem.AdminFunctionality.GenerateFeedbackReport;
import PatientManagementSystem.AdminFunctionality.ViewDoctorRatings;
import java.util.ArrayList;

/**
 *
 * @author james
 */
public class Admin extends User implements java.io.Serializable{
    private static final long serialVersionUID = 2L;

    /**
     * used to create an account of type admin, secretary or doctor
     * @param AccountType
     * @param Password
     * @param Name
     * @param Address
     */
    public void CreateAccount(String AccountType, String Password, String Name, String Address){
        CreateAccount createAccount = new CreateAccount(AccountType);        
        createAccount.executeStrategy(Password, Name, Address, "AllAccounts");   
    }

    /**
     * used to remove an account of type doctor or secretary
     * @param AccountType
     * @param Username
     */
    public void RemoveAccount(String AccountType, String Username){       
        Delete.DeleteAccount(AccountType, Username, "AllAccounts");
    }

    /**
     * Used to return all the ratings all doctors have.
     * Used to generate an average rating for each doctor.
     * @return
     */
    public ArrayList<Object> GetDoctorRatings(){        
        return ViewDoctorRatings.GetDoctorRatings("AllAccounts");
    }

    /**
     * generates a feedback report that allows the doctor to see all their comments and 
     * an average rating.
     * @param DoctorID
     * @return
     */
    public ArrayList<Object> GenerateFeedbackReport(String DoctorID){        
        return GenerateFeedbackReport.GenerateNewFeedbackReport(DoctorID, "AllAccounts");
    }
}
