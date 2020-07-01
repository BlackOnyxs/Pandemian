package com.dark_tech.pandemian;

import com.dark_tech.pandemian.pojo.Report;

public class ReportSingleton {

    private static final ReportSingleton instance = new ReportSingleton();

    private Report report;

    public static ReportSingleton getInstance(){
        return instance;
    }

    public Report getReport(){
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }
}
