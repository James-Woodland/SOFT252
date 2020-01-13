/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SecretaryFunctionality;

import PatientManagementSystem.Serialiser.Serialiser;
import PatientManagementSystem.System.Medicine.AllMedicines;
import PatientManagementSystem.System.Medicine.Medicine;

/**
 *
 * @author james
 */
public class GiveMedicine {

    /**
     * Gives medicine for a given amount
     * @param medicineIndex
     * @param Amount
     * @param FileName
     * @return
     */
    public static boolean GiveMedicine(int medicineIndex, int Amount, String FileName){
        Serialiser medicineSerialiser = new Serialiser(FileName);
        AllMedicines allMedicines = (AllMedicines) medicineSerialiser.readObject();  
        Medicine medicine = allMedicines.getAllMedicines().get(medicineIndex);
        boolean MedicineGiven = medicine.GiveMedicine(Amount);
        medicineSerialiser.writeObject(allMedicines);
        return MedicineGiven;
    }
}
