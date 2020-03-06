package eu.vmpay.algotests


import junit.framework.Assert.assertEquals
import org.junit.Test

class WeatherTest {

    private val testClass = WeatherForecasts("Warsaw", Pair(100.0, 100.0), 100.0, 100.0, 100.0, WeatherType.SNOWY)
    private val testClass2 = WeatherForecasts("Paris", Pair(101.0, 100.0), 101.0, 101.0, 101.0, WeatherType.SUNNY)


        @Test
        fun getLocationNameTest(){
            assertEquals("Warsaw", testClass.getLocationName())
            assertEquals("Paris", testClass2.getLocationName())
        }


        @Test
        fun getLocationTest(){
            assertEquals(Pair(100.0, 100.0), testClass.getLocation())
            assertEquals(Pair(101.0, 100.0), testClass2.getLocation())
        }

        @Test
        fun getTempTest(){
            assertEquals(100.0, testClass.getTemp())
            assertEquals(101.0, testClass2.getTemp())
        }

        @Test
        fun getHumidityTest(){
            assertEquals(100.0, testClass.getHumidity())
            assertEquals(101.0, testClass2.getHumidity())
        }

        @Test
        fun getPressureTest(){
            assertEquals(100.0,testClass.getPressure())
            assertEquals(101.0,testClass2.getPressure())


        }

        @Test
        fun getWeatherType(){
            assertEquals(WeatherType.SNOWY,testClass.getWeatherType())
            assertEquals(WeatherType.SUNNY,testClass2.getWeatherType())

        }

    }


