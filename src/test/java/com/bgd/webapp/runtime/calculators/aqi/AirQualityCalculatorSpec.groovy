package com.bgd.webapp.runtime.calculators.aqi

import com.bgd.webapp.api.indices.AQI_AIR_QUALITY
import spock.lang.Specification

class AirQualityCalculatorSpec extends Specification {
    private AirQualityCalculator airQualityCalculator

    void setup() {
        airQualityCalculator = new AirQualityCalculator()
    }

    def "Compute Status"() {

        when:
        def quality = airQualityCalculator.computeStatus(aqi)

        then:
        quality == expectedQuality

        where:
        aqi | expectedQuality
        0   | AQI_AIR_QUALITY.GOOD
        45  | AQI_AIR_QUALITY.GOOD
        50  | AQI_AIR_QUALITY.GOOD
        51  | AQI_AIR_QUALITY.MEDIOCRE
        100 | AQI_AIR_QUALITY.MEDIOCRE
        101 | AQI_AIR_QUALITY.SLIGHTLY_HARMFUL
        150 | AQI_AIR_QUALITY.SLIGHTLY_HARMFUL
        151 | AQI_AIR_QUALITY.HARMFUL
        200 | AQI_AIR_QUALITY.HARMFUL
        201 | AQI_AIR_QUALITY.VERY_HARMFUL
        300 | AQI_AIR_QUALITY.VERY_HARMFUL
        301 | AQI_AIR_QUALITY.DANGEROUSLY_HARMFUL
        500 | AQI_AIR_QUALITY.DANGEROUSLY_HARMFUL
    }


    def "Throw an exception when an invalid value is given"() {

        given:
        def invalidAQI = 1000

        when:
        airQualityCalculator.computeStatus(invalidAQI)

        then:
        thrown(RuntimeException)

    }
}
