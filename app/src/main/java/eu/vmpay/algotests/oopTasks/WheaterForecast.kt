package eu.vmpay.algotests.oopTasks

class WeatherForecastClass(
    private val name: String, private val location: Pair<Double, Double>,
    private val temp: Double, private val humadity: Double, private val pressure: Double,
    private val weatherType: WeatherType
) : IWeatherForecast {


    override fun getLocationName(): String {
        return name
    }

    override fun getLocation(): Pair<Double, Double> {
        return location
    }

    override fun getTemp(): Double {
        return temp
    }

    override fun getHumidity(): Double {
        return humadity
    }

    override fun getPressure(): Double {
        return pressure
    }

    override fun getWeatherType(): WeatherType {
        return weatherType
    }

    override fun toString(): String {
        return "Weather (name='$name', location=$location, temp=$temp, humadity=$humadity, pressure=$pressure, weatherType=$weatherType)"
    }
}