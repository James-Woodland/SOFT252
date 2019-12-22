/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.Accounts;
import PatientManagementSystem.System.Appointment;
import PatientManagementSystem.System.Observable;
import PatientManagementSystem.System.Prescription;
import java.time.*;
import java.util.ArrayList;
import PatientManagementSystem.System.Observer;
import PatientManagementSystem.System.Observable;
/**
 *
 * @author james
 */
public class Patient extends User implements java.io.Serializable, Observer{
    private int Gender = 0;
    private LocalDate Dob;
    private ArrayList<Prescription> Prescriptions = new ArrayList();
    private ArrayList<Appointment> Appointments = new ArrayList();

    public int getGender() {
        return Gender;
    }

    public void setGender(int Gender) {
        if (Gender >= 1 && Gender <=3) {
            this.Gender = Gender;
        }       
    }
    
    public Patient(Observable observable){
        observable.registerObserver(this);
    }
    
    public void update(LocalDate[] PotentialDates, Appointment appointment){
        appointment.setPotentialDates(PotentialDates);
    }

    public LocalDate getDob() {
        return Dob;
    }

    public void setDob(LocalDate Dob) {
        this.Dob = Dob;
    }

    
    
}
