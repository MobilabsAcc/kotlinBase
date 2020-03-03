package eu.vmpay.algotests

fun main(){

    val weather = WeatherServiceClass()

    print(weather.getCurrentWeather(Pair(52.13, 21.0)))
    println()
    print(weather.getTomorrowForecast("Warszawa"))
    println()
    print(weather.getWeeklyForecast(Pair(52.13, 21.0)))
    println()
    print(weather.getLocationsByCurrentWeatherType(WeatherType.SNOWY))
}

class WeatherServiceClass : WeatherService {

    var weatherDatabase = HashMap<String, MutableList<WeatherForecastClass>>()

    init {
         weatherDatabase = doResearch()
    }

    override fun getCurrentWeather(location: Pair<Double, Double>): WeatherForecastClass? {

        val currentDayWeather = weatherDatabase.get("06/03/2020")

        var weatherForecastClass : WeatherForecastClass? = null

       currentDayWeather!!.forEach { if (it.getLocation() == location) weatherForecastClass = it}


        return weatherForecastClass
    }

    override fun getTomorrowForecast(locationName: String): List<WeatherForecastClass> {

        val tommorowWeather = weatherDatabase.get("07/03/2020")


        var list = ArrayList<WeatherForecastClass>()

        tommorowWeather!!.forEach { if(it.name.equals(locationName)) list.add(it)}

        return list
    }

    override fun getWeeklyForecast(location: Pair<Double, Double>): List<WeatherForecastClass> {

        val weeklyForecast = ArrayList<WeatherForecastClass>()


        for(i in weatherDatabase){

            val todaysWeather = i.value

            for (j in todaysWeather){
                if (j.getLocation() == location)    weeklyForecast.add(j)
            }
        }
        return weeklyForecast
    }

    override fun getLocationsByCurrentWeatherType(weatherType: WeatherType): List<WeatherForecast> {

        val currentWeatherType = ArrayList<WeatherForecastClass>()


        for(i in weatherDatabase){

            val todaysWeather = i.value

            for (j in todaysWeather){
                if (j.getWeatherType().equals(weatherType))    currentWeatherType.add(j)
            }
        }
        return currentWeatherType
    }

    fun doResearch() : HashMap<String, MutableList<WeatherForecastClass>> {

        val weatcherDatabase = HashMap<String, MutableList<WeatherForecastClass>>()


        weatcherDatabase.put("06/03/2020", mutableListOf(
            WeatherForecastClass("Warszawa", Pair(52.13, 21.0), 8.0, 0.85, 1002.0, WeatherType.CLOUDY),
            WeatherForecastClass("Poznan", Pair(52.25, 16.55), 6.0, 0.91, 997.0, WeatherType.RAINY),
            WeatherForecastClass("Gdansk", Pair(54.22, 18.38), 4.0, 0.89, 1000.0, WeatherType.RAINY),
            WeatherForecastClass("Warszawa", Pair(1.0, 1.0), 48.0, 1.0, 800.0, WeatherType.SUNNY)))

        weatcherDatabase.put("07/03/2020", mutableListOf(
            WeatherForecastClass("Warszawa", Pair(52.13, 21.0), 20.0, 0.85, 1002.0, WeatherType.CLOUDY),
            WeatherForecastClass("Poznan", Pair(52.25, 16.55), 6.0, 0.91, 997.0, WeatherType.CLOUDY),
            WeatherForecastClass("Gdansk", Pair(54.22, 18.38), 4.0, 0.89, 1000.0, WeatherType.CLOUDY),
            WeatherForecastClass("Warszawa", Pair(1.0, 1.0), 38.0, 1.0, 800.0, WeatherType.CLOUDY)))

        weatcherDatabase.put("08/03/2020", mutableListOf(
            WeatherForecastClass("Warszawa", Pair(52.13, 21.0), 20.0, 0.85, 1002.0, WeatherType.SUNNY),
            WeatherForecastClass("Poznan", Pair(52.25, 16.55), 30.0, 0.91, 997.0, WeatherType.SUNNY),
            WeatherForecastClass("Gdansk", Pair(54.22, 18.38), 28.0, 0.89, 1000.0, WeatherType.SUNNY),
            WeatherForecastClass("Warszawa", Pair(1.0, 1.0), 48.0, 1.0, 800.0, WeatherType.SUNNY)))

        weatcherDatabase.put("09/03/2020", mutableListOf(
            WeatherForecastClass("Warszawa", Pair(52.13, 21.0), 20.0, 0.85, 1002.0, WeatherType.SUNNY),
            WeatherForecastClass("Poznan", Pair(52.25, 16.55), 30.0, 0.91, 997.0, WeatherType.SUNNY),
            WeatherForecastClass("Gdansk", Pair(54.22, 18.38), 28.0, 0.89, 1000.0, WeatherType.SUNNY),
            WeatherForecastClass("Warszawa", Pair(1.0, 1.0), 48.0, 1.0, 800.0, WeatherType.SUNNY)))

        weatcherDatabase.put("10/03/2020", mutableListOf(
            WeatherForecastClass("Warszawa", Pair(52.13, 21.0), 20.0, 0.85, 1002.0, WeatherType.SUNNY),
            WeatherForecastClass("Poznan", Pair(52.25, 16.55), 30.0, 0.91, 997.0, WeatherType.SUNNY),
            WeatherForecastClass("Gdansk", Pair(54.22, 18.38), 28.0, 0.89, 1000.0, WeatherType.SUNNY),
            WeatherForecastClass("Warszawa", Pair(1.0, 1.0), 48.0, 1.0, 800.0, WeatherType.SUNNY)))

        weatcherDatabase.put("11/03/2020", mutableListOf(
            WeatherForecastClass("Warszawa", Pair(52.13, 21.0), 20.0, 0.85, 1002.0, WeatherType.SUNNY),
            WeatherForecastClass("Poznan", Pair(52.25, 16.55), 30.0, 0.91, 997.0, WeatherType.SUNNY),
            WeatherForecastClass("Gdansk", Pair(54.22, 18.38), 28.0, 0.89, 1000.0, WeatherType.SUNNY),
            WeatherForecastClass("Warszawa", Pair(1.0, 1.0), 48.0, 1.0, 800.0, WeatherType.SUNNY)))

        weatcherDatabase.put("12/03/2020", mutableListOf(
            WeatherForecastClass("Warszawa", Pair(52.13, 21.0), 20.0, 0.85, 1002.0, WeatherType.SUNNY),
            WeatherForecastClass("Poznan", Pair(52.25, 16.55), 30.0, 0.91, 997.0, WeatherType.SUNNY),
            WeatherForecastClass("Gdansk", Pair(54.22, 18.38), 28.0, 0.89, 1000.0, WeatherType.SNOWY),
            WeatherForecastClass("Warszawa", Pair(1.0, 1.0), 48.0, 1.0, 800.0, WeatherType.SUNNY)))

        return weatcherDatabase
    }

}