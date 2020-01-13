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

    /**
     * Creates a rating for a given doctor with a rating and feedback
     * 
     * @param Rating
     * @param Feedback
     * @param DoctorIndex
     * @param FileName
     */
    public static void CreateDoctorRating(int Rating, String Feedback, int DoctorIndex, String FileName){
        DoctorFeedback newDoctorFeedback = new DoctorFeedback();
        newDoctorFeedback.setDoctorRating(Rating);
        newDoctorFeedback.setFeedbackNotes(Feedback);
        Serialiser accountSerialiser = new Serialiser(FileName);
        AllAccounts allAccounts = (AllAccounts) accountSerialiser.readObject();
        ArrayList<Doctor> Doctors = allAccounts.getAllDoctors();
        newDoctorFeedback.setDoctor(Doctors.get(DoctorIndex));
        Doctors.get(DoctorIndex).addDoctorFeedback(newDoctorFeedback);
        accountSerialiser.writeObject(allAccounts);                
    }
}
