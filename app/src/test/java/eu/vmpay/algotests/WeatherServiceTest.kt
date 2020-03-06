package eu.vmpay.algotests

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNull
import org.junit.Before
import org.junit.Test

class WeatherServiceTest {

    private lateinit var weatherService: WeatherServiceImp

    @Before
    fun setUp() {
        weatherService = WeatherServiceImp()
    }

    @Test
    fun getCurrentWeatherHappyTest() {
        assertEquals(
            WeatherForecastImp(
                "Warszawa",
                Pair(50.0, 100.0),
                12.3,
                0.88,
                1011.3,
                WeatherType.SUNNY
            ), weatherService.getCurrentWeather(Pair(50.0, 100.0))
        )

        assertEquals(
            WeatherForecastImp(
                "Warszawa",
                Pair(200.0, 200.0),
                -10.0,
                0.23,
                1000.0,
                WeatherType.CLOUDY
            ), weatherService.getCurrentWeather(Pair(200.0, 200.0))
        )

    }

    @Test
    fun getCurrentWeatherFailTest() {
        assertNull(weatherService.getCurrentWeather(Pair(33.3, 33.3)))
    }

    @Test
    fun getTomorrowForecastHappyTest() {
        assertEquals(
            listOf(
                WeatherForecastImp(
                    "Warszawa",
                    Pair(50.0, 100.0),
                    11.3,
                    0.42,
                    1009.0,
                    WeatherType.CLOUDY
                ),
                WeatherForecastImp(
                    "Warszawa",
                    Pair(200.0, 200.0),
                    -3.0,
                    0.43,
                    1020.0,
                    WeatherType.CLOUDY
                )
            ), weatherService.getTomorrowForecast("Warszawa")
        )
        assertEquals(
            listOf(
                WeatherForecastImp("Gdańsk", Pair(0.0, 0.0), 2.0, 0.96, 998.0, WeatherType.RAINY)
            ),
            weatherService.getTomorrowForecast("Gdańsk")
        )
    }

    @Test
    fun getTomorrowForecastFailTest() {
        assertEquals(
            listOf<WeatherForecast>(),
            weatherService.getTomorrowForecast("Łódź")
        )
    }

    @Test
    fun getWeeklyForecastHappyTest() {
        assertEquals(
            listOf(
                WeatherForecastImp(
                    "Warszawa",
                    Pair(50.0, 100.0),
                    12.3,
                    0.88,
                    1011.3,
                    WeatherType.SUNNY
                ),
                WeatherForecastImp(
                    "Warszawa",
                    Pair(50.0, 100.0),
                    11.3,
                    0.42,
                    1009.0,
                    WeatherType.CLOUDY
                ),
                WeatherForecastImp(
                    "Warszawa",
                    Pair(50.0, 100.0),
                    10.3,
                    1.0,
                    1000.9,
                    WeatherType.RAINY
                ),
                WeatherForecastImp(
                    "Warszawa",
                    Pair(50.0, 100.0),
                    11.1,
                    0.54,
                    1019.0,
                    WeatherType.CLOUDY
                ),
                WeatherForecastImp(
                    "Warszawa",
                    Pair(50.0, 100.0),
                    13.3,
                    0.12,
                    1003.0,
                    WeatherType.CLOUDY
                ),
                WeatherForecastImp(
                    "Warszawa",
                    Pair(50.0, 100.0),
                    1.2,
                    0.44,
                    1002.0,
                    WeatherType.SNOWY
                ),
                WeatherForecastImp(
                    "Warszawa",
                    Pair(50.0, 100.0),
                    1.0,
                    0.54,
                    1005.0,
                    WeatherType.STORMY
                )
            )
            , weatherService.getWeeklyForecast(Pair(50.0, 100.0))
        )

        assertEquals(
            listOf(
                WeatherForecastImp(
                    "Gdańsk",
                    Pair(-50.0, 20.0),
                    15.0,
                    0.40,
                    1013.0,
                    WeatherType.SUNNY
                )
            ), weatherService.getWeeklyForecast(Pair(-50.0, 20.0))
        )

    }

    @Test
    fun getWeeklyForecastFailTest() {
        assertEquals(
            mutableListOf<WeatherForecast>(),
            weatherService.getWeeklyForecast(Pair(33.3, 33.3))
        )
    }

    @Test
    fun getLocationsByCurrentWeatherTypeHappyTest() {
        assertEquals(
            listOf(
                WeatherForecastImp(
                    "Warszawa",
                    Pair(50.0, 100.0),
                    12.3,
                    0.88,
                    1011.3,
                    WeatherType.SUNNY
                ),
                WeatherForecastImp(
                    "Gdańsk",
                    Pair(-50.0, 20.0),
                    15.0,
                    0.40,
                    1013.0,
                    WeatherType.SUNNY
                )

            ), weatherService.getLocationsByCurrentWeatherType(WeatherType.SUNNY)
        )

        assertEquals(
            listOf(
                WeatherForecastImp(
                    "Warszawa",
                    Pair(200.0, 200.0),
                    -10.0,
                    0.23,
                    1000.0,
                    WeatherType.CLOUDY
                )
            ), weatherService.getLocationsByCurrentWeatherType(WeatherType.CLOUDY)
        )
    }

    @Test
    fun getLocationsByCurrentWeatherTypeFailTest() {
        assertEquals(
            listOf<WeatherForecast>(),
            weatherService.getLocationsByCurrentWeatherType(WeatherType.FOGGY)
        )
    }
}