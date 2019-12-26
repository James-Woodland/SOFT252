/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.PatientFunctionality;

import PatientManagementSystem.Accounts.AllAccounts;
import PatientManagementSystem.Accounts.Doctor;
import PatientManagementSystem.Serialiser.Serialiser;
import PatientManagementSystem.System.DoctorFeedback;
import java.util.ArrayList;

/**
 *
 * @author james
 */
public class RateDoctor {
    public void CreateDoctorRating(int Rating, String Feedback, String DoctorID){
        DoctorFeedback newDoctorFeedback = new DoctorFeedback();
        newDoctorFeedback.setDoctorRating(Rating);
        newDoctorFeedback.setFeedbackNotes(Feedback);
        Serialiser accountSerialiser = new Serialiser("AllAccounts");
        AllAccounts allAccounts = (AllAccounts) accountSerialiser.readObject();
        ArrayList<Doctor> Doctors = allAccounts.getAllDoctors();
        for (Doctor Doctor : Doctors) {
            if (Doctor.getUserID().equals(DoctorID)) {
                newDoctorFeedback.setDoctor(Doctor);
                Doctor.addDoctorFeedback(newDoctorFeedback);
                accountSerialiser.writeObject(allAccounts);
                return;
            }
        }       
    }
}
