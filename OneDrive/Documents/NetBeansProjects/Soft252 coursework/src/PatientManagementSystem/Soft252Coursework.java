/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem;

import PatientManagementSystem.System.Medicine.Medicine;
import PatientManagementSystem.System.Medicine.InStock;
import PatientManagementSystem.System.Medicine.OutOfStock;


/**
 *
 * @author james
 */
public class Soft252Coursework {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        OutOfStock Start = new OutOfStock();
        Medicine medicine = new Medicine(Start);
        medicine.setStock(1);
        medicine.GiveMedicine();
        medicine.GiveMedicine();
        medicine.Restock(0);
        medicine.Restock(50);
        medicine.GiveMedicine();
    }
}
