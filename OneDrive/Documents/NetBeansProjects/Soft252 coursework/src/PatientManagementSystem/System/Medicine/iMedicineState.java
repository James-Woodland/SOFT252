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
interface iMedicineState extends java.io.Serializable{   
    public Boolean GiveMedicine(Medicine medicine, int Quantity);
    public void ReStock(Medicine medicine, int newStock);
}
