/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.Accounts;

import PatientManagementSystem.DoctorFuntionality.CreateMedicineAndRequestRestock;
import PatientManagementSystem.DoctorFuntionality.CreatePatientNotes;
import PatientManagementSystem.DoctorFuntionality.CreatePrescriptions;
import PatientManagementSystem.DoctorFuntionality.ProposeAppointments;
import PatientManagementSystem.DoctorFuntionality.ViewPatientHistory;
import PatientManagementSystem.System.Appointment;
import PatientManagementSystem.System.DoctorFeedback;
import java.util.ArrayList;
import PatientManagementSystem.System.Observer;
import PatientManagementSystem.System.Observable;
import java.time.LocalDate;


/**
 *
 * @author james
 */
public class Doctor extends User implements java.io.Serializable, Observer{
//    private ArrayList<Prescription> WrittenPrescriptions = new ArrayList();
    private ArrayList<Appointment> PossibleAppointments = new ArrayList();
    private Boolean AppointmentNotification = false;
    private ArrayList<DoctorFeedback> DoctorFeedback = new ArrayList();
    private static final long serialVersionUID = 3L;
    //getters
//    public ArrayList<Prescription> getWrittenPrescriptions() {
//        return WrittenPrescriptions;
//    }

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
    public ArrayList<Appointment> getPossibleAppointments() {
        return PossibleAppointments;
    }

    /**
     *
     * @return
     */
    public ArrayList<DoctorFeedback> getDoctorFeedback() {
        return DoctorFeedback;
    }
    
    /**
     *
     * @param observable
     */
    public void DoctorObserver(Observable observable){
        observable.registerObserver(this);
        this.setAppointmentNotification(true);
    }
    //Adders
//    public void addPrescription(Prescription presciption){
//        this.WrittenPrescriptions.add(presciption);
//    }
    
    /**
     *
     * @param appointment
     */
    public void addPossibleAppointment(Appointment appointment){
        this.PossibleAppointments.add(appointment);
    }
    
    /**
     *
     * @param doctorFeedback
     */
    public void addDoctorFeedback(DoctorFeedback doctorFeedback){
        this.DoctorFeedback.add(doctorFeedback);
    }      

    /**
     *
     * @return
     */
    public ArrayList<Appointment> ViewAppointments(){
        return this.getPossibleAppointments();
    }  

    /**
     * used to get all the past appointments that a particular patient has had
     * @param PatientID
     * @return
     */
    public ArrayList<Appointment> InspectPatientHistory(String PatientID){       
        return ViewPatientHistory.InspectPatientHistory(PatientID, "AllAccounts");       
    }      

    /**
     * Used to generate a prescription through the CreatePrescriptions class
     * @param PatientID
     * @param DoctorNote
     * @param MedicineName
     * @param Quantity
     * @param Dosage
     * @return
     */
    public boolean CreatePrescription(String PatientID, String DoctorNote, String MedicineName, int Quantity, int Dosage){                
        return CreatePrescriptions.CreatePrescription(PatientID, DoctorNote, MedicineName, Quantity, Dosage,"AllAccounts", "AllMedicines");   
    }    

    /**
     * Used to create a new medicine entry and then generate a medicine request for
     * a certain amount of that medicine
     * @param MedicineName
     * @param RestockAmount
     */
    public void CreateMedicineAndOrder(String MedicineName, int RestockAmount){        
        CreateMedicineAndRequestRestock.createNewMedicine(MedicineName, "AllMedicines");
        CreateMedicineAndRequestRestock.createMedicineRestockRequest(MedicineName, RestockAmount, "AllAccounts", "AllMedicines");
    }   

    /**
     * Creates a patient note for a given patient.
     * @param PatientID
     * @param Note
     * @param DoctorID
     * @return
     */
    public boolean CreatePatientNote(String PatientID, String Note, String DoctorID){       
        return CreatePatientNotes.CreatePatientNote(PatientID, Note, DoctorID, "AllAccounts");
    }    
    /**
     * proposes an appointment for a patient for this doctor. this appointment could be either confirmed
     * @param PotentialDate1
     * @param PotentialDate2
     * @param PotentialDate3
     * @param PatientID
     * @param appointmentConfirmed
     * @return
     */
    public boolean ProposeorCreateAppointment(String PotentialDate1, String PotentialDate2, String PotentialDate3, String PatientID, boolean appointmentConfirmed){       
        return ProposeAppointments.ProposeAppointment(PotentialDate1, PotentialDate2, PotentialDate3, PatientID, this.getUserID(), appointmentConfirmed, "AllAccounts");
    }
    //observer

    /**
     *
     * @param PotentialDates
     * @param appointment
     */
    @Override
    public void updateAppointmentDates(ArrayList<LocalDate> PotentialDates, Appointment appointment){
        appointment.setPotentialDates(PotentialDates);
    }
}
