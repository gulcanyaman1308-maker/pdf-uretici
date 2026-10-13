package com.gulcan.resume;

public class Experience {
    private String company;
    private String position;
    private String duration;
    private String description;

    // Constructor (Yapıcı Metot)
    public Experience(String company, String position, String duration, String description) {
        this.company = company;
        this.position = position;
        this.duration = duration;
        this.description = description;
    }

    // Encapsulation (Getter ve Setter Metotları)
    public String getCompany() { return company; }
    public String getPosition() { return position; }
    public String getDuration() { return duration; }
    public String getDescription() { return description; }
}
