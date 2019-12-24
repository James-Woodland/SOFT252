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
    
    private LocalDate[] PotentialDates = new LocalDate[0];
    private ArrayList<Observer> observers = new ArrayList();
    

    public LocalDate[] getPotentialDates() {
        return PotentialDates;
    }

    public void setPotentialDates(LocalDate[] PotentialDates) {
        this.PotentialDates = PotentialDates;
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
