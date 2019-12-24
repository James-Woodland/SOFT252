/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.CreationStrategies;

import PatientManagementSystem.Accounts.Admin;
import PatientManagementSystem.Accounts.AllAccounts;
import PatientManagementSystem.Accounts.Doctor;
import PatientManagementSystem.Serialiser.Serialiser;
import java.util.ArrayList;

/**
 *
 * @author james
 */
public class CreateDoctor implements CreationStrategy{
    @Override
    public void CreateWorkerAccount(String Password, String Name, String Address){
        Serialiser serialiser = new Serialiser("AllAccounts");
        AllAccounts Doctors = (AllAccounts) serialiser.readObject();
        ArrayList<Doctor> AllDoctors = Doctors.getAllDoctors();       
        Doctor doctor = new Doctor();
        //for loop used to generate UserIDs. Checks each version of of a Doctor User id from D0001 - D9999 to make sure all possible values can be used 
        //and the assigned UserID is unique.
        for (int i = 0; i <= AllDoctors.size(); i++) {
            int NewDoctorIDGen = i + 1;        
            //generates a string in format D(0001-9999)
            String NewDoctorID = String.format("D%04d", NewDoctorIDGen);
            if (AllDoctors.isEmpty() || i == AllDoctors.size()) {
                doctor.setUserID(NewDoctorID);
                break;
            }
            else if (!AllDoctors.get(i).getUserID().equals(NewDoctorID)) {
                doctor.setUserID(NewDoctorID);
                break;
            }      
        }     
        doctor.setAddress(Address);
        doctor.setName(Name);
        doctor.setPassword(Password);        
        Doctors.addDoctor(doctor);
        serialiser.writeObject(Doctors);
    }
}
