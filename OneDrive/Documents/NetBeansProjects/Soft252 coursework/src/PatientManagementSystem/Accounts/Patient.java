/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.Accounts;
import PatientManagementSystem.System.Appointment;
import PatientManagementSystem.System.Observable;
import PatientManagementSystem.System.Prescription;
import java.time.*;
import java.util.ArrayList;
import PatientManagementSystem.System.Observer;
import PatientManagementSystem.System.Observable;
import PatientManagementSystem.System.PatientNote;
/**
 *
 * @author james
 */
public class Patient extends User implements java.io.Serializable, Observer{
    private int Gender = 0;
    private LocalDate Dob;
    private ArrayList<Prescription> Prescriptions = new ArrayList();
    private ArrayList<Appointment> Appointments = new ArrayList();
    private ArrayList<PatientNote> PatientNotes = new ArrayList();

    public ArrayList<PatientNote> getPatientNotes() {
        return PatientNotes;
    }

    public ArrayList<Prescription> getPrescriptions() {
        return Prescriptions;
    }

    public ArrayList<Appointment> getAppointments() {
        return Appointments;
    }
    
    private static final long serialVersionUID = 4L;

    public int getGender() {
        return Gender;
    }

    public void setGender(int Gender) {
        if (Gender >= 1 && Gender <=3) {
            this.Gender = Gender;
        }       
    }
    
    public void PatientObserver(Observable observable){
        observable.registerObserver(this);
    }
    @Override
    public void updateAppointmentDates(ArrayList<LocalDate> PotentialDates, Appointment appointment){
        appointment.setPotentialDates(PotentialDates);
    }

    public LocalDate getDob() {
        return Dob;
    }

    public void setDob(LocalDate Dob) {
        this.Dob = Dob;
    }
    
    public void addPrescription(Prescription presciption){
        this.Prescriptions.add(presciption);
    }
    
    public void addAppointment(Appointment appointment){
        this.Appointments.add(appointment);
    }
    
    public void addNote(PatientNote Note){
        this.PatientNotes.add(Note);
    }
    
    
}
