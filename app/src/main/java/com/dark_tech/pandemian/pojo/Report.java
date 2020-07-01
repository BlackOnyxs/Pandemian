package com.dark_tech.pandemian.pojo;

import java.util.ArrayList;

public class Report {

    private String id;
    private String name;
    private String age;
    private String cid;
    private String sex;
    private ArrayList<Symptom> symptoms;
    private String date;

    public Report() {
    }

    public Report(String id, String name, String age, String cid, String sex, ArrayList<Symptom> symptoms, String date) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.cid = cid;
        this.sex = sex;
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

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
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
}
