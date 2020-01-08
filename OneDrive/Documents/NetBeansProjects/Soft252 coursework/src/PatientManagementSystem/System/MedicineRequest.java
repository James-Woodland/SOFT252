/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.System;

import PatientManagementSystem.System.Medicine.Medicine;
/**
 *
 * @author james
 */
public class MedicineRequest implements java.io.Serializable{
    private Medicine medicine;
    private int StockRequestAmmount;

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public int getStockRequestAmmount() {
        return StockRequestAmmount;
    }

    public void setStockRequestAmmount(int StockRequestAmmount) {
        this.StockRequestAmmount = StockRequestAmmount;
    }
}
