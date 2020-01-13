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

    /**
     *
     * @return
     */
    public Medicine getMedicine() {
        return medicine;
    }

    /**
     *
     * @param medicine
     */
    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    /**
     *
     * @return
     */
    public int getStockRequestAmmount() {
        return StockRequestAmmount;
    }

    /**
     *
     * @param StockRequestAmmount
     */
    public void setStockRequestAmmount(int StockRequestAmmount) {
        this.StockRequestAmmount = StockRequestAmmount;
    }
}
