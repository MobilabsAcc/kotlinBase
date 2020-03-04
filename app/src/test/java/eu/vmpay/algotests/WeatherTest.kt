package eu.vmpay.algotests

import org.junit.Assert.assertEquals
import org.junit.Test

class WeatherTest {

    private val weatherForecast: WeatherForecast? = WeatherForecastImp(
        "Warszawa",
        Pair(0.0, 0.0),
        20.0,
        40.0,
        1013.0,
        WeatherType.SUNNY
    )

    @Test
    fun getLocationsNameTest() {
        assertEquals("Warszawa", weatherForecast?.getLocationName())
    }

    @Test
    fun getLocationTest() {
        assertEquals(Pair(0.0, 0.0), weatherForecast?.getLocation())
    }

    @Test
    fun getTempTest() {
        assertEquals(20.0, weatherForecast?.getTemp())
    }

    @Test
    fun getHumidityTest() {
        assertEquals(40.0, weatherForecast?.getHumidity())
    }

    @Test
    fun getPressureTest() {
        assertEquals(1013.0, weatherForecast?.getPressure())
    }

    @Test
    fun getWeatherType() {
        assertEquals(WeatherType.SUNNY, weatherForecast?.getWeatherType())
    }
}