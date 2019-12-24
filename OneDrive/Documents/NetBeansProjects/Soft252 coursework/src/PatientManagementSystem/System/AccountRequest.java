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
    private int AccountRequestType = 1;
    private static final long serialVersionUID = 6L;

    public String getPotentialPatientName() {
        return PotentialPatientName;
    }

    public void setPotentialPatientName(String PotentialPatientName) {
        this.PotentialPatientName = PotentialPatientName;
    }

    public String getPotentialPatientAddress() {
        return PotentialPatientAddress;
    }

    public void setPotentialPatientAddress(String PotentialPatientAddress) {
        this.PotentialPatientAddress = PotentialPatientAddress;
    }

    public String getPotentialPassword() {
        return PotentialPassword;
    }

    public void setPotentialPassword(String PotentialPassword) {
        this.PotentialPassword = PotentialPassword;
    }

    public int getPotentialGender() {
        return PotentialGender;
    }

    public void setProtentialGender(int PotentialGender) {
        if (PotentialGender >= 1 && PotentialGender <=3) {
            this.PotentialGender = PotentialGender;
        }   
    }

    public LocalDate getDoB() {
        return DoB;
    }

    public void setDoB(LocalDate DoB) {
        this.DoB = DoB;
    }
    
}
