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
public class Medicine implements java.io.Serializable{
    private String MedicineName = "";
    private int Stock = 0;
    private iMedicineState State;
    
    public Medicine(iMedicineState State){
        this.State = State;
    }

    public String getMedicineName() {
        return MedicineName;
    }

    public void setMedicineName(String MedicineName) {
        this.MedicineName = MedicineName;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;       
        if (Stock > 0) {
            InStock inStock = new InStock();
            this.setState(inStock);
        }            
    }

    public iMedicineState getState() {
        return State;
    }

    public void setState(iMedicineState State) {
        this.State = State;
    }
    
    /**
     * Sets the Stock for this medicine if the NewStock value is greater than 0.
     * state = OutOfStock - the Stock for the medicine is set to the NewStock Value and the state of the medicine is change to InStock
     * state = InSTock - the stock is updated to Stock+NewStock
     * @param NewStock - must be greater than 0 or the stock wont be updated.
     */
    public void Restock(int NewStock){
        if (NewStock > 0) {
            State.ReStock(this, NewStock);
            return;
        } 
        System.out.println("NewStock amount is not above 0");
    }
    
    /**
     * Called from a secretary when a patient comes to request a medicine.
     * Checks that the Stock is greater than the amount requested before giving the medicine.
     * @param Quantity - the amount that the patient is to be given.
     * @return if the medicine can't be given the return value is false, if the medicine can be given the return value is true.
     */
    public boolean GiveMedicine(int Quantity){
        if (this.Stock >= Quantity) {
            return State.GiveMedicine(this, Quantity);           
        }  
        return false;
    }
}
