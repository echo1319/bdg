package com.bgd.webapp.runtime.calculators.aqi

import spock.lang.Specification
import spock.lang.Unroll

class COCalculatorSpec extends Specification {
    COCalculator calculator = new COCalculator()

    @Unroll
    def "Compute Co AQi"() {

        when:
        double aqi = calculator.computeAQI(value)

        then:
        aqi == expectedAQI

        where:
        value | expectedAQI
        0     | 0
        5.5   | 49.99995
        5.6   | 50.999700000000004
        11.76 | 99.99942
        11.77 | 100.99895899999999
        15.5  | 149.99884999999998
        15.6  | 151.00376
        19.25 | 200.00354999999996
        38.0  | 299.9994
        38.1  | 301.0440400000001
        50.5  | 500.04420000000005
    }

    def "Throw an exception when an invalid value is given"() {

        given:
        def invalidCO = 1000

        when:
        calculator.computeAQI(invalidCO)

        then:
        thrown(RuntimeException)


    }
}