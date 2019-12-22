/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.Accounts;

import PatientManagementSystem.System.AccountRequest;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author james
 */
public class Secretary extends User implements java.io.Serializable{
    private List<AccountRequest> AccountRequests = new ArrayList();
}
