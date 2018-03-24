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
    private String site;
    @Column(name = "serial_num")
    private String serial;
    @Column(name = "vdate")
    private LocalDate date;
    @Column(name = "day_of_week")
    private String dayOfWeek;
    @Column(name = "number_of_week")
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

    public String getSite() {
        return site;
    }

    public void setSite(String siteName) {
        this.site = siteName;
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
