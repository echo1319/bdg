package com.bgd.webapp.runtime.calculators.aqi

import spock.lang.Specification
import spock.lang.Unroll

class NO2CalculatorSpec extends Specification {
    NO2Calculator calculator = new NO2Calculator()

    @Unroll
    def "Compute NO2 AQi"() {

        when:
        double aqi = calculator.computeAQI(value)

        then:
        aqi == expectedAQI

        where:
        value | expectedAQI
        0     | 0
        1330  | 201.022
        2542  | 300.0424
        2543  | 300.9606
        4182  | 499.9352
    }

    def "Throw an exception when an invalid value is given"() {

        given:
        def invalidNO2 = 418200

        when:
        calculator.computeAQI(invalidNO2)

        then:
        thrown(RuntimeException)


    }
}