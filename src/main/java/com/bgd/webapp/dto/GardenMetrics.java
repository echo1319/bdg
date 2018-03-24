package com.bgd.webapp.dto;

import com.bgd.webapp.dto.indexes.Humidex;
import com.bgd.webapp.dto.indexes.ThermoHumidityIndex;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "garden")
public abstract class GardenMetrics extends Metrics {
    public GardenMetrics() {
    }



}
