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
public class DoctorFeedback {
    private Doctor doctor;
    private int DoctorRating = 0;
    private String[] FeedbackNotes;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public int getDoctorRating() {
        return DoctorRating;
    }

    public void setDoctorRating(int DoctorRating) {
        this.DoctorRating = DoctorRating;
    }

    public String[] getFeedbackNotes() {
        return FeedbackNotes;
    }

    public void setFeedbackNotes(String[] FeedbackNotes) {
        this.FeedbackNotes = FeedbackNotes;
    }
}
