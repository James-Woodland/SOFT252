/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.Accounts;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author james
 */
public class AllAccounts implements java.io.Serializable{
    private List<Doctor> AllDoctors = new ArrayList();
    private List<Patient> AllPatients = new ArrayList();
    private List<Secretary> AllSecretarys = new ArrayList();
    private List<Admin> AllAdmins = new ArrayList();
    //getters
    public List<Doctor> getAllDoctors() {
        return AllDoctors;
    }
   
    public List<Patient> getAllPatients() {
        return AllPatients;
    }
   

    public List<Secretary> getSecretary() {
        return AllSecretarys;
    }
   

    public List<Admin> getAdmin() {
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
    
    public void removerPatient(Patient patient){
        AllPatients.remove(patient);
    }
    
}
