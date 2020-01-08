/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.Accounts;
import PatientManagementSystem.AdminFunctionality.ViewDoctorRatings;
import PatientManagementSystem.DoctorFuntionality.ProposeAppointments;
import PatientManagementSystem.PatientFunctionality.CreateAccountRequest;
import PatientManagementSystem.PatientFunctionality.RateDoctor;
import PatientManagementSystem.Serialiser.Serialiser;
import PatientManagementSystem.System.Appointment;
import PatientManagementSystem.System.Observable;
import PatientManagementSystem.System.Prescription;
import java.time.*;
import java.util.ArrayList;
import PatientManagementSystem.System.Observer;
import PatientManagementSystem.System.Observable;
import PatientManagementSystem.System.PatientNote;
import PatientManagementSystem.System.RemoveAccountRequest;
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
    //not tested
    public ArrayList<Object> GetDoctorRatings(){
        ViewDoctorRatings viewDoctorRatings = new ViewDoctorRatings();
        return viewDoctorRatings.GetDoctorRatings();
    }
    //not tested
    //gets the most recently added prescription for the patient
    //assuming this is waht's emant when the spec says view Presciptionsingular
    //and doesn;t mean view a particular prescription
    public Prescription ViewPrescription(){
        if (Prescriptions.size()-1 >= 0) {
            return this.Prescriptions.get(Prescriptions.size()-1);
        }
        return null;
    }
    //not tested
    //gets the most recently added Appointment for the patient
    //assuming this is waht's emant when the spec says view Presciptionsingular
    //and doesn;t mean view a particular prescription
    public Appointment ViewAppointment(){
        if (Appointments.size()-1 >= 0) {
            return this.Appointments.get(Appointments.size()-1);
        }
        return null;
    }
    //not tested
    //move to own class
    public void RemoveAccount(String AccountPassword){
        if (AccountPassword.equals(this.getPassword())) {
            RemoveAccountRequest removeAccountRequest = new RemoveAccountRequest();
            removeAccountRequest.setAccountToBeRemoved(this);
            Serialiser accountSerialiser = new Serialiser("AllAccounts");
            AllAccounts allAccounts = (AllAccounts) accountSerialiser.readObject();
            ArrayList<Secretary> Secretarys = allAccounts.getAllSecretarys();
            for (int i = 0; i < Secretarys.size(); i++) {
                Secretarys.get(i).addRemoveAccountRequest(removeAccountRequest);
            }
            accountSerialiser.writeObject(allAccounts);
        }        
    }
    //move to own class 
    public ArrayList<Appointment> CheckHistory(){
        ArrayList<Appointment> PatientHistory = new ArrayList();
        PatientHistory.addAll(this.getAppointments());       
        return PatientHistory;
    }
    
    public boolean RequestAppointment(String PotentialDate1, String PotentialDate2, String PotentialDate3, String DoctorID){
        ProposeAppointments proposeAppointment = new ProposeAppointments();
        return proposeAppointment.ProposeAppointment(PotentialDate1, PotentialDate2, PotentialDate3, this.getUserID(), DoctorID, false);
    }
    
    public void RateDoctor(String Comment, int rating, int DoctorIndex){
        RateDoctor rateDoctor = new RateDoctor();
        rateDoctor.CreateDoctorRating(rating, Comment, DoctorIndex);
    }
}
