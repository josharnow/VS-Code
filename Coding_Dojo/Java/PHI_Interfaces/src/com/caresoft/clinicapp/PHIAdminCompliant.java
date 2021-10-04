package com.caresoft.clinicapp;
import java.util.ArrayList;

public interface PHIAdminCompliant {
    
    // Expected to return a list of strings (incidents reported)
    abstract ArrayList<String> reportSecurityIncidents();
    
    
    // DEFAULT IMPLEMENTED METHODS
    // Used to print implementation return values. 
    public default void printSecurityIncidents() {
        System.out.println(reportSecurityIncidents());
    }
    
    // QA Test, PASS/FAIL of reports against QA expected results
    public default boolean adminQATest(ArrayList<String> expectedIncidents) {
        if (reportSecurityIncidents().equals(expectedIncidents)) {
            System.out.println("PASS");
        }
        else {
            System.out.println("FAIL");
        }
        return reportSecurityIncidents().equals(expectedIncidents);
    }
    
}
