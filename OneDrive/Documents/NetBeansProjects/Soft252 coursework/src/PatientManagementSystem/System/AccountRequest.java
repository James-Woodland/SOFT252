/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.System;
import java.time.*;
/**
 *
 * @author james
 */
public class AccountRequest implements java.io.Serializable{
    private String PotentialPatientName = "";
    private String PotentialPatientAddress = "";
    private String PotentialPassword = "";
    private int PotentialGender = 0;
    private LocalDate DoB;   
    private boolean Completed = false;       
    
    /**
     *
     * @return
     */
    public boolean isCompleted() {
        return Completed;
    }

    /**
     *
     * @param Completed
     */
    public void setCompleted(boolean Completed) {
        this.Completed = Completed;
    }
    private static final long serialVersionUID = 6L;

    /**
     *
     * @return
     */
    public String getPotentialPatientName() {
        return PotentialPatientName;
    }

    /**
     *
     * @param PotentialPatientName
     */
    public void setPotentialPatientName(String PotentialPatientName) {
        this.PotentialPatientName = PotentialPatientName;
    }

    /**
     *
     * @return
     */
    public String getPotentialPatientAddress() {
        return PotentialPatientAddress;
    }

    /**
     *
     * @param PotentialPatientAddress
     */
    public void setPotentialPatientAddress(String PotentialPatientAddress) {
        this.PotentialPatientAddress = PotentialPatientAddress;
    }

    /**
     *
     * @return
     */
    public String getPotentialPassword() {
        return PotentialPassword;
    }

    /**
     *
     * @param PotentialPassword
     */
    public void setPotentialPassword(String PotentialPassword) {
        this.PotentialPassword = PotentialPassword;
    }

    /**
     *
     * @return
     */
    public int getPotentialGender() {
        return PotentialGender;
    }

    /**
     *
     * @param PotentialGender
     */
    public void setProtentialGender(int PotentialGender) {
        if (PotentialGender >= 1 && PotentialGender <=3) {
            this.PotentialGender = PotentialGender;
        }   
    }

    /**
     *
     * @return
     */
    public LocalDate getDoB() {
        return DoB;
    }

    /**
     *
     * @param DoB
     */
    public void setDoB(LocalDate DoB) {
        this.DoB = DoB;
    }
    
}
