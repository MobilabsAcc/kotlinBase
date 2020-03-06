package eu.vmpay.algotests.oopTasks

interface IWeatherForecast {

    fun getLocationName(): String

    fun getLocation(): Pair<Double, Double>

    fun getTemp(): Double

    fun getHumidity(): Double

    fun getPressure(): Double

    fun getWeatherType(): WeatherType
}

interface IWeatherService {

    fun getCurrentWeather(location: Pair<Double, Double>): IWeatherForecast?

    fun getTomorrowForecast(locationName: String): List<IWeatherForecast>

    fun getWeeklyForecast(location: Pair<Double, Double>): List<IWeatherForecast>

    fun getLocationsByCurrentWeatherType(weatherType: WeatherType): List<IWeatherForecast>

}