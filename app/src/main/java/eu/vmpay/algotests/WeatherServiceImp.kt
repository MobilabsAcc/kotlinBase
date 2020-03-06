package eu.vmpay.algotests

class WeatherServiceImp : WeatherService {
    private val place = HashMap<Pair<Double, Double>, List<WeatherForecast>>()
    private val coordinates = HashMap<String, List<Pair<Double, Double>>>()

    init {
        coordinates["Warszawa"] = listOf(Pair(50.0, 100.0), Pair(200.0, 200.0))
        place[Pair(50.0, 100.0)] = listOf(
            WeatherForecastImp(
                "Warszawa",
                Pair(50.0, 100.0),
                12.3,
                0.88,
                1011.3,
                WeatherType.SUNNY
            ),
            WeatherForecastImp(
                "Warszawa",
                Pair(50.0, 100.0),
                11.3,
                0.42,
                1009.0,
                WeatherType.CLOUDY
            ),
            WeatherForecastImp("Warszawa", Pair(50.0, 100.0), 10.3, 1.0, 1000.9, WeatherType.RAINY),
            WeatherForecastImp(
                "Warszawa",
                Pair(50.0, 100.0),
                11.1,
                0.54,
                1019.0,
                WeatherType.CLOUDY
            ),
            WeatherForecastImp(
                "Warszawa",
                Pair(50.0, 100.0),
                13.3,
                0.12,
                1003.0,
                WeatherType.CLOUDY
            ),
            WeatherForecastImp("Warszawa", Pair(50.0, 100.0), 1.2, 0.44, 1002.0, WeatherType.SNOWY),
            WeatherForecastImp(
                "Warszawa",
                Pair(50.0, 100.0),
                1.0,
                0.54,
                1005.0,
                WeatherType.STORMY
            ),
            WeatherForecastImp("Warszawa", Pair(50.0, 100.0), 3.2, 0.66, 1007.0, WeatherType.WINDY)
        )
        place[Pair(200.0, 200.0)] = listOf(
            WeatherForecastImp(
                "Warszawa",
                Pair(200.0, 200.0),
                -10.0,
                0.23,
                1000.0,
                WeatherType.CLOUDY
            ),
            WeatherForecastImp(
                "Warszawa",
                Pair(200.0, 200.0),
                -3.0,
                0.43,
                1020.0,
                WeatherType.CLOUDY
            ),
            WeatherForecastImp(
                "Warszawa",
                Pair(200.0, 200.0),
                -4.0,
                0.50,
                1001.0,
                WeatherType.WINDY
            ),
            WeatherForecastImp("Warszawa", Pair(200.0, 200.0), 1.0, 0.76, 1003.0, WeatherType.WINDY)
        )

        coordinates["Gdańsk"] = listOf(Pair(0.0, 0.0))
        place[Pair(0.0, 0.0)] = listOf(
            WeatherForecastImp("Gdańsk", Pair(0.0, 0.0), 3.0, 0.98, 1000.0, WeatherType.RAINY),
            WeatherForecastImp("Gdańsk", Pair(0.0, 0.0), 2.0, 0.96, 998.0, WeatherType.RAINY),
            WeatherForecastImp("Gdańsk", Pair(0.0, 0.0), 1.0, 0.57, 1001.0, WeatherType.RAINY),
            WeatherForecastImp("Gdańsk", Pair(0.0, 0.0), 0.0, 0.99, 1006.0, WeatherType.STORMY),
            WeatherForecastImp("Gdańsk", Pair(0.0, 0.0), -1.0, 0.03, 1020.0, WeatherType.SUNNY),
            WeatherForecastImp("Gdańsk", Pair(0.0, 0.0), -2.0, 0.04, 1005.0, WeatherType.SUNNY),
            WeatherForecastImp("Gdańsk", Pair(0.0, 0.0), -3.0, 0.02, 1005.0, WeatherType.SUNNY),
            WeatherForecastImp("Gdańsk", Pair(0.0, 0.0), -4.0, 0.05, 1019.0, WeatherType.SUNNY)

        )
        coordinates["Kraków"] = listOf(Pair(-50.0, 20.0))
        place[Pair(-50.0, 20.0)] = listOf(
            WeatherForecastImp("Gdańsk", Pair(-50.0, 20.0), 15.0, 0.40, 1013.0, WeatherType.SUNNY)
        )
    }

    override fun getCurrentWeather(location: Pair<Double, Double>): WeatherForecast? {
        return place[location]?.get(0)
    }

    override fun getTomorrowForecast(locationName: String): List<WeatherForecast> {
        val list = coordinates[locationName] ?: listOf()
        val forecastList = mutableListOf<WeatherForecast>()
        for (i in list) {
            val currentWeatherForecast = place[i]
            if (currentWeatherForecast != null)
                if (currentWeatherForecast.size > 1)
                    forecastList.add(currentWeatherForecast[1])
        }
        return forecastList
    }

    override fun getWeeklyForecast(location: Pair<Double, Double>): List<WeatherForecast> {
        val list = place[location] ?: listOf()
        val forecastList = mutableListOf<WeatherForecast>()
        val range = if (list.size > 7) 7 else list.size
        for (i in 0 until range)
            forecastList.add(list[i])
        return forecastList
    }

    override fun getLocationsByCurrentWeatherType(weatherType: WeatherType): List<WeatherForecast> {
        val forecastList = mutableListOf<WeatherForecast>()
        for (i in place.values)
            if (i[0].getWeatherType() == weatherType)
                forecastList.add(i[0])
        return forecastList
    }


}