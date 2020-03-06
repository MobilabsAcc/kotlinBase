package eu.vmpay.algotests

data class WeatherForecastImp(
    private val locationName: String,
    private val location: Pair<Double, Double>,
    private val temp: Double,
    private val humidity: Double,
    private val pressure: Double,
    private val weatherType: WeatherType
) : WeatherForecast {

    override fun getLocationName(): String {
        return locationName
    }

    override fun getLocation(): Pair<Double, Double> {
        return location
    }

    override fun getTemp(): Double {
        return temp
    }

    override fun getHumidity(): Double {
        return humidity
    }

    override fun getPressure(): Double {
        return pressure
    }

    override fun getWeatherType(): WeatherType {
        return weatherType
    }
}