/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.Accounts;
import java.time.*;
/**
 *
 * @author james
 */
public class Patient extends User implements java.io.Serializable{
    private int Gender = 0;
    private LocalDate Dob;

    public int getGender() {
        return Gender;
    }

    public void setGender(int Gender) {
        if (Gender >= 1 && Gender <=3) {
            this.Gender = Gender;
        }       
    }

    public LocalDate getDob() {
        return Dob;
    }

    public void setDob(LocalDate Dob) {
        this.Dob = Dob;
    }

    
    
}
