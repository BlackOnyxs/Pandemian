package com.dark_tech.pandemian.pojo;

import java.util.ArrayList;

public class Report {

    private String id;
    private String name;
    private String age;
    private String cip;
    private String sex;
    private String help;
    private String helpType;
    private String workStatus;
    private String workName;
    private boolean vaccineStatus;
    private boolean vaccineInterest;
    private LatLng Location;
    private ArrayList<Symptom> symptoms;
    private String date;

    public Report() {
    }

    public Report(String id, String name, String age, String cip, String sex, String help, String helpType, String workStatus, String workName, boolean vaccineStatus, boolean vaccineInterest, LatLng location, ArrayList<Symptom> symptoms, String date) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.cip = cip;
        this.sex = sex;
        this.help = help;
        this.helpType = helpType;
        this.workStatus = workStatus;
        this.workName = workName;
        this.vaccineStatus = vaccineStatus;
        this.vaccineInterest = vaccineInterest;
        Location = location;
        this.symptoms = symptoms;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCip() {
        return cip;
    }

    public void setCip(String cip) {
        this.cip = cip;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public ArrayList<Symptom> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(ArrayList<Symptom> symptoms) {
        this.symptoms = symptoms;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public String getHelpType() {
        return helpType;
    }

    public void setHelpType(String helpType) {
        this.helpType = helpType;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public boolean isVaccineStatus() {
        return vaccineStatus;
    }

    public void setVaccineStatus(boolean vaccineStatus) {
        this.vaccineStatus = vaccineStatus;
    }

    public boolean isVaccineInterest() {
        return vaccineInterest;
    }

    public void setVaccineInterest(boolean vaccineInterest) {
        this.vaccineInterest = vaccineInterest;
    }

    public LatLng getLocation() {
        return Location;
    }

    public void setLocation(LatLng location) {
        Location = location;
    }
}
