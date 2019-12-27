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
import PatientManagementSystem.System.Appointment;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author james
 */
public class ProposeAppointments {
    /**
     * allows a doctor to create an appointment with up to 3 potential dates proposed.updates the AllAccounts file with the new additions;
     * @param PotentialDate1
     * @param PotentialDate2
     * @param PotentialDate3
     * @param PatientID
     * @param doctor
     * @param Confirmed
     * @return if the corresponding patient is found the return value is true, if the patient isn't found false is returned
     */
    public boolean ProposeAppointment(String PotentialDate1, String PotentialDate2, String PotentialDate3, String PatientID, Doctor doctor, boolean Confirmed){
        Appointment appointment = new Appointment();                    
        Serialiser accountSerialiser = new Serialiser("AllAccounts");
        AllAccounts allAccounts = (AllAccounts) accountSerialiser.readObject();
        ArrayList<Patient> AllPatients = allAccounts.getAllPatients();
        for (int i = 0; i < AllPatients.size(); i++) {
            if (AllPatients.get(i).getUserID().equals(PatientID)) {
                appointment.registerObserver(AllPatients.get(i)); 
                appointment.registerObserver(doctor);
                appointment.setAppointmentConfirmed(Confirmed);                
                ArrayList<LocalDate> PotentialDates = new ArrayList();
                LocalDate localDate;                
                localDate = LocalDate.parse(PotentialDate1);
                PotentialDates.add(localDate);
                if (Confirmed == true) {
                    appointment.setConfirmedDate(localDate);
                }
                localDate = LocalDate.parse(PotentialDate2);
                PotentialDates.add(localDate);
                localDate = LocalDate.parse(PotentialDate3);
                PotentialDates.add(localDate);
                doctor.updateAppointmentDates(PotentialDates, appointment);
                for (int j = 0; j < allAccounts.getAllSecretarys().size(); j++) {
                    allAccounts.getAllSecretarys().get(i).addAppointmentProposition(appointment);
                }
                accountSerialiser.writeObject(allAccounts);               
                return true;
            }
        }
        return false;
    }
}
