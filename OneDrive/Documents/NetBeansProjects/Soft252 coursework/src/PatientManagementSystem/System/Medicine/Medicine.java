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
    
    public void Restock(int NewStock){
        State.ReStock(this, NewStock);
    }
    
    public void GiveMedicine(){
        State.GiveMedicine(this);
    }
}
