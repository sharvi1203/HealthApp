package com.example.healthapp;

public class MedHistory {
    public String MedCond;
    public String MedCondStDate;
    public String MedCondEndDate;
    public String device;
    public String RadioReport;
    public String BodySite;
    public String Vaccination;
    public String Med;
    public String Duration;
    public String MedReport;

    public MedHistory(String medCond, String medCondStDate, String medCondEndDate, String device, String radioReport, String bodySite, String vaccination, String med, String duration, String medReport) {
        MedCond = medCond;
        MedCondStDate = medCondStDate;
        MedCondEndDate = medCondEndDate;
        this.device = device;
        RadioReport = radioReport;
        BodySite = bodySite;
        Vaccination = vaccination;
        Med = med;
        Duration = duration;
        MedReport = medReport;
    }

    public MedHistory() {

    }

    @Override
    public String toString() {
        return "MedHistory{" +
                "MedCond='" + MedCond + '\'' +
                ", MedCondStDate='" + MedCondStDate + '\'' +
                ", MedCondEndDate='" + MedCondEndDate + '\'' +
                ", device='" + device + '\'' +
                ", RadioReport='" + RadioReport + '\'' +
                ", BodySite='" + BodySite + '\'' +
                ", Vaccination='" + Vaccination + '\'' +
                ", Med='" + Med + '\'' +
                ", Duration='" + Duration + '\'' +
                ", MedReport='" + MedReport + '\'' +
                '}';
    }
}
