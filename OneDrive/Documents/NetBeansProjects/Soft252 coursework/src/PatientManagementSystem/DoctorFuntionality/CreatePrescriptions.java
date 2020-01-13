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
import PatientManagementSystem.System.Medicine.AllMedicines;
import PatientManagementSystem.System.Medicine.Medicine;
import PatientManagementSystem.System.Prescription;
import java.util.ArrayList;

/**
 *
 * @author james
 */
public class CreatePrescriptions {

    /**
     * Creates a prescription for given patient
     * updates the AllAccounts file with the new additions;
     * @param PatientID
     * @param DoctorNote
     * @param MedicineName
     * @param Quantity
     * @param Dosage
     * @param AccountFile
     * @param MedicineFile
     * @return returns false if the patient or medicine aren't found to be in the system, returns true if they are.
     */
    public static boolean CreatePrescription(String PatientID, String DoctorNote, String MedicineName, int Quantity, int Dosage/*, Doctor doctor*/, String AccountFile, String MedicineFile){
        Serialiser accountSerialiser = new Serialiser(AccountFile);
        AllAccounts allAccounts = (AllAccounts) accountSerialiser.readObject();
        ArrayList<Patient> AllPatients = allAccounts.getAllPatients();
        Prescription prescription = new Prescription();
        Patient patient = null;
        Medicine medicine = null;
        for (int i = 0; i < AllPatients.size(); i++) {
            if (AllPatients.get(i).getUserID().equals(PatientID)) {
               patient = AllPatients.get(i); 
               patient.setPrescriptionNotification(true);               
                prescription.setDoctorNote(DoctorNote);
                prescription.setDosage(Dosage);
                prescription.setQuantity(Quantity);
                Serialiser medicineSerialiser = new Serialiser(MedicineFile);
                AllMedicines allMedicines = (AllMedicines) medicineSerialiser.readObject();
                for (int j = 0; j < allMedicines.getAllMedicines().size(); j++) {
                    if (allMedicines.getAllMedicines().get(j).getMedicineName().equals(MedicineName)) {
                       medicine = allMedicines.getAllMedicines().get(j);
                       prescription.setMedicine(medicine);
                       patient.addPrescription(prescription);
                       accountSerialiser.writeObject(allAccounts);
                       return true;
                    }
                }                 
                return false;
            }
        } 
        return false;
    }
}
