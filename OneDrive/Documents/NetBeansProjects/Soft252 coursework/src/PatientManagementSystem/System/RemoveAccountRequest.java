/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.System;

import PatientManagementSystem.Accounts.Patient;

/**
 *
 * @author james
 */
public class RemoveAccountRequest {
    Patient AccountToBeRemoved;

    public Patient getAccountToBeRemoved() {
        return AccountToBeRemoved;
    }

    public void setAccountToBeRemoved(Patient AccountToBeRemoved) {
        this.AccountToBeRemoved = AccountToBeRemoved;
    }   
}
