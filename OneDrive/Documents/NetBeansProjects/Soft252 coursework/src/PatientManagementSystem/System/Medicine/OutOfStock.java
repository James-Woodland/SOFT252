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
public class OutOfStock implements iMedicineState{    
    
    @Override
    public Boolean GiveMedicine(Medicine medicine, int Quantity){
        System.out.println("Medicine is out of stock");        
        return false;
    }
    @Override
    public void ReStock(Medicine medicine, int newStock){       
        System.out.println("Stock:" + medicine.getStock());
        medicine.setStock(medicine.getStock()+ newStock);       
        System.out.println("Stock:" + medicine.getStock());        
        medicine.setState(new InStock());              
    };
}
