package eu.vmpay.algotests

import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class WeatherForecastTest {

    private lateinit var weatherForecast: WeatherForecast

    @Before
    fun setUp() {
        weatherForecast = WeatherForecastImp(
            "Warszawa",
            Pair(50.0, 100.0),
            12.3,
            0.88,
            1011.3,
            WeatherType.SUNNY
        )
    }


    @Test
    fun getLocationNameTest() {
        assertEquals("Warszawa", weatherForecast.getLocationName())
    }

    @Test
    fun getLocationTest() {
        assertEquals(Pair(50.0, 100.0), weatherForecast.getLocation())
    }

    @Test
    fun getTempTest() {
        assertEquals(12.3, weatherForecast.getTemp())
    }

    @Test
    fun getHumidityTest() {
        assertEquals(0.88, weatherForecast.getHumidity())
    }

    @Test
    fun getPressureTest() {
        assertEquals(1011.3, weatherForecast.getPressure())
    }

    @Test
    fun getWeatherTypeTest() {
        assertEquals(WeatherType.SUNNY, weatherForecast.getWeatherType())
    }
}