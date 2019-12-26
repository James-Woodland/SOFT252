/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.Accounts;

import PatientManagementSystem.Serialiser.Serialiser;
import PatientManagementSystem.System.Appointment;
import PatientManagementSystem.System.DoctorFeedback;
import PatientManagementSystem.System.Medicine.AllMedicines;
import PatientManagementSystem.System.Medicine.Medicine;
import PatientManagementSystem.System.Medicine.OutOfStock;
import PatientManagementSystem.System.MedicineRequest;
import PatientManagementSystem.System.Prescription;
import java.util.ArrayList;
import PatientManagementSystem.System.Observer;
import PatientManagementSystem.System.Observable;
import PatientManagementSystem.System.PatientNote;
import java.time.LocalDate;


/**
 *
 * @author james
 */
public class Doctor extends User implements java.io.Serializable, Observer{
//    private ArrayList<Prescription> WrittenPrescriptions = new ArrayList();
    private ArrayList<Appointment> PossibleAppointments = new ArrayList();
    private ArrayList<DoctorFeedback> DoctorFeedback = new ArrayList();
    private static final long serialVersionUID = 3L;
    //getters
//    public ArrayList<Prescription> getWrittenPrescriptions() {
//        return WrittenPrescriptions;
//    }

    public ArrayList<Appointment> getPossibleAppointments() {
        return PossibleAppointments;
    }

    public ArrayList<DoctorFeedback> getDoctorFeedback() {
        return DoctorFeedback;
    }
    
    public void DoctorObserver(Observable observable){
        observable.registerObserver(this);
    }
    //Adders
//    public void addPrescription(Prescription presciption){
//        this.WrittenPrescriptions.add(presciption);
//    }
    
    public void addPossibleAppointment(Appointment appointment){
        this.PossibleAppointments.add(appointment);
    }
    
    public void addDoctorFeedback(DoctorFeedback doctorFeedback){
        this.DoctorFeedback.add(doctorFeedback);
    }
    //not tested
    //move to own class
    public ArrayList<Appointment> ViewAppointments(){
        return this.getPossibleAppointments();
    }
    //not tested
    //move to own class
    public ArrayList<Object> InspectPatientHistory(String PatientID){
        Serialiser serialiser = new Serialiser("AllAccounts");
        AllAccounts Patients = (AllAccounts) serialiser.readObject();
        ArrayList<Patient> AllPatients = Patients.getAllPatients();
        Patient CurrentPatient;
        ArrayList<Object> PatientHistory = new ArrayList();
        for (int i = 0; i < AllPatients.size(); i++) {
            if (AllPatients.get(i).getUserID().equals(PatientID)) {
                CurrentPatient = AllPatients.get(i);
                ArrayList<Appointment> PatientAppointments = CurrentPatient.getAppointments();
                ArrayList<Prescription> PatientPrescriptions = CurrentPatient.getPrescriptions();               
                PatientHistory.addAll(PatientAppointments);
                PatientHistory.addAll(PatientPrescriptions);
                return PatientHistory;
            }
        }        
        PatientHistory.add("No History");
        return PatientHistory;
    }
    //not tested
    //move to own class
    public boolean CreatePrescription(String PatientID, String DoctorNote, String MedicineName, int Quantity, int Dosage){
        Serialiser accountSerialiser = new Serialiser("AllAccounts");
        AllAccounts allAccounts = (AllAccounts) accountSerialiser.readObject();
        ArrayList<Patient> AllPatients = allAccounts.getAllPatients();
        Prescription prescription = new Prescription();
        Patient patient = null;
        Medicine medicine = null;
        for (int i = 0; i < AllPatients.size(); i++) {
            if (AllPatients.get(i).getUserID().equals(PatientID)) {
               patient = AllPatients.get(i);
               prescription.setDoctor(this);
                prescription.setPatient(patient);
                prescription.setDoctorNote(DoctorNote);
                prescription.setDosage(Dosage);
                prescription.setQuantity(Quantity);
                Serialiser medicineSerialiser = new Serialiser("AllMedicine");
                AllMedicines allMedicines = (AllMedicines) medicineSerialiser.readObject();
                for (int j = 0; j < allMedicines.getAllMedicines().size(); j++) {
                    if (allMedicines.getAllMedicines().get(j).getMedicineName().equals(MedicineName)) {
                       medicine = allMedicines.getAllMedicines().get(j);
                       prescription.setMedicine(medicine);
                       patient.addPrescription(prescription);
                       return true;
                    }
                }                 
                return false;
            }
        } 
        return false;
    }
    //not tested
    //move to own class
    public void CreateMedicineAndOrder(String MedicineName, int RestockAmount, String SecretaryID){
        createNewMedicine(MedicineName);
        createMedicineRestockRequest(MedicineName, RestockAmount,SecretaryID);
    }
    //not tested
    //move to own class
    public void createNewMedicine(String MedicineName){
        OutOfStock outOfStock = new OutOfStock();
        Medicine medicine = new Medicine(outOfStock);
        medicine.setMedicineName(MedicineName);
        medicine.setStock(0);
        Serialiser medicineSerialiser = new Serialiser("AllMedicine");
        AllMedicines allMedicines = (AllMedicines) medicineSerialiser.readObject();
        allMedicines.addMedcine(medicine);
        medicineSerialiser.writeObject(allMedicines);       
    }
    //not tested
    //move to own class
    public void createMedicineRestockRequest(String MedicineName, int RestockRequestAmount, String SecretaryID){
        Serialiser medicineSerialiser = new Serialiser("AllMedicine");
        AllMedicines allMedicines = (AllMedicines) medicineSerialiser.readObject();
        MedicineRequest medicineRequest = new MedicineRequest(); 
        medicineRequest.setStockRequestAmmount(RestockRequestAmount);
        for (int i = 0; i < allMedicines.getAllMedicines().size(); i++) {
            if (allMedicines.getAllMedicines().get(i).getMedicineName().equals(MedicineName)) {
                medicineRequest.setMedicine(allMedicines.getAllMedicines().get(i));
                break;
            }
        }
        Serialiser accountSerialiser = new Serialiser("AllAccounts");
        AllAccounts allAccounts = (AllAccounts) accountSerialiser.readObject();
        ArrayList<Secretary> AllSecretarys = allAccounts.getAllSecretarys();
        for (int i = 0; i < AllSecretarys.size(); i++) {
            if (AllSecretarys.get(i).getUserID().equals(SecretaryID)) {
                AllSecretarys.get(i).getMedicineRequests().add(medicineRequest);
                break;
            }
        }
        accountSerialiser.writeObject(allAccounts);
    }
    //not tested
    //move to own class
    public boolean CreatePatientNote(String PatientID, String Note){
        PatientNote patientNote = new PatientNote();
        patientNote.setNote(Note);
        patientNote.setNoteCreator(this);
        Serialiser accountSerialiser = new Serialiser("AllAccounts");
        AllAccounts allAccounts = (AllAccounts) accountSerialiser.readObject();
        ArrayList<Patient> AllPatients = allAccounts.getAllPatients();
        for (int i = 0; i < AllPatients.size(); i++) {
            if (AllPatients.get(i).getUserID().equals(PatientID)) {
                AllPatients.get(i).addNote(patientNote);
                return true;
            }
        }
        return false;
    } 
    //not tested
    //move to own class
    public boolean ProposeAppointment(String PotentialDate1, String PotentialDate2, String PotentialDate3, String PatientID){
        Appointment appointment = new Appointment();                    
        Serialiser accountSerialiser = new Serialiser("AllAccounts");
        AllAccounts allAccounts = (AllAccounts) accountSerialiser.readObject();
        ArrayList<Patient> AllPatients = allAccounts.getAllPatients();
        for (int i = 0; i < AllPatients.size(); i++) {
            if (AllPatients.get(i).getUserID().equals(PatientID)) {
                appointment.registerObserver(AllPatients.get(i)); 
                appointment.registerObserver(this);
                ArrayList<LocalDate> PotentialDates = new ArrayList();
                LocalDate localDate = LocalDate.parse(PotentialDate1);
                PotentialDates.add(localDate);
                localDate = LocalDate.parse(PotentialDate2);
                PotentialDates.add(localDate);
                localDate = LocalDate.parse(PotentialDate3);
                PotentialDates.add(localDate);
                this.updateAppointmentDates(PotentialDates, appointment);
                accountSerialiser.writeObject(allAccounts);
                return true;
            }
        }
        return false;
    }
    //observer
    @Override
    public void updateAppointmentDates(ArrayList<LocalDate> PotentialDates, Appointment appointment){
        appointment.setPotentialDates(PotentialDates);
    }
}
