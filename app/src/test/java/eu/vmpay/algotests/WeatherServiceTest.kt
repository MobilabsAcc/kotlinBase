package eu.vmpay.algotests


import junit.framework.Assert.assertEquals
import org.junit.Test

class WeatherServiceTest {
    private val testClass = WeatherForecasts("Warsaw", Pair(100.0, 100.0), 100.0, 100.0, 100.0, WeatherType.SNOWY)
    private val testClass2 = WeatherForecasts("Paris", Pair(101.0, 100.0), 101.0, 101.0, 101.0, WeatherType.SUNNY)
    private val weatherData = HashMap<String, MutableList<WeatherForecasts>>()


    @Test
    fun getCurrentWeatherTest(){
        weatherData["FRIDAY"] = mutableListOf(testClass)
        val weatherServices = WeatherServices(weatherData)
        assertEquals(testClass,weatherServices.getCurrentWeather(Pair(100.0,100.0)))
    }


    @Test
    fun getTomorrowForecastTest(){
        weatherData["SATURDAY"] = mutableListOf(testClass)
        weatherData["FRIDAY"] = mutableListOf(testClass2)
        val weatherServices = WeatherServices(weatherData)
        assertEquals(listOf(testClass),weatherServices.getTomorrowForecast("Warsaw"))
    }


    @Test
    fun getWeeklyForecastTest(){
        weatherData["FRIDAY"] = mutableListOf(testClass)
        val weatherServices = WeatherServices(weatherData)
        assertEquals(listOf(testClass),weatherServices.getWeeklyForecast(Pair(100.0,100.0)))
    }


    @Test
    fun getLocationsByCurrentWeatherTypeTest(){
        weatherData["FRIDAY"] = mutableListOf(testClass)
        weatherData["SATURDAY"] = mutableListOf(testClass2)
        val weatherServices = WeatherServices(weatherData)
        assertEquals(listOf(testClass2),weatherServices.getLocationsByCurrentWeatherType(WeatherType.SUNNY))
    }
}