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

    public Boolean getAppointmentNotification() {
        return AppointmentNotification;
    }

    public void setAppointmentNotification(Boolean AppointmentNotification) {
        this.AppointmentNotification = AppointmentNotification;
    }

    public ArrayList<Appointment> getPossibleAppointments() {
        return PossibleAppointments;
    }

    public ArrayList<DoctorFeedback> getDoctorFeedback() {
        return DoctorFeedback;
    }
    
    public void DoctorObserver(Observable observable){
        observable.registerObserver(this);
        this.setAppointmentNotification(true);
    }
    //Adders
//    public void addPrescription(Prescription presciption){
//        this.WrittenPrescriptions.add(presciption);
//    }
    
    public void addPossibleAppointment(Appointment appointment){
        this.PossibleAppointments.add(appointment);
    }
    
    public void addDoctorFeedback(DoctorFeedback doctorFeedback){
        this.DoctorFeedback.add(doctorFeedback);
    }
    //not tested    
    public ArrayList<Appointment> ViewAppointments(){
        return this.getPossibleAppointments();
    }
    //not tested  
    public ArrayList<Appointment> InspectPatientHistory(String PatientID){
        ViewPatientHistory viewPatientHistory = new ViewPatientHistory();
        return viewPatientHistory.InspectPatientHistory(PatientID);       
    }
    //not tested    
    public boolean CreatePrescription(String PatientID, String DoctorNote, String MedicineName, int Quantity, int Dosage){
        CreatePrescriptions createPresciption = new CreatePrescriptions();  
        
        return createPresciption.CreatePrescription(PatientID, DoctorNote, MedicineName, Quantity, Dosage, this);   
    }
    //not tested   
    public void CreateMedicineAndOrder(String MedicineName, int RestockAmount){
        CreateMedicineAndRequestRestock CreateMedicineAndRequestRestock = new CreateMedicineAndRequestRestock();
        CreateMedicineAndRequestRestock.createNewMedicine(MedicineName);
        CreateMedicineAndRequestRestock.createMedicineRestockRequest(MedicineName, RestockAmount);
    }   
    public boolean CreatePatientNote(String PatientID, String Note, String DoctorID){
        CreatePatientNotes createPatientNotes = new CreatePatientNotes();
        return createPatientNotes.CreatePatientNote(PatientID, Note, DoctorID);
    } 
    //not tested
    //move to own class
    public boolean ProposeorCreateAppointment(String PotentialDate1, String PotentialDate2, String PotentialDate3, String PatientID, boolean appointmentConfirmed){
        ProposeAppointments proposeAppointment = new ProposeAppointments();
        return proposeAppointment.ProposeAppointment(PotentialDate1, PotentialDate2, PotentialDate3, PatientID, this.getUserID(), appointmentConfirmed);
    }
    //observer
    @Override
    public void updateAppointmentDates(ArrayList<LocalDate> PotentialDates, Appointment appointment){
        appointment.setPotentialDates(PotentialDates);
    }
}
