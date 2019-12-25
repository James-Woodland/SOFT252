/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.Functionality;

import PatientManagementSystem.Accounts.AllAccounts;
import PatientManagementSystem.Accounts.Doctor;
import PatientManagementSystem.Serialiser.Serialiser;
import PatientManagementSystem.System.DoctorFeedback;
import java.util.ArrayList;

/**
 *
 * @author james
 */
public class ViewDoctorRatings {
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
}
