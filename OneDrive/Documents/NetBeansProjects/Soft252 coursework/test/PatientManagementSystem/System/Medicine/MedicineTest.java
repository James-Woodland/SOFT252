/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.System.Medicine;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author james
 */
public class MedicineTest {
    private OutOfStock outOfStock;
    private InStock inStock;
    private Medicine Medicine;
   
    
    public MedicineTest() {
    }
    
    @Before
    public void setUp() {   
        outOfStock = new OutOfStock();
        inStock = new InStock();
        Medicine = new Medicine();       
    }
    
    @After
    public void tearDown() {
    }
      

    /**
     * Test of Restock method, of class Medicine.
     */
    @Test
    public void testRestock() {
        System.out.println("Current Stock: "+Medicine.getStock());
        Medicine.Restock(4);
        System.out.println("Current Stock: "+Medicine.getStock());
        Medicine.Restock(6);
        System.out.println("Current Stock: "+Medicine.getStock());
        Medicine.setStock(0);
    }

    /**
     * Test of GiveMedicine method, of class Medicine.
     */
    @Test
    public void testGiveMedicine() {
        System.out.println("Current Stock: "+Medicine.getStock());
        boolean MedicineGiven = Medicine.GiveMedicine(4);
        if (MedicineGiven == true) {
            System.out.println("medicine Given");
        }
        System.out.println("Current Stock: "+Medicine.getStock());
        Medicine.Restock(3);
        System.out.println("Current Stock: "+Medicine.getStock());
        MedicineGiven = Medicine.GiveMedicine(4);
        if (MedicineGiven == true) {
            System.out.println("medicine Given");
        }
        System.out.println("Current Stock: "+Medicine.getStock());
        Medicine.Restock(3);
        System.out.println("Current Stock: "+Medicine.getStock());
        MedicineGiven = Medicine.GiveMedicine(4);
        if (MedicineGiven == true) {
            System.out.println("medicine Given");
        }
        System.out.println("Current Stock: "+Medicine.getStock());
    }
    
}
