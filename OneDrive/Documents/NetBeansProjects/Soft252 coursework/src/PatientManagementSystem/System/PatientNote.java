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
public class PatientNote {
    private Doctor NoteCreator;
    private String Note;

    public Doctor getNoteCreator() {
        return NoteCreator;
    }

    public void setNoteCreator(Doctor NoteCreator) {
        this.NoteCreator = NoteCreator;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }
}
