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

    /**
     *
     * @return
     */
    public String getDoctorName() {
        return DoctorName;
    }

    /**
     *
     * @param DoctorName
     */
    public void setDoctorName(String DoctorName) {
        this.DoctorName = DoctorName;
    }

    /**
     *
     * @return
     */
    public String getPatientName() {
        return PatientName;
    }

    /**
     *
     * @param PatientName
     */
    public void setPatientName(String PatientName) {
        this.PatientName = PatientName;
    }
    private static final long serialVersionUID = 7L;
    
    /**
     *
     * @return
     */
    public LocalDate getConfirmedDate() {
        return ConfirmedDate;
    }

    /**
     *
     * @param ConfirmedDate
     */
    public void setConfirmedDate(LocalDate ConfirmedDate) {
        this.ConfirmedDate = ConfirmedDate;
    }
    
    /**
     *
     * @return
     */
    public boolean isAppointmentConfirmed() {
        return AppointmentConfirmed;
    }

    /**
     *
     * @param AppointmentConfirmed
     */
    public void setAppointmentConfirmed(boolean AppointmentConfirmed) {
        this.AppointmentConfirmed = AppointmentConfirmed;
    }
    
    /**
     *
     * @param PotentialDates
     */
    public void setPotentialDates(ArrayList<LocalDate> PotentialDates) {
        this.PotentialDates = PotentialDates;
    }   
    
    /**
     *
     * @return
     */
    public  ArrayList<LocalDate> getPotentialDates() {
        return PotentialDates;
    }
     
    /**
     *
     * @param Date
     */
    public void addPotentialDate(LocalDate Date){
        this.PotentialDates.add(Date);
    }
    
    /**
     *
     * @param Date
     */
    public void removePotentialDate(LocalDate Date){
        this.PotentialDates.remove(Date);
    }
    
    /**
     *
     * @param observer
     */
    @Override
    public void registerObserver(Observer observer){
        observers.add(observer);       
    }  

    /**
     *
     */
    @Override
    public void notifyObserver(){
        for (Observer observer: observers) {
            observer.updateAppointmentDates(PotentialDates, this);
        }
    }
}
