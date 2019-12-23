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
import java.util.List;
import PatientManagementSystem.System.Observer;
import PatientManagementSystem.System.Observable;
import java.time.LocalDate;

/**
 *
 * @author james
 */
public class Doctor extends User implements java.io.Serializable, Observer{
    private List<Prescription> WrittenPrescriptions = new ArrayList();
    private List<Appointment> PossibleAppointments = new ArrayList();
    private List<DoctorFeedback> DoctorFeedback = new ArrayList();
    
    public void DoctorObserver(Observable observable){
        observable.registerObserver(this);
    }
    
    public void update(LocalDate[] PotentialDates, Appointment appointment){
        appointment.setPotentialDates(PotentialDates);
    }
}
