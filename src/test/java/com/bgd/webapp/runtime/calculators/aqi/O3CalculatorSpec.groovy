package com.bgd.webapp.runtime.calculators.aqi

import spock.lang.Specification
import spock.lang.Unroll

class O3CalculatorSpec extends Specification {
    O3Calculator calculator = new O3Calculator()

    @Unroll
    def "Compute O3 AQi"() {

        when:
        double aqi = calculator.computeAQI(value)

        then:
        aqi == expectedAQI

        where:
        value | expectedAQI
        0     | 0
        137   | 49.9913
        138   | 50.99080000000001
        180   | 99.98800000000003
        181   | 101.15460000000002
        224   | 151.3184
        267   | 200.58190000000002
        800   | 299.56
        900   | 338.22
    }


}