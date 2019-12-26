/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.System;

import PatientManagementSystem.Accounts.Doctor;
import PatientManagementSystem.Accounts.Patient;
import PatientManagementSystem.System.Medicine.Medicine;

/**
 *
 * @author james
 */
public class Prescription implements java.io.Serializable{
    private Medicine medicine;
    private int Dosage;
    private Patient patient;
    private Doctor doctor;
    private String DoctorNote;
    private int Quantity;
    private static final long serialVersionUID = 9L;
    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public int getDosage() {
        return Dosage;
    }

    public void setDosage(int Dosage) {
        this.Dosage = Dosage;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getDoctorNote() {
        return DoctorNote;
    }

    public void setDoctorNote(String DoctorNote) {
        this.DoctorNote = DoctorNote;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }
}
