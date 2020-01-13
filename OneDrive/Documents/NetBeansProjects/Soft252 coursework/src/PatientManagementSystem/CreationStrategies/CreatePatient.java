/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.CreationStrategies;

import PatientManagementSystem.Accounts.AllAccounts;
import PatientManagementSystem.Accounts.Patient;
import PatientManagementSystem.Serialiser.Serialiser;
import java.util.ArrayList;

/**
 * 
 * @author james
 */
public class CreatePatient implements CreationStrategy{

    /**
     * Creates an patient account with a given, name, address and password.
     * Auto generates the lowest available patient ID.
     * @param Password
     * @param Name
     * @param Address
     * @param FileName
     */
    @Override
    public void CreateWorkerAccount(String Password, String Name, String Address, String FileName){
        Serialiser serialiser = new Serialiser(FileName);
        AllAccounts Patients = (AllAccounts) serialiser.readObject();
        ArrayList<Patient> AllPatients = Patients.getAllPatients();       
        Patient patient = new Patient();
        //for loop used to generate UserIDs. Checks each version of of a Doctor User id from P0001 - P9999 to make sure all possible values can be used 
        //and the assigned UserID is unique.
        for (int i = 0; i <= AllPatients.size(); i++) {
            int NewPatientIDGen = i + 1;        
            //generates a string in format P(0001-9999)
            String NewPatientID = String.format("P%04d", NewPatientIDGen);
            if (AllPatients.isEmpty() || i == AllPatients.size()) {
                patient.setUserID(NewPatientID);
                break;
            }
            else if (!AllPatients.get(i).getUserID().equals(NewPatientID)) {
                patient.setUserID(NewPatientID);
                break;
            }      
        }     
        patient.setAddress(Address);
        patient.setName(Name);
        patient.setPassword(Password);        
        Patients.addPatient(patient);
        serialiser.writeObject(Patients);
    }
}
