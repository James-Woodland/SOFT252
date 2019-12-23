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
    private ArrayList<Doctor> AllDoctors;
    private ArrayList<Patient> AllPatients;
    private ArrayList<Secretary> AllSecretarys;
    private ArrayList<Admin> AllAdmins;
    private static AllAccounts single_instance = null;
    
    private AllAccounts(){
        AllDoctors = new ArrayList();
        AllPatients = new ArrayList();
        AllSecretarys = new ArrayList();
        AllAdmins = new ArrayList();
    }
    
    public static AllAccounts getInstance() 
    { 
        if (single_instance == null) 
            single_instance = new AllAccounts(); 
  
        return single_instance; 
    } 
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
    
}
