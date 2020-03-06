package eu.vmpay.algotests

interface WeatherForecast {

    fun getLocationName(): String

    fun getLocation(): Pair<Double, Double>

    fun getTemp(): Double

    fun getHumidity(): Double

    fun getPressure(): Double

    fun getWeatherType(): WeatherType
}

interface WeatherService {

    fun getCurrentWeather(location: Pair<Double, Double>): WeatherForecast?

    fun getTomorrowForecast(locationName: String): List<WeatherForecast>

    fun getWeeklyForecast(location: Pair<Double, Double>): List<WeatherForecast>

    fun getLocationsByCurrentWeatherType(weatherType: WeatherType): List<WeatherForecast>

}
