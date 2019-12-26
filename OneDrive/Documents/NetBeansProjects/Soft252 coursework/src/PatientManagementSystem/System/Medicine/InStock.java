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
public class InStock implements iMedicineState{  
    
    @Override
    public Boolean GiveMedicine(Medicine medicine, int Quantity){
        System.out.println("Medicine is given");
        System.out.println("Stock:" + medicine.getStock());
        medicine.setStock(medicine.getStock()-Quantity);
        if (medicine.getStock() == 0) {              
            medicine.setState(new OutOfStock());
            return false;
        }
        System.out.println("Stock:" + medicine.getStock());
        return true;
    }
    @Override
    public void ReStock(Medicine medicine, int newStock){
        System.out.println("Stock:" + medicine.getStock());
        medicine.setStock(medicine.getStock()+newStock);       
        System.out.println("Stock:" + medicine.getStock());
    }
}
