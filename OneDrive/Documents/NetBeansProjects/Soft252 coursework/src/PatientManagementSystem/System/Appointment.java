/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.System;

import PatientManagementSystem.Accounts.Doctor;
import PatientManagementSystem.Accounts.Patient;
import java.time.*;

/**
 *
 * @author james
 */
public class Appointment implements java.io.Serializable{
    private Doctor doctor;
    private Patient patient;
    private LocalDate[] PotentialDates;

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
}
