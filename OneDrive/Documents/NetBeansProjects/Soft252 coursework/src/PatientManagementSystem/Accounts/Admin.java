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
import PatientManagementSystem.Serialiser.Serialiser;
import PatientManagementSystem.System.DoctorFeedback;
import java.util.ArrayList;

/**
 *
 * @author james
 */
public class Admin extends User implements java.io.Serializable{
    private static final long serialVersionUID = 2L;
    public void CreateAccount(String AccountType, String Password, String Name, String Address){
        CreateAccount createAccount = new CreateAccount(AccountType);        
        createAccount.executeStrategy(Password, Name, Address);   
    }
    public void RemoveAccount(String AccountType, String Username, String Password){
        Delete delete = new Delete();
        delete.DeleteAccount(AccountType, Username, Password);
    }
    public ArrayList<Object> GetDoctorRatings(){
        ViewDoctorRatings viewDoctorRatings = new ViewDoctorRatings();
        ArrayList<Object> DoctorRatings = viewDoctorRatings.GetDoctorRatings();
        return DoctorRatings;
    }
    public ArrayList<Object> GenerateFeedbackReport(String DoctorID){
        GenerateFeedbackReport generateFeedbackReport = new GenerateFeedbackReport();
        ArrayList<Object> DoctorFeedbackReport = generateFeedbackReport.GenerateNewFeedbackReport(DoctorID);
        return DoctorFeedbackReport;
    }
}
