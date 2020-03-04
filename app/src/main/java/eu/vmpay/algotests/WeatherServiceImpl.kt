package eu.vmpay.algotests

class WeatherServiceImpl: WeatherService {

    val locationNames = HashMap<Pair<Double, Double>, String>()
    val forecast = HashMap<String, List<WeatherForecast>>()

    init {
        locationNames[Pair(0.0, 0.0)] = "Warszawa"
        forecast["Warszawa"] = listOf(
            WeatherForecastImp("Warszawa", Pair(0.0, 0.0), 20.0, 40.0, 1013.0, WeatherType.SUNNY),
            WeatherForecastImp("Warszawa", Pair(0.0, 0.0), 20.0, 40.0, 1013.0, WeatherType.SUNNY),
            WeatherForecastImp("Warszawa", Pair(0.0, 0.0), 20.0, 40.0, 1013.0, WeatherType.SUNNY),
            WeatherForecastImp("Warszawa", Pair(0.0, 0.0), 20.0, 40.0, 1013.0, WeatherType.SUNNY),
            WeatherForecastImp("Warszawa", Pair(0.0, 0.0), 20.0, 40.0, 1013.0, WeatherType.SUNNY),
            WeatherForecastImp("Warszawa", Pair(0.0, 0.0), 20.0, 40.0, 1013.0, WeatherType.SUNNY),
            WeatherForecastImp("Warszawa", Pair(0.0, 0.0), 20.0, 40.0, 1013.0, WeatherType.SUNNY)
        )
        forecast["Gdańsk"] = listOf(
            WeatherForecastImp("Gdańsk", Pair(1.0, 1.0), 20.0, 40.0, 1013.0, WeatherType.SUNNY),
            WeatherForecastImp("Gdańsk", Pair(1.0, 1.0), 20.0, 40.0, 1013.0, WeatherType.SUNNY),
            WeatherForecastImp("Gdańsk", Pair(1.0, 1.0), 20.0, 40.0, 1013.0, WeatherType.SUNNY),
            WeatherForecastImp("Gdańsk", Pair(1.0, 1.0), 20.0, 40.0, 1013.0, WeatherType.SUNNY),
            WeatherForecastImp("Gdańsk", Pair(1.0, 1.0), 20.0, 40.0, 1013.0, WeatherType.SUNNY),
            WeatherForecastImp("Gdańsk", Pair(1.0, 1.0), 20.0, 40.0, 1013.0, WeatherType.SUNNY),
            WeatherForecastImp("Gdańsk", Pair(1.0, 1.0), 20.0, 40.0, 1013.0, WeatherType.SUNNY)
        )
    }

    override fun getCurrentWeather(location: Pair<Double, Double>): WeatherForecast {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getTomorrowForecast(locationName: String): List<WeatherForecast> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getWeeklyForecast(location: Pair<Double, Double>): List<WeatherForecast> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLocationsByCurrentWeatherType(weatherType: String): List<WeatherForecast> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}