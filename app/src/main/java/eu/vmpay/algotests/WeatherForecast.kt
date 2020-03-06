package eu.vmpay.algotests

class WeatherForecasts(
    private val name: String,
    private val location: Pair<Double, Double>,
    private val temp: Double,
    private val humidity: Double,
    private val pressure: Double,
    private val weatherType: WeatherType
) : WeatherForecast {
    init {

    }
    override fun getLocationName(): String {
        return name
    }

    override fun getLocation(): Pair<Double, Double> {
        return location
    }

    override fun getTemp(): Double {
        return  temp
    }

    override fun getHumidity(): Double {
        return humidity
    }

    override fun getPressure(): Double {
        return  pressure
    }

    override fun getWeatherType(): WeatherType {
        return weatherType
    }

}


enum class WeatherType(type :String){
    SNOWY("snowy"),
    SUNNY("sunny"),
    RAINY("rainy")
}