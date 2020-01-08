/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.Accounts;

import PatientManagementSystem.AdminFunctionality.Delete;
import PatientManagementSystem.CreateAccount.CreateAccount;
import PatientManagementSystem.DoctorFuntionality.ProposeAppointments;
import PatientManagementSystem.Serialiser.Serialiser;
import PatientManagementSystem.System.AccountRequest;
import PatientManagementSystem.System.Appointment;
import PatientManagementSystem.System.Medicine.AllMedicines;
import PatientManagementSystem.System.Medicine.Medicine;
import PatientManagementSystem.System.MedicineRequest;
import PatientManagementSystem.System.RemoveAccountRequest;
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

    public Boolean getAppointmentNotification() {
        return AppointmentNotification;
    }

    public void setAppointmentNotification(Boolean AppointmentNotification) {
        this.AppointmentNotification = AppointmentNotification;
    }
    private static final long serialVersionUID = 5L;

    public Boolean getAccountRequestNotification() {
        return AccountRequestNotification;
    }

    public void setAccountRequestNotification(Boolean AccountRequestNotification) {
        this.AccountRequestNotification = AccountRequestNotification;
    }

    public Boolean getRemovalRequestNotification() {
        return RemovalRequestNotification;
    }

    public void setRemovalRequestNotification(Boolean RemovalRequestNotification) {
        this.RemovalRequestNotification = RemovalRequestNotification;
    }

    public Boolean getMedicineRequestNotification() {
        return medicineRequestNotification;
    }

    public void setMedicineRequestNotification(Boolean medicineRequestNotification) {
        this.medicineRequestNotification = medicineRequestNotification;
    }

    public List<AccountRequest> getAccountRequests() {
        return AccountRequests;
    }

    public List<MedicineRequest> getMedicineRequests() {
        return MedicineRequests;
    }
    
     public ArrayList<RemoveAccountRequest> getRemovalRequests() {
        return AccountRemovalRequest;
    }
    
    public void addMecineRequest(MedicineRequest medicineRequest){
        this.MedicineRequests.add(medicineRequest);
    }
    
    public void addAccountRequest(AccountRequest accountRequest){
        this.AccountRequests.add(accountRequest);
    }
    
    public void addRemoveAccountRequest(RemoveAccountRequest removeAccountRequest){
        this.AccountRemovalRequest.add(removeAccountRequest);
    }
    
    public void addAppointmentProposition(Appointment appointment){
        this.AppointmentProposition.add(appointment);
    }
    
    public void removeMecineRequest(MedicineRequest medicineRequest){
        this.MedicineRequests.remove(medicineRequest);
    }
    
    public void removeAccountRequest(int index){
        this.AccountRequests.remove(index);       
    }
    
    public void removeRemoveAccountRequest(int index){
        this.AccountRemovalRequest.remove(index);
    }
    
    public void removeAppointmentProposition(Appointment appointment){
        this.AppointmentProposition.remove(appointment);
    }
    
    public void RemovePatientAccount(RemoveAccountRequest removeAccountRequest, int index){
        Delete DeletePatientAccount = new Delete();
        DeletePatientAccount.DeleteAccount("Patient", removeAccountRequest.getAccountToBeRemoved().getUserID());
        Serialiser accountSerialiser = new Serialiser("AllAccounts");
        AllAccounts allAccounts = (AllAccounts) accountSerialiser.readObject();
        ArrayList<Secretary> Secretarys = allAccounts.getAllSecretarys(); 
        for (int i = 0; i < Secretarys.size(); i++) {
            Secretarys.get(i).removeRemoveAccountRequest(index);
        }
        accountSerialiser.writeObject(allAccounts);
    }
    
    public void RestockMedicine(int medicineIndex, int Amount){
        Serialiser medicineSerialiser = new Serialiser("AllMedicines");
        AllMedicines allMedicines = (AllMedicines) medicineSerialiser.readObject();  
        Medicine medicine = allMedicines.getAllMedicines().get(medicineIndex);
        medicine.Restock(Amount);
        medicineSerialiser.writeObject(allMedicines);
    }
    
    public boolean  GiveMedicine(int medicineIndex, int Amount){
        Serialiser medicineSerialiser = new Serialiser("AllMedicines");
        AllMedicines allMedicines = (AllMedicines) medicineSerialiser.readObject();  
        Medicine medicine = allMedicines.getAllMedicines().get(medicineIndex);
        boolean MedicineGiven = medicine.GiveMedicine(Amount);
        medicineSerialiser.writeObject(allMedicines);
        return MedicineGiven;
    }
    //not tested
    //move into own class
    public void CreatePatientAccount(AccountRequest accountRequest, int index){
        CreateAccount createAccount = new CreateAccount("Patient");
        createAccount.executeStrategy(accountRequest.getPotentialPassword(), accountRequest.getPotentialPatientName(), accountRequest.getPotentialPatientAddress());
        Serialiser accountSerialiser = new Serialiser("AllAccounts");
        AllAccounts allAccounts = (AllAccounts) accountSerialiser.readObject();
        ArrayList<Patient> Patients = allAccounts.getAllPatients();
        Patient CurrentPatient = Patients.get(Patients.size()-1);
        CurrentPatient.setDob(accountRequest.getDoB());
        CurrentPatient.setGender(accountRequest.getPotentialGender());
        ArrayList<Secretary> Secretarys = allAccounts.getAllSecretarys();        
        for (int i = 0; i < Secretarys.size(); i++) {
            Secretarys.get(i).removeAccountRequest(index);
        }
        accountSerialiser.writeObject(allAccounts);
    }
    
    //move to own class
    public boolean RequestAppointment(String PotentialDate1, String PotentialDate2, String PotentialDate3, String PatientID,String DoctorID){
        ProposeAppointments proposeAppointment = new ProposeAppointments();
        return proposeAppointment.ProposeAppointment(PotentialDate1, PotentialDate2, PotentialDate3, PatientID, DoctorID, true);
    }
}
