/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.Accounts;

import PatientManagementSystem.CreateAccount.CreateAccount;
import PatientManagementSystem.DeleteAccount.Delete;
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
        Serialiser serialiser = new Serialiser("AllAccounts");
        AllAccounts Doctors = (AllAccounts) serialiser.readObject();
        ArrayList<Doctor> AllDoctors = Doctors.getAllDoctors();  
        ArrayList<Object> DoctorRatings = new ArrayList();
        for (int i = 0; i < AllDoctors.size(); i++) {
            int count = 0;
            DoctorRatings.add(Doctors.getAllDoctors().get(i).getUserID());
            float average = 0;
            //gets all the doctor feedbacks for 1 particular doctor
            ArrayList<DoctorFeedback> AllDoctorFeedback = AllDoctors.get(i).getDoctorFeedback();
            if (AllDoctorFeedback.isEmpty()) {
                DoctorRatings.add(-1);
            }
            else{               
                for (int j = 0; j < AllDoctorFeedback.size(); j++) {
                    count++;               
                    average = average + AllDoctorFeedback.get(j).getDoctorRating();
                }
                average = average/count;
                DoctorRatings.add(average);    
            }                   
        }  
        return DoctorRatings;
    }
    public ArrayList<Object> GenerateFeedbackReport(String DoctorID){
        Serialiser serialiser = new Serialiser("AllAccounts");
        AllAccounts Doctors = (AllAccounts) serialiser.readObject();
        ArrayList<Doctor> AllDoctors = Doctors.getAllDoctors();
        ArrayList<Object> DoctorFeedbackReport = new ArrayList();
        ArrayList<DoctorFeedback> AllDoctorFeedback = null;
        int count = 0;
        float average = 0;
        for (int i = 0; i < AllDoctors.size(); i++) {
            if (AllDoctors.get(i).getUserID().equals(DoctorID)) {
                DoctorFeedbackReport.add(AllDoctors.get(count).getUserID());
                AllDoctorFeedback = AllDoctors.get(i).getDoctorFeedback();               
                break;
            }
        }   
        for (int i = 0; i < AllDoctorFeedback.size(); i++) {
            DoctorFeedback doctorfeedback = AllDoctorFeedback.get(i);
            DoctorFeedbackReport.add(doctorfeedback.getFeedbackNotes());
            average = average + doctorfeedback.getDoctorRating();
            count++;
        }
        average = average/count;
        DoctorFeedbackReport.add(average);
        return DoctorFeedbackReport;
    }
}
