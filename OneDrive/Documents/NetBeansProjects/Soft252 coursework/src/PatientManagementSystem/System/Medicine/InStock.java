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
public class InStock implements java.io.Serializable, iMedicineState{  
    
    /**
     * gives medicine to a patient and decreases the stock by the given amount
     * changes the state to out of stock if the medicine stick drops to 0
     * @param medicine
     * @param Quantity
     * @return
     */
    @Override
    public Boolean GiveMedicine(Medicine medicine, int Quantity){        
        medicine.setStock(medicine.getStock()-Quantity);
        if (medicine.getStock() == 0) {              
            medicine.setState(new OutOfStock());
            return false;
        }        
        return true;
    }

    /**
     * Increases the stock by of the given medicine by the given amount
     * @param medicine
     * @param newStock
     */
    @Override
    public void ReStock(Medicine medicine, int newStock){       
        medicine.setStock(medicine.getStock()+newStock);               
    }
}
