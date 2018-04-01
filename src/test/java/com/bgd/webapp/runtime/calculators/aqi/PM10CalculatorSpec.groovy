package com.bgd.webapp.runtime.calculators.aqi

import spock.lang.Specification
import spock.lang.Unroll

class PM10CalculatorSpec extends Specification {
    PM10Calculator calculator = new PM10Calculator()

    @Unroll
    def "Compute O3 Aqi"() {
        when:
        double aqi = calculator.computeAQI(value)

        then:
        aqi == expectedAQI

        where:
        value | expectedAQI
        0     | 0
        54    | 49.998599999999996
        55    | 50.9975
        154   | 99.99260000000001
        155   | 100.9925
        254   | 149.9876
        255   | 150.9875
        354   | 199.98260000000002
        355   | 201.03949999999998
        424   | 300.0476
        425   | 300.98249999999996
        604   | 499.9767999999999
    }

}
