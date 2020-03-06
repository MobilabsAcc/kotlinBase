package eu.vmpay.algotests

class WeatherServiceImpl: WeatherService {

    val locationsForName = HashMap<String, List<Pair<Double, Double>>>()
    val forecast = HashMap<Pair<Double, Double>, List<WeatherForecast>>()

    init {
        locationsForName["Warszawa"] = listOf(Pair(0.0, 0.0))
        locationsForName["Gdańsk"] = listOf(Pair(1.0, 1.0))
        locationsForName["Poznań"] = listOf(Pair(-1.0, 0.0))
        locationsForName["Nowa wieś wielka"] = listOf(Pair(1.5, 0.5), Pair(1.5, -0.5))
        forecast[Pair(0.0, 0.0)] = listOf(
            WeatherForecastImpl("Warszawa", Pair(0.0, 0.0), 20.0, 40.0, 1013.0, WeatherType.SUNNY),
            WeatherForecastImpl("Warszawa", Pair(0.0, 0.0), 21.0, 40.0, 1013.0, WeatherType.SUNNY),
            WeatherForecastImpl("Warszawa", Pair(0.0, 0.0), 22.0, 41.0, 1012.0, WeatherType.SUNNY),
            WeatherForecastImpl("Warszawa", Pair(0.0, 0.0), 22.0, 40.0, 1013.0, WeatherType.SUNNY),
            WeatherForecastImpl("Warszawa", Pair(0.0, 0.0), 20.0, 43.0, 1012.0, WeatherType.SUNNY),
            WeatherForecastImpl("Warszawa", Pair(0.0, 0.0), 22.0, 40.0, 1011.0, WeatherType.SUNNY),
            WeatherForecastImpl("Warszawa", Pair(0.0, 0.0), 20.0, 40.0, 1013.0, WeatherType.SUNNY)
        )
        forecast[Pair(1.0, 1.0)] = listOf(
            WeatherForecastImpl("Gdańsk", Pair(1.0, 1.0), 20.0, 40.0, 1013.0, WeatherType.SUNNY),
            WeatherForecastImpl("Gdańsk", Pair(1.0, 1.0), 21.0, 44.0, 1007.0, WeatherType.CLOUDY),
            WeatherForecastImpl("Gdańsk", Pair(1.0, 1.0), 17.0, 39.0, 1000.0, WeatherType.RAINY),
            WeatherForecastImpl("Gdańsk", Pair(1.0, 1.0), 16.0, 50.0, 998.0, WeatherType.RAINY),
            WeatherForecastImpl("Gdańsk", Pair(1.0, 1.0), 16.0, 51.0, 996.0, WeatherType.RAINY),
            WeatherForecastImpl("Gdańsk", Pair(1.0, 1.0), 18.0, 43.0, 1007.0, WeatherType.CLOUDY),
            WeatherForecastImpl("Gdańsk", Pair(1.0, 1.0), 22.0, 40.0, 1013.0, WeatherType.SUNNY)
        )
        forecast[Pair(-1.0, 0.0)] = listOf(
            WeatherForecastImpl("Poznań", Pair(-1.0, 0.0), 17.0, 40.0, 1013.0, WeatherType.CLOUDY),
            WeatherForecastImpl("Poznań", Pair(-1.0, 0.0), 15.0, 44.0, 1007.0, WeatherType.CLOUDY),
            WeatherForecastImpl("Poznań", Pair(-1.0, 0.0), 17.0, 39.0, 1000.0, WeatherType.RAINY),
            WeatherForecastImpl("Poznań", Pair(-1.0, 0.0), 16.0, 50.0, 998.0, WeatherType.RAINY),
            WeatherForecastImpl("Poznań", Pair(-1.0, 0.0), 16.0, 51.0, 996.0, WeatherType.RAINY),
            WeatherForecastImpl("Poznań", Pair(-1.0, 0.0), 18.0, 43.0, 1007.0, WeatherType.CLOUDY),
            WeatherForecastImpl("Poznań", Pair(-1.0, 0.0), 22.0, 40.0, 1013.0, WeatherType.SUNNY)
        )
        forecast[Pair(1.5, 0.5)] = listOf(
            WeatherForecastImpl("Nowa wieś wielka", Pair(1.5, 0.5), 17.0, 40.0, 1013.0, WeatherType.CLOUDY),
            WeatherForecastImpl("Nowa wieś wielka", Pair(1.5, 0.5), 15.0, 44.0, 1007.0, WeatherType.CLOUDY),
            WeatherForecastImpl("Nowa wieś wielka", Pair(1.5, 0.5), 17.0, 39.0, 1000.0, WeatherType.RAINY),
            WeatherForecastImpl("Nowa wieś wielka", Pair(1.5, 0.5), 16.0, 50.0, 998.0, WeatherType.RAINY),
            WeatherForecastImpl("Nowa wieś wielka", Pair(1.5, 0.5), 16.0, 51.0, 996.0, WeatherType.RAINY),
            WeatherForecastImpl("Nowa wieś wielka", Pair(1.5, 0.5), 18.0, 43.0, 1007.0, WeatherType.CLOUDY),
            WeatherForecastImpl("Nowa wieś wielka", Pair(1.5, 0.5), 22.0, 40.0, 1013.0, WeatherType.SUNNY)
        )
        forecast[Pair(1.5, -0.5)] = listOf(
            WeatherForecastImpl("Nowa wieś wielka", Pair(1.5, -0.5), 17.0, 40.0, 1013.0, WeatherType.FOGGY),
            WeatherForecastImpl("Nowa wieś wielka", Pair(1.5, -0.5), 15.0, 44.0, 1007.0, WeatherType.CLOUDY),
            WeatherForecastImpl("Nowa wieś wielka", Pair(1.5, -0.5), 17.0, 39.0, 1000.0, WeatherType.RAINY),
            WeatherForecastImpl("Nowa wieś wielka", Pair(1.5, -0.5), 16.0, 50.0, 998.0, WeatherType.FOGGY),
            WeatherForecastImpl("Nowa wieś wielka", Pair(1.5, -0.5), 16.0, 51.0, 996.0, WeatherType.RAINY),
            WeatherForecastImpl("Nowa wieś wielka", Pair(1.5, -0.5), 18.0, 43.0, 1007.0, WeatherType.CLOUDY),
            WeatherForecastImpl("Nowa wieś wielka", Pair(1.5, -0.5), 22.0, 40.0, 1013.0, WeatherType.SUNNY)
        )
    }

    override fun getCurrentWeather(location: Pair<Double, Double>): WeatherForecast? {
        val weatherForecastList = forecast[location]
        return if (weatherForecastList == null) {
            null
        } else {
            weatherForecastList[0]
        }
    }

    override fun getTomorrowForecast(locationName: String): List<WeatherForecast> {
        val locationsForName = locationsForName[locationName] ?: listOf()
        val resultList = mutableListOf<WeatherForecast>()
        for (locationForName in locationsForName) {
            val weatherForecastList = forecast[locationForName]
            if (weatherForecastList != null) {
                resultList.add(weatherForecastList[1])
            }
        }
        return resultList
    }

    override fun getWeeklyForecast(location: Pair<Double, Double>): List<WeatherForecast> {
        return forecast[location] ?: listOf()
    }

    override fun getLocationsByCurrentWeatherType(weatherType: WeatherType): List<WeatherForecast> {
        val result = mutableListOf<WeatherForecast>()
        forecast.values.forEach {
            if (it[0].getWeatherType() == weatherType) {
                result.add(it[0])
            }
        }
        return result
    }
}