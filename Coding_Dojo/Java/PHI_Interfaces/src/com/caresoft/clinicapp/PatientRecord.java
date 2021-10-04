package com.caresoft.clinicapp;
import java.util.ArrayList;

public class PatientRecord {
    private ArrayList<String> charts;
    public PatientRecord(ArrayList<String> charts) {
        this.charts = charts;
    }
    public ArrayList<String> getCharts() {
        return charts;
    }
    public void setCharts(ArrayList<String> charts) {
        this.charts = charts;
    }
}