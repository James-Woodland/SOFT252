/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.System;

import PatientManagementSystem.Accounts.Doctor;
import PatientManagementSystem.Accounts.Patient;
import java.time.*;
import java.util.ArrayList;
import PatientManagementSystem.System.Observable;
/**
 *
 * @author james
 */
public class Appointment implements java.io.Serializable, Observable{
    
    private ArrayList<LocalDate> PotentialDates = new ArrayList();
    private LocalDate ConfirmedDate;   
    private boolean AppointmentConfirmed;   
    private ArrayList<Observer> observers = new ArrayList();
    private String DoctorName;
    private String PatientName;

    public String getDoctorName() {
        return DoctorName;
    }

    public void setDoctorName(String DoctorName) {
        this.DoctorName = DoctorName;
    }

    public String getPatientName() {
        return PatientName;
    }

    public void setPatientName(String PatientName) {
        this.PatientName = PatientName;
    }
    private static final long serialVersionUID = 7L;
    
    public LocalDate getConfirmedDate() {
        return ConfirmedDate;
    }

    public void setConfirmedDate(LocalDate ConfirmedDate) {
        this.ConfirmedDate = ConfirmedDate;
    }
    
    public boolean isAppointmentConfirmed() {
        return AppointmentConfirmed;
    }

    public void setAppointmentConfirmed(boolean AppointmentConfirmed) {
        this.AppointmentConfirmed = AppointmentConfirmed;
    }
    
    public void setPotentialDates(ArrayList<LocalDate> PotentialDates) {
        this.PotentialDates = PotentialDates;
    }   
    
    public  ArrayList<LocalDate> getPotentialDates() {
        return PotentialDates;
    }
     
   
    public void addPotentialDate(LocalDate Date){
        this.PotentialDates.add(Date);
    }
    
    public void removePotentialDate(LocalDate Date){
        this.PotentialDates.remove(Date);
    }
    
    @Override
    public void registerObserver(Observer observer){
        observers.add(observer);       
    }  
    @Override
    public void notifyObserver(){
        for (Observer observer: observers) {
            observer.updateAppointmentDates(PotentialDates, this);
        }
    }
}
