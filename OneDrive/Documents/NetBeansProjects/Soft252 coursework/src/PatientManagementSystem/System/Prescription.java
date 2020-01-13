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
//    private Patient patient;
//    private Doctor doctor;
    private String DoctorNote;
    private int Quantity;
    private static final long serialVersionUID = 9L;

    /**
     *
     * @return
     */
    public Medicine getMedicine() {
        return medicine;
    }

    /**
     *
     * @param medicine
     */
    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    /**
     *
     * @return
     */
    public int getDosage() {
        return Dosage;
    }

    /**
     *
     * @param Dosage
     */
    public void setDosage(int Dosage) {
        this.Dosage = Dosage;
    }

//    public Patient getPatient() {
//        return patient;
//    }
//
//    public void setPatient(Patient patient) {
//        this.patient = patient;
//    }
//
//    public Doctor getDoctor() {
//        return doctor;
//    }
//
//    public void setDoctor(Doctor doctor) {
//        this.doctor = doctor;
//    }

    /**
     *
     * @return
     */

    public String getDoctorNote() {
        return DoctorNote;
    }

    /**
     *
     * @param DoctorNote
     */
    public void setDoctorNote(String DoctorNote) {
        this.DoctorNote = DoctorNote;
    }

    /**
     *
     * @return
     */
    public int getQuantity() {
        return Quantity;
    }

    /**
     *
     * @param Quantity
     */
    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }
}
