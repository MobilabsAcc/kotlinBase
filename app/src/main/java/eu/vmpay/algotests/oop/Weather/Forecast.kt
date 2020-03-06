package eu.vmpay.algotests.oop.Weather

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime

class Forecast (val location: Location, val forecastDetails: ForecastDetails, val date: LocalDateTime ) :
    WeatherForecast {
    override fun getLocationName(): String = location.name

    override fun getLocation(): Pair<Double, Double> = location.coordinates

    override fun getTemp(): Double  = forecastDetails.temp

    override fun getHumidity(): Double = forecastDetails.humidity

    override fun getPressure(): Double = forecastDetails.pressure

    override fun getWeatherType(): WeatherType = forecastDetails.type

}

class ForecastDetails(val humidity:Double, val temp: Double, val pressure:Double,val type: WeatherType)

enum class WeatherType(type :String){
    CLOUDY("cloudy"),
    SUNNY("sunny"),
    RAINY("rainy"),
    WINDY("windy")
}

class Location (val name:String, val coordinates: Pair<Double,Double>){

}

class ForecastService : WeatherService {
    @RequiresApi(Build.VERSION_CODES.O)
    private val today = LocalDateTime.of(2000,4,22,20,0)
    @RequiresApi(Build.VERSION_CODES.O)
    private val tommorow = LocalDateTime.of(2000,4,23,20,0)
    val database = ForecastDatabase()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun getCurrentWeather(location: Pair<Double, Double>): WeatherForecast =
        database.forecastList.first { it.location.coordinates == location && it.date == today }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun getTomorrowForecast(locationName: String): List<WeatherForecast> =
        database.forecastList.filter { it.location.name == locationName && it.date == tommorow}



    @RequiresApi(Build.VERSION_CODES.O)
    override fun getWeeklyForecast(location: Pair<Double, Double>): List<WeatherForecast> =
        database.forecastList.filter { it.location.coordinates == location &&
                it.date.isAfter(today) && it.date.isBefore(today.plusDays(7))  }



    override fun getLocationsByCurrentWeatherType(weatherType: WeatherType): List<WeatherForecast> =
        database.forecastList.filter { it.forecastDetails.type ==  weatherType}



}

