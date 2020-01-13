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
import java.time.format.DateTimeFormatter;
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
     * @param DoctorID
     * @param Confirmed
     * @param FileName
     * @return if the corresponding patient is found the return value is true, if the patient isn't found false is returned
     */
    public static boolean ProposeAppointment(String PotentialDate1, String PotentialDate2, String PotentialDate3, String PatientID, String DoctorID, boolean Confirmed, String FileName){
        Appointment appointment = new Appointment();                    
        Serialiser accountSerialiser = new Serialiser(FileName);
        AllAccounts allAccounts = (AllAccounts) accountSerialiser.readObject();
        ArrayList<Patient> AllPatients = allAccounts.getAllPatients();
        ArrayList<Doctor> AllDoctors = allAccounts.getAllDoctors();
        for (int i = 0; i < AllPatients.size(); i++) {
            if (AllPatients.get(i).getUserID().equals(PatientID)) {
                Patient patient = AllPatients.get(i);
                patient.setAppointmentNotification(true);
                appointment.registerObserver(AllPatients.get(i));
                appointment.setPatientName(AllPatients.get(i).getName());                 
                Doctor doctor;
                appointment.setAppointmentConfirmed(Confirmed);                
                ArrayList<LocalDate> PotentialDates = new ArrayList();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
                LocalDate localDate;                
                localDate = LocalDate.parse(PotentialDate1, formatter);
                PotentialDates.add(localDate);
                if (Confirmed == true) {
                    appointment.setConfirmedDate(localDate);                   
                }
                localDate = LocalDate.parse(PotentialDate2, formatter);
                PotentialDates.add(localDate);
                localDate = LocalDate.parse(PotentialDate3, formatter);
                PotentialDates.add(localDate);   
                for (int j = 0; j < AllDoctors.size(); j++) {                   
                    if (AllDoctors.get(j).getUserID().equals(DoctorID)) {
                        appointment.registerObserver(AllDoctors.get(j));
                        AllDoctors.get(j).updateAppointmentDates(PotentialDates, appointment);
                        AllDoctors.get(j).addPossibleAppointment(appointment);
                        AllDoctors.get(j).setAppointmentNotification(true);
                        appointment.setDoctorName(AllDoctors.get(j).getName());
                        AllPatients.get(i).addAppointment(appointment);
                        break;
                    }
                }  
                if (Confirmed == false) {
                    for (int j = 0; j < allAccounts.getAllSecretarys().size(); j++) {
                        allAccounts.getAllSecretarys().get(i).addAppointmentProposition(appointment);
                        allAccounts.getAllSecretarys().get(i).setAppointmentNotification(true);
                    }
                }               
                accountSerialiser.writeObject(allAccounts);               
                return true;
            }
        }
        return false;
    }
}
