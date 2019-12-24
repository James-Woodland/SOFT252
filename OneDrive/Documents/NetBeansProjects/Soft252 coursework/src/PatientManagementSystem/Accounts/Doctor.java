/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.Accounts;

import PatientManagementSystem.System.Appointment;
import PatientManagementSystem.System.DoctorFeedback;
import PatientManagementSystem.System.Prescription;
import java.util.ArrayList;
import PatientManagementSystem.System.Observer;
import PatientManagementSystem.System.Observable;
import java.time.LocalDate;

/**
 *
 * @author james
 */
public class Doctor extends User implements java.io.Serializable, Observer{
    private ArrayList<Prescription> WrittenPrescriptions = new ArrayList();
    private ArrayList<Appointment> PossibleAppointments = new ArrayList();
    private ArrayList<DoctorFeedback> DoctorFeedback = new ArrayList();
    private static final long serialVersionUID = 3L;
    //getters
    public ArrayList<Prescription> getWrittenPrescriptions() {
        return WrittenPrescriptions;
    }

    public ArrayList<Appointment> getPossibleAppointments() {
        return PossibleAppointments;
    }

    public ArrayList<DoctorFeedback> getDoctorFeedback() {
        return DoctorFeedback;
    }
    
    public void DoctorObserver(Observable observable){
        observable.registerObserver(this);
    }
    //Adders
    public void addPrescription(Prescription presciption){
        this.WrittenPrescriptions.add(presciption);
    }
    
    public void addPossibleAppointment(Appointment appointment){
        this.PossibleAppointments.add(appointment);
    }
    
    public void addDoctorFeedback(DoctorFeedback doctorFeedback){
        this.DoctorFeedback.add(doctorFeedback);
    }
    
   
    //observer
    @Override
    public void updateAppointmentDates(LocalDate[] PotentialDates, Appointment appointment){
        appointment.setPotentialDates(PotentialDates);
    }
}
