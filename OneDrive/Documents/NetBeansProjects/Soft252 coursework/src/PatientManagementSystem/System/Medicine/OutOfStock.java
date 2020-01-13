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
public class OutOfStock implements java.io.Serializable, iMedicineState{    
    
    /**
     *
     * @param medicine
     * @param Quantity
     * @return
     */
    @Override
    public Boolean GiveMedicine(Medicine medicine, int Quantity){                
        return false;
    }

    /**
     *
     * @param medicine
     * @param newStock
     */
    @Override
    public void ReStock(Medicine medicine, int newStock){               
        medicine.setStock(medicine.getStock()+ newStock);                    
        medicine.setState(new InStock());              
    };
}
