package eu.vmpay.algotests

interface WeatherForecast {

    fun getLocationName(): String

    fun getLocation(): Pair<Double, Double>

    fun getTemp(): Double

    fun getHumidity(): Double

    fun getPressure(): Double

    fun getWeatherType(): String
}

interface WeatherService {

    fun getCurrentWeather(location: Pair<Double, Double>): WeatherForecast?

    fun getTomorrowForecast(locationName: String): List<WeatherForecast>?

    fun getWeeklyForecast(location: Pair<Double, Double>): List<WeatherForecast>?

    fun getLocationsByCurrentWeatherType(weatherType: String): List<WeatherForecast>

}

enum class WeatherType(val typeName:String) {
    SUNNY("Sunny"),
    CLOUDY("Cloudy"),
    RAINY("Rainy")
}

class Forecast (private val locationName:String, private val location:Pair<Double, Double>, private val temperature: Double,private val humidity: Double, private val pressure : Double, private val weatherType : String) : WeatherForecast {
    override fun getLocationName(): String {
        return locationName
    }

    override fun getLocation(): Pair<Double, Double> {
        return location
    }

    override fun getTemp(): Double {
        return temperature
    }

    override fun getHumidity(): Double {
        return humidity
    }

    override fun getPressure(): Double {
        return pressure
    }

    override fun getWeatherType(): String {
        return weatherType
    }

}

class Service : WeatherService {
    private var locationMap = mutableMapOf<String, List<Pair<Double, Double>>>()
    private var forecasts = mutableMapOf<Pair<Double, Double>, List<WeatherForecast>>()
    init{
        forecasts[Pair(52.13, 21.0)] =
            mutableListOf(Forecast("Warszawa", Pair(52.13, 21.0), 21.0, 34.2, 1012.2, WeatherType.SUNNY.typeName),
                Forecast("Warszawa", Pair(52.13, 21.0), 11.0, 14.2, 1011.2, WeatherType.CLOUDY.typeName))
        forecasts[Pair(1.0, 1.0)] =
            mutableListOf(Forecast("Warszawa", Pair(1.0, 1.0), 1.0, 54.2, 992.2, WeatherType.CLOUDY.typeName),
                Forecast("Warszawa", Pair(1.0, 1.0), 11.0, 19.9, 1002.2, WeatherType.RAINY.typeName))
        forecasts[Pair(11.0, 11.0)] =
            mutableListOf(Forecast("Gdynia", Pair(11.0, 11.0), 14.0, 60.2, 1015.2, WeatherType.SUNNY.typeName),
                Forecast("Gdynia", Pair(11.0, 11.0), 15.0, 44.2, 1009.2, WeatherType.RAINY.typeName))
        locationMap["Warszawa"] = mutableListOf(Pair(52.13, 21.0), Pair(1.0, 1.0))
        locationMap["Gdynia"] = mutableListOf(Pair(11.0, 11.0))
    }
    override fun getCurrentWeather(location: Pair<Double, Double>): WeatherForecast? {
        return if(forecasts[location] == null)
            null
        else
            forecasts[location]!![0]
    }


    override fun getTomorrowForecast(locationName: String): List<WeatherForecast>? {
        val pairs = locationMap[locationName] ?: listOf()
        val allForecasts = mutableListOf<WeatherForecast>()
        for(pair in pairs) {
            if(forecasts[pair] != null)
                forecasts[pair]?.get(1)?.let { allForecasts.add(it) }
        }
        return allForecasts
    }

    override fun getWeeklyForecast(location: Pair<Double, Double>): List<WeatherForecast>? {
        return forecasts[location]
    }

    override fun getLocationsByCurrentWeatherType(weatherType: String): List<WeatherForecast> {
        val result = mutableListOf<WeatherForecast>()
        for(forecast in forecasts) {
            if(forecast.value[0].getWeatherType() == weatherType)
                result.add(forecast.value[0])
        }
        return result
    }

}
