/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.System.Medicine;

import java.util.ArrayList;

/**
 *
 * @author james
 */
public class AllMedicines implements java.io.Serializable{
    private ArrayList<Medicine> AllMedicines;
    private static final long serialVersionUID = 10L; 

    public ArrayList<Medicine> getAllMedicines() {
        return AllMedicines;
    }
       
    private AllMedicines(){
        AllMedicines = new ArrayList();       
    }
    
    public void addMedcine(Medicine medicine){
        this.AllMedicines.add(medicine);
    }
    
    public void removeMedicine(Medicine medicine){
        this.AllMedicines.remove(medicine);
    }
       
}
