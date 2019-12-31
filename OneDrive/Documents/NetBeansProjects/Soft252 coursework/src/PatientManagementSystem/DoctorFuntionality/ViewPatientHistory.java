/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.DoctorFuntionality;

import PatientManagementSystem.Accounts.AllAccounts;
import PatientManagementSystem.Accounts.Patient;
import PatientManagementSystem.Serialiser.Serialiser;
import PatientManagementSystem.System.Appointment;
import PatientManagementSystem.System.PatientNote;
import PatientManagementSystem.System.Prescription;
import java.util.ArrayList;

/**
 *
 * @author james
 */
public class ViewPatientHistory {

    /**
     * returns the full patient history for the patient with the corresponding patient ID
     * @param PatientID
     * @return returns the full patient history as an array of appointments, notes and prescriptions 
     * or returns a list containing the string Patient Not Found if a a patient with a corresponding patient ID isn't found, 
     */
    public ArrayList<Appointment> InspectPatientHistory(String PatientID){
        Serialiser serialiser = new Serialiser("AllAccounts");
        AllAccounts Patients = (AllAccounts) serialiser.readObject();
        ArrayList<Patient> AllPatients = Patients.getAllPatients();
        Patient CurrentPatient;
        ArrayList<Appointment> PatientHistory = new ArrayList();
        for (int i = 0; i < AllPatients.size(); i++) {
            if (AllPatients.get(i).getUserID().equals(PatientID)) {
                CurrentPatient = AllPatients.get(i);                              
                ArrayList<Appointment> AppointmentPrescriptions = CurrentPatient.getAppointments();                                               
                PatientHistory.addAll(AppointmentPrescriptions);
                return PatientHistory;
            }
        }               
        return PatientHistory;
    }
}
