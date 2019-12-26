/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.AdminFunctionality;

import PatientManagementSystem.Accounts.AllAccounts;
import PatientManagementSystem.Accounts.Doctor;
import PatientManagementSystem.Serialiser.Serialiser;
import PatientManagementSystem.System.DoctorFeedback;
import java.util.ArrayList;

/**
 *
 * @author james
 */
public class GenerateFeedbackReport {

    /**
     * generate a feedback report which contains the average rating of a given doctor and all of the comments that doctor has received.
     * @param DoctorID
     * @return returns an array containing the doctors ID, all their comments, and their average rating.
     */
    public ArrayList<Object> GenerateNewFeedbackReport(String DoctorID){
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
