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
    private Doctor doctor;
    private Patient patient;
    private LocalDate[] PotentialDates = new LocalDate[0];
    private ArrayList<Observer> observers = new ArrayList();

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDate[] getPotentialDates() {
        return PotentialDates;
    }

    public void setPotentialDates(LocalDate[] PotentialDates) {
        this.PotentialDates = PotentialDates;
    }
    
    public void registerObserver(Observer observer){
        observers.add(observer);
    }  
    
    public void notifyObserver(){
        for (Observer observer: observers) {
            observer.update(PotentialDates, this);
        }
    }
}
