/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.Accounts;

import java.util.ArrayList;


/**
 *
 * @author james
 */
public class AllAccounts implements java.io.Serializable{
    private ArrayList<Doctor> AllDoctors = new ArrayList();
    private ArrayList<Patient> AllPatients = new ArrayList();   
    private ArrayList<Secretary> AllSecretarys = new ArrayList();
    private ArrayList<Admin> AllAdmins = new ArrayList();
    private static final long serialVersionUID = 1L;   
    //getters
    public ArrayList<Doctor> getAllDoctors() {
        return AllDoctors;
    }
   
    public ArrayList<Patient> getAllPatients() {
        return AllPatients;
    }
   
    public ArrayList<Secretary> getAllSecretarys() {
        return AllSecretarys;
    }
   

    public ArrayList<Admin> getAllAdmins() {
        return AllAdmins;
    }
    //editors
    //adders
    public void addPatient(Patient patient){
        AllPatients.add(patient);
    }
    
    public void addDoctor(Doctor doctor){
        AllDoctors.add(doctor);
    }
    
    public void addSecretary(Secretary secretary){
        AllSecretarys.add(secretary);
    }
    
    public void addAdmin(Admin admin){
        AllAdmins.add(admin);
    }
    //removers
    public void removeAdmin(Admin admin){
        AllAdmins.remove(admin);
    }
    
    public void removeSecretary(Secretary secretary){
        AllSecretarys.remove(secretary);
    }
    
    public void removeDoctor(Doctor doctor){
        AllDoctors.remove(doctor);
    }
    
    public void removePatient(Patient patient){
        AllPatients.remove(patient);
    }
    
    public void setAllDoctors(ArrayList<Doctor> AllDoctors) {
        this.AllDoctors = AllDoctors;
    }

    public void setAllPatients(ArrayList<Patient> AllPatients) {
        this.AllPatients = AllPatients;
    }

    public void setAllSecretarys(ArrayList<Secretary> AllSecretarys) {
        this.AllSecretarys = AllSecretarys;
    }

    public void setAllAdmins(ArrayList<Admin> AllAdmins) {
        this.AllAdmins = AllAdmins;
    }
    
}
