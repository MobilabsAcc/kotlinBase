package eu.vmpay.algotests.oop

import eu.vmpay.algotests.oop.Weather.ForecastDatabase
import eu.vmpay.algotests.oop.Weather.WeatherType
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test


 class ForecastTest {
     val database = ForecastDatabase()
     val delta = 0.0


    @Test
     fun getLocationNameTest(){
        assertEquals("Warsaw",database.forecastList[0].getLocationName())
        assertEquals("Tokio",database.forecastList[12].getLocationName())
        assertEquals("Orlando",database.forecastList[32].getLocationName())
        assertNotEquals("Tokio",database.forecastList[3].getLocationName())
        assertNotEquals("Warsaw",database.forecastList[17].getLocationName())
        assertNotEquals("Orlando",database.forecastList[15].getLocationName())

    }
     @Test
     fun getLocationTest(){
         assertEquals(Pair(27.0,37.3),database.forecastList[0].getLocation())
         assertEquals(Pair(54.00,27.3),database.forecastList[27].getLocation())
         assertEquals(Pair(12.0,89.2),database.forecastList[12].getLocation())
         assertNotEquals(Pair(27.0,37.3),database.forecastList[18].getLocation())
         assertNotEquals(Pair(54.00,27.3),database.forecastList[5].getLocation())
         assertNotEquals(Pair(12.0,89.2),database.forecastList[9].getLocation())
     }

     @Test
     fun getTempTest(){
         assertEquals(22.4,database.forecastList[0].getTemp(),delta)
         assertEquals(21.4,database.forecastList[1].getTemp(),delta)
         assertEquals(13.4,database.forecastList[3].getTemp(),delta)
         assertNotEquals(10.4,database.forecastList[7].getTemp(),delta)
         assertNotEquals(1.8,database.forecastList[4].getTemp(),delta)
         assertNotEquals(25.9,database.forecastList[5].getTemp(),delta)
     }
     @Test
     fun getHumidityTest(){
         assertEquals(25.9,database.forecastList[20].getHumidity(),delta)
         assertEquals(47.3,database.forecastList[19].getHumidity(),delta)
         assertEquals(72.1,database.forecastList[33].getHumidity(),delta)
         assertNotEquals(57.8,database.forecastList[16].getHumidity(),delta)
         assertNotEquals(42.5,database.forecastList[19].getHumidity(),delta)
         assertNotEquals(27.6,database.forecastList[11].getHumidity(),delta)
     }
     @Test
     fun getPressureTest(){
         assertEquals(1012.3,database.forecastList[17].getPressure(),delta)
         assertEquals(1010.3,database.forecastList[33].getPressure(),delta)
         assertEquals(1001.3,database.forecastList[14].getPressure(),delta)
         assertNotEquals(1007.3,database.forecastList[20].getPressure(),delta)
         assertNotEquals(1010.2,database.forecastList[3].getPressure(),delta)
         assertNotEquals(1012.9,database.forecastList[8].getPressure(),delta)
     }
     @Test
     fun getWeatherTypeTest(){
         assertEquals(WeatherType.RAINY,database.forecastList[15].getWeatherType())
         assertEquals(WeatherType.RAINY,database.forecastList[14].getWeatherType())
         assertEquals(WeatherType.CLOUDY,database.forecastList[1].getWeatherType())
         assertNotEquals(WeatherType.SUNNY,database.forecastList[2].getWeatherType())
         assertNotEquals(WeatherType.RAINY,database.forecastList[20].getWeatherType())
         assertNotEquals(WeatherType.CLOUDY,database.forecastList[15].getWeatherType())
     }



}