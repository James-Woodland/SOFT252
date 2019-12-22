/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.System.Medicine;
import PatientManagementSystem.System.Medicine.Medicine;
/**
 *
 * @author james
 */
public class InStock implements iMedicineState{  
    
    @Override
    public Boolean GiveMedicine(Medicine medicine){
        System.out.println("Medicine is given");
        System.out.println("Stock:" + medicine.getStock());
        medicine.setStock(medicine.getStock()-1);
        if (medicine.getStock() == 0) {            ;
            medicine.setState(new OutOfStock());
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
