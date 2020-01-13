/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.System;

import PatientManagementSystem.Accounts.Doctor;

/**
 *
 * @author james
 */
public class DoctorFeedback implements java.io.Serializable{
    private Doctor doctor;
    private int DoctorRating = 0;
    private String FeedbackNotes = "";
    private static final long serialVersionUID = 8L;

    /**
     *
     * @return
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     *
     * @param doctor
     */
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    /**
     *
     * @return
     */
    public int getDoctorRating() {
        return DoctorRating;
    }

    /**
     *
     * @param DoctorRating
     */
    public void setDoctorRating(int DoctorRating) {
        this.DoctorRating = DoctorRating;
    }

    /**
     *
     * @return
     */
    public String getFeedbackNotes() {
        return FeedbackNotes;
    }

    /**
     *
     * @param FeedbackNotes
     */
    public void setFeedbackNotes(String FeedbackNotes) {
        this.FeedbackNotes = FeedbackNotes;
    }
}
