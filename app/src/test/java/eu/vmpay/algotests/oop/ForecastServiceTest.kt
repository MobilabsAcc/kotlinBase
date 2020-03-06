package eu.vmpay.algotests.oop

import eu.vmpay.algotests.oop.Weather.ForecastService
import eu.vmpay.algotests.oop.Weather.WeatherType
import org.junit.Test

import org.junit.Assert.*

class ForecastServiceTest {
    val forecastService = ForecastService()


    @Test
    fun getCurrentWeatherTest() {
        assertEquals(WeatherType.CLOUDY,forecastService.getCurrentWeather(Pair(27.0, 37.3)).getWeatherType())
        assertEquals(WeatherType.RAINY,forecastService.getCurrentWeather(Pair(12.0, 89.2)).getWeatherType())
        assertEquals(WeatherType.SUNNY,forecastService.getCurrentWeather(Pair(54.00, 27.3)).getWeatherType())
        assertNotEquals(WeatherType.CLOUDY,forecastService.getCurrentWeather(Pair(54.00, 27.3)).getWeatherType())
        assertNotEquals(WeatherType.RAINY,forecastService.getCurrentWeather(Pair(54.00, 27.3)).getWeatherType())
        assertNotEquals(WeatherType.SUNNY,forecastService.getCurrentWeather(Pair(27.0, 37.3)).getWeatherType())
    }

    @Test
    fun getTomorrowForecastTest() {
        assertEquals(1,forecastService.getTomorrowForecast("Warsaw").size)
        assertEquals(4,forecastService.getTomorrowForecast("Tokio").size)
        assertEquals(1,forecastService.getTomorrowForecast("Orlando").size)
        assertNotEquals(9,forecastService.getTomorrowForecast("Warsaw").size)
        assertNotEquals(5,forecastService.getTomorrowForecast("Tokio").size)
        assertNotEquals(8,forecastService.getTomorrowForecast("Orlando").size)
    }

    @Test
    fun getWeeklyForecastTest() {
        assertEquals(7,forecastService.getWeeklyForecast(Pair(27.0, 37.3)).size)
        assertEquals(7,forecastService.getWeeklyForecast(Pair(12.0, 89.2)).size)
        assertEquals(7,forecastService.getWeeklyForecast(Pair(54.00, 27.3)).size)
        assertNotEquals(1,forecastService.getWeeklyForecast(Pair(27.0, 37.3)).size)
        assertNotEquals(2,forecastService.getWeeklyForecast(Pair(12.0, 89.2)).size)
        assertNotEquals(3,forecastService.getWeeklyForecast(Pair(54.00, 27.3)).size)
    }

    @Test
    fun getLocationsByCurrentWeatherTypeTest() {
        assertEquals(5,forecastService.getLocationsByCurrentWeatherType(WeatherType.SUNNY).size)
        assertEquals(7,forecastService.getLocationsByCurrentWeatherType(WeatherType.RAINY).size)
        assertEquals(20,forecastService.getLocationsByCurrentWeatherType(WeatherType.CLOUDY).size)
        assertNotEquals(1,forecastService.getLocationsByCurrentWeatherType(WeatherType.SUNNY).size)
        assertNotEquals(11,forecastService.getLocationsByCurrentWeatherType(WeatherType.CLOUDY).size)
        assertNotEquals(111,forecastService.getLocationsByCurrentWeatherType(WeatherType.WINDY).size)
    }
}