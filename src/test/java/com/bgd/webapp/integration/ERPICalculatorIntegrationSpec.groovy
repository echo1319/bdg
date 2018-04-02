package com.bgd.webapp.integration

import com.bgd.webapp.api.dto.GardenAetherMetrics
import com.bgd.webapp.api.indices.ERPI_AIR_QUALITY
import com.bgd.webapp.api.indices.POLLUTION_FACTORS
import com.bgd.webapp.runtime.calculators.erpi.ERPICalculator
import com.bgd.webapp.runtime.calculators.erpi.EuropeanPollutionIndexCalculator
import spock.lang.Specification
import spock.lang.Unroll

import java.time.LocalDateTime

class ERPICalculatorIntegrationSpec extends Specification {
    EuropeanPollutionIndexCalculator calculator

    void setup() {
        calculator = new EuropeanPollutionIndexCalculator()
        calculator.with {
            erpiCalculator = Spy(ERPICalculator)
        }
    }

    @Unroll
    def "Calculate ERPI from a list of pollution factors"() {

        given:
        def metrics = [new GardenAetherMetrics(O3: O3, SO2: SO2, NO2: NO2, PM10: PM10, date: LocalDateTime.now())]
        when:
        def aqi = calculator.calculate(metrics)

        then:
        with(aqi) {
            value == expectedERPI
            chosenFactor == expectedFactor
            //airQuality == expectedAirQuality

        }
        where:
        PM10 | O3 | NO2 | CO  | SO2 | expectedERPI | expectedFactor         | expectedAirQuality
        48   | 21 | 37  | 1.7 | 0   | 48           | POLLUTION_FACTORS.PM10 | ERPI_AIR_QUALITY.ADEQUATE
        52   | 0  | 37  | 3.4 | 0   | 52           | POLLUTION_FACTORS.PM10 | ERPI_AIR_QUALITY.ADEQUATE
        87   | 0  | 67  | 3.9 | 8   | 87           | POLLUTION_FACTORS.PM10 | ERPI_AIR_QUALITY.ADEQUATE
        119  | 0  | 81  | 4.3 | 13  | 119          | POLLUTION_FACTORS.PM10 | ERPI_AIR_QUALITY.ADEQUATE
        82   | 8  | 53  | 2.3 | 11  | 82           | POLLUTION_FACTORS.PM10 | ERPI_AIR_QUALITY.ADEQUATE
        61   | 8  | 64  | 5.6 | 8   | 61           | POLLUTION_FACTORS.PM10 | ERPI_AIR_QUALITY.ADEQUATE
        81   | 9  | 59  | 4.2 | 13  | 81           | POLLUTION_FACTORS.PM10 | ERPI_AIR_QUALITY.ADEQUATE
        94   | 8  | 65  | 1.6 | 30  | 94           | POLLUTION_FACTORS.PM10 | ERPI_AIR_QUALITY.ADEQUATE
        36   | 38 | 36  | 2.4 | 36  | 36           | POLLUTION_FACTORS.PM10 | ERPI_AIR_QUALITY.ADEQUATE
        60   | 65 | 66  | 3.6 | 65  | 60           | POLLUTION_FACTORS.PM10 | ERPI_AIR_QUALITY.ADEQUATE
        80   | 63 | 72  | 3.7 | 84  | 80           | POLLUTION_FACTORS.PM10 | ERPI_AIR_QUALITY.ADEQUATE


    }


}
