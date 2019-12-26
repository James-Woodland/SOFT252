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

    public void setPotentialDates(ArrayList<LocalDate> PotentialDates) {
        this.PotentialDates = PotentialDates;
    }
    private ArrayList<Observer> observers = new ArrayList();
    private static final long serialVersionUID = 7L;
    

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
