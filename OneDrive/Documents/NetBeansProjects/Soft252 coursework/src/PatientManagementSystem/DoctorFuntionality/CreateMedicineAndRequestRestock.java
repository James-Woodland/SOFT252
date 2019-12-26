/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.DoctorFuntionality;

import PatientManagementSystem.Accounts.AllAccounts;
import PatientManagementSystem.Accounts.Secretary;
import PatientManagementSystem.Serialiser.Serialiser;
import PatientManagementSystem.System.Medicine.AllMedicines;
import PatientManagementSystem.System.Medicine.Medicine;
import PatientManagementSystem.System.Medicine.OutOfStock;
import PatientManagementSystem.System.MedicineRequest;
import java.util.ArrayList;

/**
 *
 * @author james
 */
public class CreateMedicineAndRequestRestock {
    /**
     * Creates a medicine for with a provided name, sets the initial stock to 0 as it;s assumed the medicine hasn't yet been stocked.
     * also sets the state to out OfStock as when the Stock is set to 0 the state isn't automatically set.
     * Updates the AllMedicines file with the new medicine; 
     * @param MedicineName
     */
    public void createNewMedicine(String MedicineName){
        OutOfStock outOfStock = new OutOfStock();
        Medicine medicine = new Medicine(outOfStock);
        medicine.setMedicineName(MedicineName);       
        Serialiser medicineSerialiser = new Serialiser("AllMedicine");
        AllMedicines allMedicines = (AllMedicines) medicineSerialiser.readObject();
        allMedicines.addMedcine(medicine);
        medicineSerialiser.writeObject(allMedicines);       
    }   
    /**
     * creates a medicine stock request for a given medicine for a for a given amount with a given secretary.  
     * updates the AllAccounts file with the new additions;
     * @param MedicineName
     * @param RestockRequestAmount
     * @param SecretaryID
     */
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
}
