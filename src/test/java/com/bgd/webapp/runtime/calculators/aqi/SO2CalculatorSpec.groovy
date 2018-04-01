package com.bgd.webapp.runtime.calculators.aqi

import spock.lang.Specification
import spock.lang.Unroll

class SO2CalculatorSpec extends Specification {
    SO2Calculator calculator = new SO2Calculator()

    @Unroll
    def "Compute O3 Aqi"() {
        when:
        double aqi = calculator.computeAQI(value)

        then:
        aqi == expectedAQI

        where:
        value | expectedAQI
        0     | 0
        97    | 49.9938
        98    | 50.988
        412   | 99.97200000000001
        413   | 100.9754
        641   | 150.9509
        869   | 199.94809999999998
        870   | 200.985
        1727  | 299.9685
        1728  | 300.9712
        2300  | 499.96999999999997
    }

}
