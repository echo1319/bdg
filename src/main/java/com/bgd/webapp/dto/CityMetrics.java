package com.bgd.webapp.dto;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sintagma")
public abstract class CityMetrics extends Metrics {
    public CityMetrics() {
    }
}
