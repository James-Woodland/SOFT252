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
public class PatientNote implements java.io.Serializable{
    private String NoteCreator;
    private String Note;

    /**
     *
     * @return
     */
    public String getNoteCreator() {
        return NoteCreator;
    }

    /**
     *
     * @param NoteCreator
     */
    public void setNoteCreator(String NoteCreator) {
        this.NoteCreator = NoteCreator;
    }

    /**
     *
     * @return
     */
    public String getNote() {
        return Note;
    }

    /**
     *
     * @param Note
     */
    public void setNote(String Note) {
        this.Note = Note;
    }
}
