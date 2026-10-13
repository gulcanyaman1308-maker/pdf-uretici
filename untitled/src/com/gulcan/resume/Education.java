package com.gulcan.resume;

public class Education {
    private String university;
    private String department;
    private String year;
    private String certificate;

    public Education(String university, String department, String year, String certificate) {
        this.university = university;
        this.department = department;
        this.year = year;
        this.certificate = certificate;
    }

    public String getUniversity() { return university; }
    public String getDepartment() { return department; }
    public String getYear() { return year; }
    public String getCertificate() { return certificate; }
}