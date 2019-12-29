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
    private ArrayList<RemoveAccountRequest> AccountRemovalRequest = new ArrayList();
    private ArrayList<MedicineRequest> MedicineRequests = new ArrayList();
    private ArrayList<Appointment> AppointmentProposition = new ArrayList();
    private static final long serialVersionUID = 5L;

    public List<AccountRequest> getAccountRequests() {
        return AccountRequests;
    }

    public List<MedicineRequest> getMedicineRequests() {
        return MedicineRequests;
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
    
    public void removeAccountRequest(AccountRequest accountRequest){
        this.AccountRequests.remove(accountRequest);
    }
    
    public void removeRemoveAccountRequest(RemoveAccountRequest removeAccountRequest){
        this.AccountRemovalRequest.remove(removeAccountRequest);
    }
    
    public void removeAppointmentProposition(Appointment appointment){
        this.AppointmentProposition.remove(appointment);
    }
    
    public void RemovePatientAccount(RemoveAccountRequest removeAccountRequest){
        Delete DeletePatientAccount = new Delete();
        DeletePatientAccount.DeleteAccount("Patient", removeAccountRequest.getAccountToBeRemoved().getUserID());
    }
    
    public void RestockMedicine(Medicine medicine, int Amount){
        medicine.Restock(Amount);
    }
    
    public boolean GiveMedicine(Medicine medicine, int Amount){
        return medicine.GiveMedicine(Amount);
    }
    //not tested
    //move into own class
    public void CreatePatientAccount(AccountRequest accountRequest){
        CreateAccount createAccount = new CreateAccount("Patient");
        createAccount.executeStrategy(accountRequest.getPotentialPassword(), accountRequest.getPotentialPatientName(), accountRequest.getPotentialPatientAddress());
        Serialiser accountSerialiser = new Serialiser("AllAccounts");
        AllAccounts allAccounts = (AllAccounts) accountSerialiser.readObject();
        ArrayList<Patient> Patients = allAccounts.getAllPatients();
        Patient CurrentPatient = Patients.get(Patients.size()-1);
        CurrentPatient.setDob(accountRequest.getDoB());
        CurrentPatient.setGender(accountRequest.getPotentialGender());
        accountSerialiser.writeObject(allAccounts);
    }
    
    //move to own class
    public boolean RequestAppointment(String PotentialDate1, String PotentialDate2, String PotentialDate3, Patient patient,Doctor doctor){
        ProposeAppointments proposeAppointment = new ProposeAppointments();
        return proposeAppointment.ProposeAppointment(PotentialDate1, PotentialDate2, PotentialDate3, patient.getUserID(), doctor, true);
    }
}
