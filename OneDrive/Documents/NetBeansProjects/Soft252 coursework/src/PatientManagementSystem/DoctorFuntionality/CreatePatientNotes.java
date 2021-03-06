/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.DoctorFuntionality;

import PatientManagementSystem.Accounts.AllAccounts;
import PatientManagementSystem.Accounts.Doctor;
import PatientManagementSystem.Accounts.Patient;
import PatientManagementSystem.Serialiser.Serialiser;
import PatientManagementSystem.System.PatientNote;
import java.util.ArrayList;

/**
 *
 * @author james
 */
public class CreatePatientNotes {

    /**
     * creates a note for a given patient
     * updates the AllAccounts file with the new additions;
     * @param PatientID
     * @param Note
     * @param doctor
     * @param FileName
     * @return returns false if the patient can;t be found, returns true if the patient can be.
     */ 
    public static boolean CreatePatientNote(String PatientID, String Note, String doctor, String FileName){
        Serialiser accountSerialiser = new Serialiser(FileName);
        AllAccounts allAccounts = (AllAccounts) accountSerialiser.readObject();
        ArrayList<Patient> AllPatients = allAccounts.getAllPatients();
        PatientNote patientNote = new PatientNote();
        patientNote.setNote(Note);
        patientNote.setNoteCreator(doctor);      
        for (int i = 0; i < AllPatients.size(); i++) {
            if (AllPatients.get(i).getUserID().equals(PatientID)) {
                AllPatients.get(i).addNote(patientNote);
                accountSerialiser.writeObject(allAccounts);
                allAccounts = (AllAccounts) accountSerialiser.readObject();                          
                return true;
            }
        }
        return false;
    } 
}
