package com.gulcan.resume;

public class Person {
    private String fullName;
    private String title;
    private String email;
    private String phone;
    private String address;
    private String[] summaryLines;
    private String photoPath;

    public Person(String fullName, String title, String email, String phone, String address, String[] summaryLines, String photoPath) {
        this.fullName = fullName;
        this.title = title;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.summaryLines = summaryLines;
        this.photoPath = photoPath;
    }

    public String getFullName() { return fullName; }
    public String getTitle() { return title; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }
    public String[] getSummaryLines() { return summaryLines; }
    public String getPhotoPath() { return photoPath; }
}