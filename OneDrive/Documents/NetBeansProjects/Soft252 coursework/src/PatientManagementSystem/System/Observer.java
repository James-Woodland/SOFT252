/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.System;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author james
 */
public interface Observer {
    public void updateAppointmentDates(ArrayList<LocalDate> PotentialDates, Appointment appointment);
}
