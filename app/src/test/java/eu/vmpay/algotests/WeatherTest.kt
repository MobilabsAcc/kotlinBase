package eu.vmpay.algotests

import junit.framework.TestCase.*
import org.junit.Test

class WeatherTest {

    val weatherForecast = Forecast("Warszawa", Pair(52.13, 21.0), 21.0, 34.2, 1012.2, WeatherType.SUNNY.typeName)
    val weatherService = Service()
    @Test
    fun getLocationNameTest(){
        assertEquals("Warszawa", weatherForecast.getLocationName())
        assertEquals("Gdynia", weatherService.getCurrentWeather(Pair(11.0, 11.0))?.getLocationName())
    }


    @Test
    fun getLocationTest(){
        assertEquals(Pair<Double,Double>(52.13, 21.0), weatherForecast.getLocation())
        assertEquals(Pair<Double,Double>(11.0, 11.0), weatherService.getTomorrowForecast("Gdynia")?.get(0)?.getLocation())
    }

    @Test
    fun getTempTest(){
        assertEquals(21.0, weatherForecast.getTemp())
        assertEquals(1.0, weatherService.getCurrentWeather(Pair(1.0, 1.0))?.getTemp())
        assertEquals(11.0, weatherService.getTomorrowForecast("Warszawa")?.get(1)?.getTemp())
    }

    @Test
    fun getHumidityTest(){
        assertEquals(34.2, weatherForecast.getHumidity())
        assertEquals(54.2, weatherService.getCurrentWeather(Pair(1.0, 1.0))?.getHumidity())
        assertEquals(44.2, weatherService.getTomorrowForecast("Gdynia")?.get(0)?.getHumidity())
    }

    @Test
    fun getPressureTest(){
        assertEquals(1012.2, weatherForecast.getPressure())
        assertEquals(992.2, weatherService.getCurrentWeather(Pair(1.0, 1.0))?.getPressure())
        assertEquals(1009.2, weatherService.getTomorrowForecast("Gdynia")?.get(0)?.getPressure())
    }

    @Test
    fun getWeatherTypeTest(){
        assertEquals("Sunny", weatherForecast.getWeatherType())
        assertEquals("Cloudy", weatherService.getCurrentWeather(Pair(1.0, 1.0))?.getWeatherType())
        assertEquals("Rainy", weatherService.getTomorrowForecast("Gdynia")?.get(0)?.getWeatherType())
    }

    @Test
    fun getCurrentWeatherTest(){
        assertTrue("Warszawa" == weatherService.getCurrentWeather(Pair(52.13, 21.0))?.getLocationName() && Pair(52.13, 21.0) == weatherService.getCurrentWeather(Pair(52.13, 21.0))?.getLocation() && 21.0 == weatherService.getCurrentWeather(Pair(52.13, 21.0))?.getTemp() && 34.2 == weatherService.getCurrentWeather(Pair(52.13, 21.0))?.getHumidity() && 1012.2 == weatherService.getCurrentWeather(Pair(52.13, 21.0))?.getPressure() && WeatherType.SUNNY.typeName == weatherService.getCurrentWeather(Pair(52.13, 21.0))?.getWeatherType())
        assertTrue("Gdynia" == weatherService.getCurrentWeather(Pair(11.0, 11.0))?.getLocationName() && Pair(11.0, 11.0) == weatherService.getCurrentWeather(Pair(11.0, 11.0))?.getLocation() && 14.0 == weatherService.getCurrentWeather(Pair(11.0, 11.0))?.getTemp() && 60.2 == weatherService.getCurrentWeather(Pair(11.0, 11.0))?.getHumidity() && 1015.2 == weatherService.getCurrentWeather(Pair(11.0, 11.0))?.getPressure() && WeatherType.SUNNY.typeName == weatherService.getCurrentWeather(Pair(11.0, 11.0))?.getWeatherType())
        assertNull(weatherService.getCurrentWeather(Pair(0.0, 0.0)))
    }

    @Test
    fun getTomorrowForecastTest(){
        assertTrue("Warszawa" == weatherService.getTomorrowForecast("Warszawa")?.get(1)?.getLocationName() && Pair(1.0, 1.0) == weatherService.getTomorrowForecast("Warszawa")?.get(1)?.getLocation() && 11.0 == weatherService.getTomorrowForecast("Warszawa")?.get(1)?.getTemp() && 19.9 == weatherService.getTomorrowForecast("Warszawa")?.get(1)?.getHumidity() && 1002.2 == weatherService.getTomorrowForecast("Warszawa")?.get(1)?.getPressure() && WeatherType.RAINY.typeName == weatherService.getTomorrowForecast("Warszawa")?.get(1)?.getWeatherType())
        assertTrue("Gdynia" == weatherService.getTomorrowForecast("Gdynia")?.get(0)?.getLocationName() && Pair(11.0, 11.0) == weatherService.getTomorrowForecast("Gdynia")?.get(0)?.getLocation() && 15.0 == weatherService.getTomorrowForecast("Gdynia")?.get(0)?.getTemp() && 44.2 == weatherService.getTomorrowForecast("Gdynia")?.get(0)?.getHumidity() && 1009.2 == weatherService.getTomorrowForecast("Gdynia")?.get(0)?.getPressure() && WeatherType.RAINY.typeName == weatherService.getTomorrowForecast("Gdynia")?.get(0)?.getWeatherType())
        assertEquals(listOf<WeatherForecast>(),weatherService.getTomorrowForecast("Miastko"))
    }

    @Test
    fun getWeeklyForecastTest(){
        assertTrue("Gdynia" == weatherService.getWeeklyForecast(Pair(11.0, 11.0))?.get(0)?.getLocationName() && Pair(11.0, 11.0) == weatherService.getWeeklyForecast(Pair(11.0, 11.0))?.get(0)?.getLocation() && 14.0 == weatherService.getWeeklyForecast(Pair(11.0, 11.0))?.get(0)?.getTemp() && 60.2 == weatherService.getWeeklyForecast(Pair(11.0, 11.0))?.get(0)?.getHumidity() && 1015.2 == weatherService.getWeeklyForecast(Pair(11.0, 11.0))?.get(0)?.getPressure() && WeatherType.SUNNY.typeName == weatherService.getWeeklyForecast(Pair(11.0, 11.0))?.get(0)?.getWeatherType() && "Gdynia" == weatherService.getWeeklyForecast(Pair(11.0, 11.0))?.get(1)?.getLocationName() && Pair(11.0, 11.0) == weatherService.getWeeklyForecast(Pair(11.0, 11.0))?.get(1)?.getLocation() && 15.0 == weatherService.getWeeklyForecast(Pair(11.0, 11.0))?.get(1)?.getTemp() && 44.2 == weatherService.getWeeklyForecast(Pair(11.0, 11.0))?.get(1)?.getHumidity() && 1009.2 == weatherService.getWeeklyForecast(Pair(11.0, 11.0))?.get(1)?.getPressure() && WeatherType.RAINY.typeName == weatherService.getWeeklyForecast(Pair(11.0, 11.0))?.get(1)?.getWeatherType())
        assertNull(weatherService.getWeeklyForecast(Pair(0.0, 0.0)))
        assertTrue("Warszawa" == weatherService.getWeeklyForecast(Pair(52.13, 21.0))?.get(0)?.getLocationName() && Pair(52.13, 21.0) == weatherService.getWeeklyForecast(Pair(52.13, 21.0))?.get(0)?.getLocation() && 21.0 == weatherService.getWeeklyForecast(Pair(52.13, 21.0))?.get(0)?.getTemp() && 34.2 == weatherService.getWeeklyForecast(Pair(52.13, 21.0))?.get(0)?.getHumidity() && 1012.2 == weatherService.getWeeklyForecast(Pair(52.13, 21.0))?.get(0)?.getPressure() && WeatherType.SUNNY.typeName == weatherService.getWeeklyForecast(Pair(52.13, 21.0))?.get(0)?.getWeatherType() && "Warszawa" == weatherService.getWeeklyForecast(Pair(52.13, 21.0))?.get(1)?.getLocationName() && Pair(52.13, 21.0) == weatherService.getWeeklyForecast(Pair(52.13, 21.0))?.get(1)?.getLocation() && 11.0 == weatherService.getWeeklyForecast(Pair(52.13, 21.0))?.get(1)?.getTemp() && 14.2 == weatherService.getWeeklyForecast(Pair(52.13, 21.0))?.get(1)?.getHumidity() && 1011.2 == weatherService.getWeeklyForecast(Pair(52.13, 21.0))?.get(1)?.getPressure() && WeatherType.CLOUDY.typeName == weatherService.getWeeklyForecast(Pair(52.13, 21.0))?.get(1)?.getWeatherType())
    }

    @Test
    fun getLocationsByCurrentWeatherTypeTest() {
        assertTrue( "Warszawa" == weatherService.getLocationsByCurrentWeatherType(WeatherType.CLOUDY.typeName)[0].getLocationName() && Pair(1.0, 1.0) == weatherService.getLocationsByCurrentWeatherType(WeatherType.CLOUDY.typeName)[0].getLocation() && 1.0 == weatherService.getLocationsByCurrentWeatherType(WeatherType.CLOUDY.typeName)[0].getTemp() && 54.2 == weatherService.getLocationsByCurrentWeatherType(WeatherType.CLOUDY.typeName)[0].getHumidity() && 992.2 == weatherService.getLocationsByCurrentWeatherType(WeatherType.CLOUDY.typeName)[0].getPressure() && WeatherType.CLOUDY.typeName == weatherService.getLocationsByCurrentWeatherType(WeatherType.CLOUDY.typeName)[0].getWeatherType())
        assertEquals(listOf<WeatherForecast>(), weatherService.getLocationsByCurrentWeatherType(WeatherType.RAINY.typeName))
    }
}