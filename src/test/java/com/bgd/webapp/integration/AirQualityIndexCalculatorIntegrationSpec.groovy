package com.bgd.webapp.integration

import com.bgd.webapp.api.indices.AQI_AIR_QUALITY
import com.bgd.webapp.api.indices.POLLUTION_FACTORS
import com.bgd.webapp.runtime.calculators.aqi.AirQualityCalculator
import com.bgd.webapp.runtime.calculators.aqi.AirQualityIndexCalculator
import com.bgd.webapp.runtime.calculators.aqi.COCalculator
import com.bgd.webapp.runtime.calculators.aqi.NO2Calculator
import com.bgd.webapp.runtime.calculators.aqi.O3Calculator
import com.bgd.webapp.runtime.calculators.aqi.PM10Calculator
import com.bgd.webapp.runtime.calculators.aqi.SO2Calculator
import spock.lang.Specification
import spock.lang.Unroll

class AirQualityIndexCalculatorIntegrationSpec extends Specification {
    AirQualityIndexCalculator calculator

    void setup() {
        calculator = new AirQualityIndexCalculator()
        calculator.with {
            coCalculator = Spy(COCalculator)
            no2Calculator = Spy(NO2Calculator)
            o3Calculator = Spy(O3Calculator)
            pm10Calculator = Spy(PM10Calculator)
            so2Calculator = Spy(SO2Calculator)
            airQualityCalculator = Spy(AirQualityCalculator)
        }
    }

    @Unroll
    def "Calculate AQI from a list of pollution factors"() {

        when:
        def aqi = calculator.calculateAQI(PM10, O3, NO2, CO, SO2)

        then:
        with(aqi) {
            value == expectedAQI
            chosenFactor == expectedFactor
            airQuality == expectedAirQuality

        }
        where:
        PM10 | O3 | NO2 | CO  | SO2 | expectedAQI | expectedFactor         | expectedAirQuality
        48   | 21 | 37  | 1.7 | 0   | 44          | POLLUTION_FACTORS.PM10 | AQI_AIR_QUALITY.GOOD
        52   | 0  | 37  | 3.4 | 0   | 48          | POLLUTION_FACTORS.PM10 | AQI_AIR_QUALITY.GOOD
        87   | 0  | 67  | 3.9 | 8   | 107         | POLLUTION_FACTORS.PM10 | AQI_AIR_QUALITY.MEDIOCRE
        119  | 0  | 81  | 4.3 | 13  | 83          | POLLUTION_FACTORS.PM10 | AQI_AIR_QUALITY.MEDIOCRE
        82   | 8  | 53  | 2.3 | 11  | 64          | POLLUTION_FACTORS.PM10 | AQI_AIR_QUALITY.MEDIOCRE
        61   | 8  | 64  | 5.6 | 8   | 54          | POLLUTION_FACTORS.PM10 | AQI_AIR_QUALITY.MEDIOCRE
        81   | 9  | 59  | 4.2 | 13  | 64          | POLLUTION_FACTORS.PM10 | AQI_AIR_QUALITY.MEDIOCRE
        94   | 8  | 65  | 1.6 | 30  | 70          | POLLUTION_FACTORS.PM10 | AQI_AIR_QUALITY.MEDIOCRE
        36   | 38 | 36  | 2.4 | 36  | 33          | POLLUTION_FACTORS.PM10 | AQI_AIR_QUALITY.GOOD
        60   | 65 | 66  | 3.6 | 65  | 53          | POLLUTION_FACTORS.PM10 | AQI_AIR_QUALITY.MEDIOCRE
        80   | 63 | 72  | 3.7 | 84  | 63          | POLLUTION_FACTORS.PM10 | AQI_AIR_QUALITY.MEDIOCRE


    }


}
