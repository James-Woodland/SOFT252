/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.Accounts;

/**
 *
 * @author james
 */
public class Patient extends User{
    private int Gender = 0;
    private int Age = 0;

    public int getGender() {
        return Gender;
    }

    public void setGender(int Gender) {
        if (Gender >= 1 && Gender <=3) {
            this.Gender = Gender;
        }       
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        if (Age > 0) {
            this.Age = Age;
        }
    }
    
}
