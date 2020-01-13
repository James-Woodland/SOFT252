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
    
    /**
     *
     * @return
     */
    public ArrayList<Doctor> getAllDoctors() {
        return AllDoctors;
    }
       
    /**
     *
     * @return
     */
    public ArrayList<Patient> getAllPatients() {
        return AllPatients;
    }
   
    /**
     *
     * @return
     */
    public ArrayList<Secretary> getAllSecretarys() {
        return AllSecretarys;
    }
       
    /**
     *
     * @return
     */
    public ArrayList<Admin> getAllAdmins() {
        return AllAdmins;
    }
    //editors
    //adders
   
    /**
     *
     * @param patient
     */
    public void addPatient(Patient patient){
        AllPatients.add(patient);
    }
        
    /**
     *
     * @param doctor
     */
    public void addDoctor(Doctor doctor){
        AllDoctors.add(doctor);
    }
        
    /**
     *
     * @param secretary
     */
    public void addSecretary(Secretary secretary){
        AllSecretarys.add(secretary);
    }
        
    /**
     *
     * @param admin
     */
    public void addAdmin(Admin admin){
        AllAdmins.add(admin);
    }
    //removers
  
    /**
     *
     * @param admin
     */
    public void removeAdmin(Admin admin){
        AllAdmins.remove(admin);
    }
       
    /**
     *
     * @param secretary
     */
    public void removeSecretary(Secretary secretary){
        AllSecretarys.remove(secretary);
    }
       
    /**
     *
     * @param doctor
     */
    public void removeDoctor(Doctor doctor){
        AllDoctors.remove(doctor);
    }
        
    /**
     *
     * @param patient
     */
    public void removePatient(Patient patient){
        AllPatients.remove(patient);
    }
        
    /**
     *
     * @param AllDoctors
     */
    public void setAllDoctors(ArrayList<Doctor> AllDoctors) {
        this.AllDoctors = AllDoctors;
    }
   
    /**
     *
     * @param AllPatients
     */
    public void setAllPatients(ArrayList<Patient> AllPatients) {
        this.AllPatients = AllPatients;
    }
   
    /**
     *
     * @param AllSecretarys
     */
    public void setAllSecretarys(ArrayList<Secretary> AllSecretarys) {
        this.AllSecretarys = AllSecretarys;
    }
   
    /**
     *
     * @param AllAdmins
     */
    public void setAllAdmins(ArrayList<Admin> AllAdmins) {
        this.AllAdmins = AllAdmins;
    }
    
}
