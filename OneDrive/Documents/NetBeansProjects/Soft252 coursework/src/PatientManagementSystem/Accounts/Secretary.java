/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.Accounts;

import PatientManagementSystem.DoctorFuntionality.ProposeAppointments;
import PatientManagementSystem.System.AccountRequest;
import PatientManagementSystem.System.Appointment;
import PatientManagementSystem.System.MedicineRequest;
import PatientManagementSystem.System.RemoveAccountRequest;
import SecretaryFunctionality.CreatePatientAccount;
import SecretaryFunctionality.GiveMedicine;
import SecretaryFunctionality.RemovePatientAccount;
import SecretaryFunctionality.RestockMedicine;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author james
 */
public class Secretary extends User implements java.io.Serializable{
    private ArrayList<AccountRequest> AccountRequests = new ArrayList();
    private Boolean AccountRequestNotification = false;
    private ArrayList<RemoveAccountRequest> AccountRemovalRequest = new ArrayList();
    private Boolean RemovalRequestNotification = false;
    private ArrayList<MedicineRequest> MedicineRequests = new ArrayList();
    private Boolean medicineRequestNotification = false;
    private ArrayList<Appointment> AppointmentProposition = new ArrayList();
    private Boolean AppointmentNotification = false;    

    /**
     *
     * @return
     */
    public Boolean getAppointmentNotification() {
        return AppointmentNotification;
    }

    /**
     *
     * @param AppointmentNotification
     */
    public void setAppointmentNotification(Boolean AppointmentNotification) {
        this.AppointmentNotification = AppointmentNotification;
    }
    private static final long serialVersionUID = 5L;

    /**
     *
     * @return
     */
    public Boolean getAccountRequestNotification() {
        return AccountRequestNotification;
    }

    /**
     *
     * @param AccountRequestNotification
     */
    public void setAccountRequestNotification(Boolean AccountRequestNotification) {
        this.AccountRequestNotification = AccountRequestNotification;
    }

    /**
     *
     * @return
     */
    public Boolean getRemovalRequestNotification() {
        return RemovalRequestNotification;
    }

    /**
     *
     * @param RemovalRequestNotification
     */
    public void setRemovalRequestNotification(Boolean RemovalRequestNotification) {
        this.RemovalRequestNotification = RemovalRequestNotification;
    }

    /**
     *
     * @return
     */
    public Boolean getMedicineRequestNotification() {
        return medicineRequestNotification;
    }

    /**
     *
     * @param medicineRequestNotification
     */
    public void setMedicineRequestNotification(Boolean medicineRequestNotification) {
        this.medicineRequestNotification = medicineRequestNotification;
    }

    /**
     *
     * @return
     */
    public List<AccountRequest> getAccountRequests() {
        return AccountRequests;
    }

    /**
     *
     * @return
     */
    public List<MedicineRequest> getMedicineRequests() {
        return MedicineRequests;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<RemoveAccountRequest> getRemovalRequests() {
        return AccountRemovalRequest;
    }
    
    /**
     *
     * @param medicineRequest
     */
    public void addMecineRequest(MedicineRequest medicineRequest){
        this.MedicineRequests.add(medicineRequest);
    }
    
    /**
     *
     * @param accountRequest
     */
    public void addAccountRequest(AccountRequest accountRequest){
        this.AccountRequests.add(accountRequest);
    }
    
    /**
     *
     * @param removeAccountRequest
     */
    public void addRemoveAccountRequest(RemoveAccountRequest removeAccountRequest){
        this.AccountRemovalRequest.add(removeAccountRequest);
    }
    
    /**
     *
     * @param appointment
     */
    public void addAppointmentProposition(Appointment appointment){
        this.AppointmentProposition.add(appointment);
    }
    
    /**
     *
     * @param medicineRequest
     */
    public void removeMecineRequest(MedicineRequest medicineRequest){
        this.MedicineRequests.remove(medicineRequest);
    }
    
    /**
     *
     * @param index
     */
    public void removeAccountRequest(int index){
        this.AccountRequests.remove(index);       
    }
    
    /**
     *
     * @param index
     */
    public void removeRemoveAccountRequest(int index){
        this.AccountRemovalRequest.remove(index);
    }
    
    /**
     *
     * @param appointment
     */
    public void removeAppointmentProposition(Appointment appointment){
        this.AppointmentProposition.remove(appointment);
    }
    
    /**
     * Removes a given patient account
     * @param removeAccountRequest
     * @param index
     */
    public void RemovePatientAccount(RemoveAccountRequest removeAccountRequest, int index){        
        RemovePatientAccount.removePatientAccount(removeAccountRequest, index, "AllAccounts");
    }
    
    /**
     * Restocks a medicine for a given amount 
     * @param medicineIndex
     * @param Amount
     */
    public void RestockMedicine(int medicineIndex, int Amount){
        RestockMedicine.restockMedicine(medicineIndex, Amount, "AllMedicines");
    }
    
    /**
     * Gives a given amount for a given medicine, behaviour depends on the medicine state
     * @param medicineIndex
     * @param Amount
     * @return
     */
    public boolean  GiveMedicine(int medicineIndex, int Amount){        
        return GiveMedicine.GiveMedicine(medicineIndex, Amount, "AllMedicines");
    }   

    /**
     * Allows the Secretary to create patient accounts from patient account requests
     * @param accountRequest
     * @param index
     */
    public void CreatePatientAccount(AccountRequest accountRequest, int index){
        CreatePatientAccount.createPatientAccount(accountRequest, index, "AllAccounts");
    }
     

    /**
     * Allows a Secretary to create an appointment between a patient and a doctor that 
     * @param PotentialDate1
     * @param PotentialDate2
     * @param PotentialDate3
     * @param PatientID
     * @param DoctorID
     * @return
     */
    public boolean RequestAppointment(String PotentialDate1, String PotentialDate2, String PotentialDate3, String PatientID,String DoctorID){       
        return ProposeAppointments.ProposeAppointment(PotentialDate1, PotentialDate2, PotentialDate3, PatientID, DoctorID, true, "AllAccounts");
    }
}
