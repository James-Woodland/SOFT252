/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.System.Medicine;

/**
 *
 * @author james
 */
interface iMedicineState {   
    public Boolean GiveMedicine(Medicine medicine);
    public void ReStock(Medicine medicine, int newStock);
    
}
