/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.CreationStrategies;

/**
 *
 * @author james
 */
public interface CreationStrategy {
    public abstract void CreateWorkerAccount(String Password, String Name, String Address);
}
