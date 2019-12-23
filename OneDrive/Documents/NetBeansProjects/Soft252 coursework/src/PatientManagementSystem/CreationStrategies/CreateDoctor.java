/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.CreationStrategies;

import PatientManagementSystem.Accounts.Admin;
import PatientManagementSystem.Accounts.AllAccounts;
import PatientManagementSystem.Accounts.Doctor;
import java.util.ArrayList;

/**
 *
 * @author james
 */
public class CreateDoctor implements CreationStrategy{
    @Override
    public void CreateWorkerAccount(String Password, String Name, String Address){
        AllAccounts Doctors= AllAccounts.getInstance();
        ArrayList<Admin> AllDoctors = Doctors.getAllAdmins();
        int NewDoctorIDGen = AllDoctors.size();
        NewDoctorIDGen = NewDoctorIDGen + 1;
        String NewDoctorID = String.format("D%05d", NewDoctorIDGen);
        Doctor doctor = new Doctor();
        doctor.setAddress(Address);
        doctor.setName(Name);
        doctor.setPassword(Password);
        doctor.setUserID(NewDoctorID);
        Doctors.addDoctor(doctor);
    }
}
