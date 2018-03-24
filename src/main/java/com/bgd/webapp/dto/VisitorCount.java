package com.bgd.webapp.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;

@Entity(name = "visitor")
public class VisitorCount implements Serializable {
    @Id
    private int id;
    private String sitename;
    @Column(name = "serialnum")
    private String serial;
    @Column(name = "vdate")
    private LocalDate date;
    @Column(name = "dayofweek")
    private String dayOfWeek;
    @Column(name = "numberofweek")
    private int numberOfWeek;
    private int visitors;

    public VisitorCount() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSitename() {
        return sitename;
    }

    public void setSitename(String siteName) {
        this.sitename = siteName;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getNumberOfWeek() {
        return numberOfWeek;
    }

    public void setNumberOfWeek(int numberOfWeek) {
        this.numberOfWeek = numberOfWeek;
    }

    public int getVisitors() {
        return visitors;
    }

    public void setVisitors(int visitors) {
        this.visitors = visitors;
    }
}
