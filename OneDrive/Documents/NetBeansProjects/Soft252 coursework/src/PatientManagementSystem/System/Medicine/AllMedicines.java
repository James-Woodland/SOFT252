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
public class AllMedicines {
    private ArrayList<Medicine> AllMedicines;
    private static AllMedicines single_instance = null;

    public ArrayList<Medicine> getAllMedicines() {
        return AllMedicines;
    }

    public void addPatient(Medicine medicine){
        AllMedicines.add(medicine);
    }
    
    public void removeSecretary(Medicine medicine){
        AllMedicines.remove(medicine);
    }
    
    private AllMedicines(){
        AllMedicines = new ArrayList();
        
    }
    
    public static AllMedicines getInstance() 
    { 
        if (single_instance == null) 
            single_instance = new AllMedicines(); 
  
        return single_instance; 
    } 
}
