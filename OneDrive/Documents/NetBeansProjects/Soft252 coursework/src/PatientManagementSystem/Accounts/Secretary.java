/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.Accounts;

import PatientManagementSystem.System.AccountRequest;
import PatientManagementSystem.System.MedicineRequest;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author james
 */
public class Secretary extends User implements java.io.Serializable{
    private List<AccountRequest> AccountRequests = new ArrayList();
    private List<MedicineRequest> MedicineRequests = new ArrayList();
    private static final long serialVersionUID = 5L;

    public List<AccountRequest> getAccountRequests() {
        return AccountRequests;
    }

    public List<MedicineRequest> getMedicineRequests() {
        return MedicineRequests;
    }
    
    public void addMecineRequest(MedicineRequest medicineRequest){
        this.MedicineRequests.add(medicineRequest);
    }
    
    public void addAccountRequest(AccountRequest accountRequest){
        this.AccountRequests.add(accountRequest);
    }
    
    public void removeMecineRequest(MedicineRequest medicineRequest){
        this.MedicineRequests.remove(medicineRequest);
    }
    
    public void removeAccountRequest(AccountRequest accountRequest){
        this.AccountRequests.remove(accountRequest);
    }
    
}
