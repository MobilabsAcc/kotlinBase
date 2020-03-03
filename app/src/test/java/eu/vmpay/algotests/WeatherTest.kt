package eu.vmpay.algotests

import junit.framework.Assert.assertEquals
import org.junit.Test

class WeatherTest {

    val weatherForecastClass = WeatherForecastClass("Warszawa", Pair(52.13, 21.0), 8.0, 0.85, 1002.0, WeatherType.CLOUDY)

    val weather = WeatherServiceClass()
    val weatcherDatabase = weather.doResearch()

    @Test
    fun getLocationName() {

        assertEquals("Warszawa",
            weatherForecastClass.getLocationName())
    }

    @Test
    fun getLocation() {
        assertEquals(Pair(52.13, 21.0), weatherForecastClass.getLocation())
    }

    @Test
    fun getTemp() {
        assertEquals(8.0, weatherForecastClass.getTemp())
    }

    @Test
    fun getHumidity() {
        assertEquals(0.85, weatherForecastClass.getHumidity())
    }

    @Test
    fun getPressure() {
        assertEquals(1002.0, weatherForecastClass.getPressure())
    }

    @Test
    fun getWeatherType() {
        assertEquals(WeatherType.CLOUDY, weatherForecastClass.getWeatherType())
    }


    @Test
    fun getCurrentWeather() { //It doesnt work but outputs are identical


        weatcherDatabase.put("06/03/2020", mutableListOf(
            WeatherForecastClass("Warszawa", Pair(52.13, 21.0), 8.0, 0.85, 1002.0, WeatherType.CLOUDY)))

        assertEquals("Weather (name='Warszawa', location=(52.13, 21.0), temp=8.0, humadity=0.85, pressure=1002.0, weatherType=CLOUDY)",
            weather.getCurrentWeather(Pair(52.13, 21.0)))
    }

    @Test
    fun getTomorrowForecast() {

        assertEquals("[Weather (name='Warszawa', location=(52.13, 21.0), temp=20.0, humadity=0.85, pressure=1002.0, weatherType=CLOUDY), Weather (name='Warszawa', location=(1.0, 1.0), temp=38.0, humadity=1.0, pressure=800.0, weatherType=CLOUDY)]", weather.getTomorrowForecast("Warszawa"))
    }

    @Test
    fun getWeeklyForecast() {
        assertEquals("[Weather (name='Warszawa', location=(52.13, 21.0), temp=20.0, humadity=0.85, pressure=1002.0, weatherType=CLOUDY), Weather (name='Warszawa', location=(52.13, 21.0), temp=20.0, humadity=0.85, pressure=1002.0, weatherType=SUNNY), Weather (name='Warszawa', location=(52.13, 21.0), temp=8.0, humadity=0.85, pressure=1002.0, weatherType=CLOUDY), Weather (name='Warszawa', location=(52.13, 21.0), temp=20.0, humadity=0.85, pressure=1002.0, weatherType=SUNNY), Weather (name='Warszawa', location=(52.13, 21.0), temp=20.0, humadity=0.85, pressure=1002.0, weatherType=SUNNY), Weather (name='Warszawa', location=(52.13, 21.0), temp=20.0, humadity=0.85, pressure=1002.0, weatherType=SUNNY), Weather (name='Warszawa', location=(52.13, 21.0), temp=20.0, humadity=0.85, pressure=1002.0, weatherType=SUNNY)]",
            weather.getWeeklyForecast(Pair(52.13, 21.0)))
    }

    @Test
    fun getLocationsByCurrentWeatherType() {
        assertEquals(
            "[Weather (name='Gdansk', location=(54.22, 18.38), temp=28.0, humadity=0.89, pressure=1000.0, weatherType=SNOWY)]",
            weather.getLocationsByCurrentWeatherType(WeatherType.SNOWY))
    }
}