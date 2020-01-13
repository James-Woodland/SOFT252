/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.Accounts;
import PatientManagementSystem.AdminFunctionality.ViewDoctorRatings;
import PatientManagementSystem.DoctorFuntionality.ProposeAppointments;
import PatientManagementSystem.PatientFunctionality.CreateRemovalRequest;
import PatientManagementSystem.PatientFunctionality.RateDoctor;
import PatientManagementSystem.System.Appointment;
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
    private Boolean prescriptionNotification = false;
    private ArrayList<Appointment> Appointments = new ArrayList();
    private Boolean AppointmentNotification = false;
    private ArrayList<PatientNote> PatientNotes = new ArrayList();   

    /**
     *
     * @return
     */
    public Boolean getPrescriptionNotification() {
        return prescriptionNotification;
    }

    /**
     *
     * @param prescriptionNotification
     */
    public void setPrescriptionNotification(Boolean prescriptionNotification) {
        this.prescriptionNotification = prescriptionNotification;
    }

    /**
     *
     * @return
     */
    public Boolean getAppointmentNotification() {
        return AppointmentNotification;
    }

    /**
     *
     * @param AppointmentNotification
     */
    public void setAppointmentNotification(Boolean AppointmentNotification) {
        this.AppointmentNotification = AppointmentNotification;
    }

    /**
     *
     * @return
     */
    public ArrayList<PatientNote> getPatientNotes() {
        return PatientNotes;
    }

    /**
     *
     * @return
     */
    public ArrayList<Prescription> getPrescriptions() {
        return Prescriptions;
    }

    /**
     *
     * @return
     */
    public ArrayList<Appointment> getAppointments() {
        return Appointments;
    }
    
    private static final long serialVersionUID = 4L;

    /**
     *
     * @return
     */
    public int getGender() {
        return Gender;
    }

    /**
     *
     * @param Gender
     */
    public void setGender(int Gender) {
        if (Gender >= 1 && Gender <=3) {
            this.Gender = Gender;
        }       
    }
    
    /**
     *
     * @param observable
     */
    public void PatientObserver(Observable observable){
        observable.registerObserver(this);
        this.setAppointmentNotification(true);
    }

    /**
     *
     * @param PotentialDates
     * @param appointment
     */
    @Override
    public void updateAppointmentDates(ArrayList<LocalDate> PotentialDates, Appointment appointment){
        appointment.setPotentialDates(PotentialDates);
    }

    /**
     *
     * @return
     */
    public LocalDate getDob() {
        return Dob;
    }

    /**
     *
     * @param Dob
     */
    public void setDob(LocalDate Dob) {
        this.Dob = Dob;
    }
    
    /**
     *
     * @param presciption
     */
    public void addPrescription(Prescription presciption){
        this.Prescriptions.add(presciption);
    }
    
    /**
     *
     * @param appointment
     */
    public void addAppointment(Appointment appointment){
        this.Appointments.add(appointment);
    }
    
    /**
     *
     * @param Note
     */
    public void addNote(PatientNote Note){
        this.PatientNotes.add(Note);
    }
    //not tested

    /**
     * returns an array containing every doctor and their average rating 
     * @return
     */
    public ArrayList<Object> GetDoctorRatings(){        
        return ViewDoctorRatings.GetDoctorRatings("AllAccounts");
    }
    

    /**
     * returns the most recent prescription
     * @return
     */
    public Prescription ViewPrescription(){
        if (Prescriptions.size()-1 >= 0) {
            return this.Prescriptions.get(Prescriptions.size()-1);
        }
        return null;
    }
    
    /**
     * returns the most recent appointment
     * @return
     */
    public Appointment ViewAppointment(){
        if (Appointments.size()-1 >= 0) {
            return this.Appointments.get(Appointments.size()-1);
        }
        return null;
    }
    //not tested
    //move to own class

    /**
     * create a patient account request assuming that the password matches this accounts password
     * @param AccountPassword
     */
    public void RemoveAccount(String AccountPassword){
        CreateRemovalRequest.RemoveAccount(AccountPassword, this, "AllAccounts");
    }
    //move to own class 

    /**
     * returns all the appointments this patient has had.
     * @return
     */
    public ArrayList<Appointment> CheckHistory(){             
        return this.getAppointments();
    }
    
    /**
     * Creates an Appointment request for the patient with 3 potential dates and a preffered doctor
     * @param PotentialDate1
     * @param PotentialDate2
     * @param PotentialDate3
     * @param DoctorID
     * @return
     */
    public boolean RequestAppointment(String PotentialDate1, String PotentialDate2, String PotentialDate3, String DoctorID){        
        return ProposeAppointments.ProposeAppointment(PotentialDate1, PotentialDate2, PotentialDate3, this.getUserID(), DoctorID, false, "AllAccounts");
    }
    
    /**
     * adds a Doctor rating to a given doctor with a given rating and comment 
     * @param Comment
     * @param rating
     * @param DoctorIndex
     */
    public void RateDoctor(String Comment, int rating, int DoctorIndex){        
        RateDoctor.CreateDoctorRating(rating, Comment, DoctorIndex, "AllAccounts");
    }
}
