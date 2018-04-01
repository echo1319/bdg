package com.bgd.webapp.runtime.calculators.aqi

import com.bgd.webapp.api.indices.AQI_AIR_QUALITY
import com.bgd.webapp.api.indices.POLLUTION_FACTORS
import spock.lang.Specification

class AirQualityIndexCalculatorSpec extends Specification {
    AirQualityIndexCalculator calculator

    void setup() {
        calculator = new AirQualityIndexCalculator()
        calculator.with {
            coCalculator = Mock(COCalculator)
            no2Calculator = Mock(NO2Calculator)
            o3Calculator = Mock(O3Calculator)
            pm10Calculator = Mock(PM10Calculator)
            so2Calculator = Mock(SO2Calculator)
            airQualityCalculator = Mock(AirQualityCalculator)
        }
    }

    def "Calculate AQI from a list of pollution factors"() {

        given:
        def PM10 = 10
        def O3 = 20
        def NO2 = 13
        def CO = 13
        def SO2 = 12

        when:
        def aqi = calculator.calculateAQI(PM10, O3, NO2, CO, SO2)

        then:
        1 * calculator.pm10Calculator.computeAQI(PM10) >> PM10Index
        1 * calculator.so2Calculator.computeAQI(SO2) >> SO2Index
        1 * calculator.o3Calculator.computeAQI(O3) >> O3Index
        1 * calculator.no2Calculator.computeAQI(NO2) >> NO2Index
        1 * calculator.coCalculator.computeAQI(CO) >> COIndex
        1 * calculator.airQualityCalculator.computeStatus(_) >> expectedAirQuality
        0 * _
        with(aqi) {
            airQuality == expectedAirQuality
            value == expectedAQI
            chosenFactor == expectedFactor
        }
        where:
        NO2Index | COIndex | O3Index | PM10Index | SO2Index | expectedAQI | expectedFactor        | expectedAirQuality
        33.12    | 80      | 0.00    | 12.76     | 0        | 80.0        | POLLUTION_FACTORS.CO  | AQI_AIR_QUALITY.GOOD
        50       | 10      | 0.00    | 12.76     | 0        | 50.0        | POLLUTION_FACTORS.NO2 | AQI_AIR_QUALITY.MEDIOCRE
    }


}
