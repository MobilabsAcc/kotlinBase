package eu.vmpay.algotests

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test

class WeatherServiceTest {

    private lateinit var weatherService: WeatherService

    @Before
    fun setUp() {
        weatherService = WeatherServiceImpl()
    }

    @Test
    fun getCurrentWeatherTest() {
        assertEquals(
            WeatherForecastImpl("Warszawa", Pair(0.0, 0.0), 20.0, 40.0, 1013.0, WeatherType.SUNNY),
            weatherService.getCurrentWeather(Pair(0.0, 0.0))
        )
    }

    @Test
    fun getCurrentWeatherFailTest() {
        assertNull(
            weatherService.getCurrentWeather(Pair(2.0, 2.0))
        )
    }

    @Test
    fun getTomorrowForecastTest() {
        assertEquals(
            listOf(
                WeatherForecastImpl(
                    "Warszawa",
                    Pair(0.0, 0.0),
                    21.0,
                    40.0,
                    1013.0,
                    WeatherType.SUNNY
                )
            ),
            weatherService.getTomorrowForecast("Warszawa")
        )
        assertEquals(
            listOf(
                WeatherForecastImpl(
                    "Nowa wieś wielka",
                    Pair(1.5, 0.5),
                    15.0,
                    44.0,
                    1007.0,
                    WeatherType.CLOUDY
                ),
                WeatherForecastImpl(
                    "Nowa wieś wielka",
                    Pair(1.5, -0.5),
                    15.0,
                    44.0,
                    1007.0,
                    WeatherType.CLOUDY
                )
            ),
            weatherService.getTomorrowForecast("Nowa wieś wielka")
        )
    }

    @Test
    fun getTomorrowForecastFailTest() {
        assertEquals(listOf<WeatherForecast>(), weatherService.getTomorrowForecast("Kraków"))
    }

    @Test
    fun getWeeklyForecastTest() {
        assertEquals(
            listOf(
                WeatherForecastImpl(
                    "Poznań",
                    Pair(-1.0, 0.0),
                    17.0,
                    40.0,
                    1013.0,
                    WeatherType.CLOUDY
                ),
                WeatherForecastImpl(
                    "Poznań",
                    Pair(-1.0, 0.0),
                    15.0,
                    44.0,
                    1007.0,
                    WeatherType.CLOUDY
                ),
                WeatherForecastImpl(
                    "Poznań",
                    Pair(-1.0, 0.0),
                    17.0,
                    39.0,
                    1000.0,
                    WeatherType.RAINY
                ),
                WeatherForecastImpl(
                    "Poznań",
                    Pair(-1.0, 0.0),
                    16.0,
                    50.0,
                    998.0,
                    WeatherType.RAINY
                ),
                WeatherForecastImpl(
                    "Poznań",
                    Pair(-1.0, 0.0),
                    16.0,
                    51.0,
                    996.0,
                    WeatherType.RAINY
                ),
                WeatherForecastImpl(
                    "Poznań",
                    Pair(-1.0, 0.0),
                    18.0,
                    43.0,
                    1007.0,
                    WeatherType.CLOUDY
                ),
                WeatherForecastImpl(
                    "Poznań",
                    Pair(-1.0, 0.0),
                    22.0,
                    40.0,
                    1013.0,
                    WeatherType.SUNNY
                )
            ),
            weatherService.getWeeklyForecast(Pair(-1.0, 0.0)))
    }

    @Test
    fun getWeeklyForecastFailTest() {
        assertEquals(listOf<WeatherForecast>(), weatherService.getWeeklyForecast(Pair(2.0, 2.0)))
    }

    @Test
    fun getLocationsByCurrentWeatherTypeTest() {
        assertEquals(
            listOf(
                WeatherForecastImpl("Warszawa", Pair(0.0, 0.0), 20.0, 40.0, 1013.0, WeatherType.SUNNY),
                WeatherForecastImpl("Gdańsk", Pair(1.0, 1.0), 20.0, 40.0, 1013.0, WeatherType.SUNNY)
            ),
            weatherService.getLocationsByCurrentWeatherType(WeatherType.SUNNY)
        )
    }

    @Test
    fun getLocationsByCurrentWeatherTypeFailTest() {
        assertEquals(
            listOf<WeatherForecast>(),
            weatherService.getLocationsByCurrentWeatherType(WeatherType.SNOWY)
        )
    }
}