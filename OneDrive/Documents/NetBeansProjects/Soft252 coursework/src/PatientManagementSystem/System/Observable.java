/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.System;

/**
 *
 * @author james
 */
public interface Observable {
    public void registerObserver(Observer observer);   
    public void notifyObserver();
}
