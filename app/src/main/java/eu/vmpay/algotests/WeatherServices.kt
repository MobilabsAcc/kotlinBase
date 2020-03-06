package eu.vmpay.algotests

class WeatherServices(
    private val dataWeather: HashMap<String, MutableList<WeatherForecasts>>
) : WeatherService {

    override fun getCurrentWeather(location: Pair<Double, Double>): WeatherForecasts = dataWeather["FRIDAY"]!![0]


    override fun getTomorrowForecast(locationName: String): List<WeatherForecasts> {

        val tomorrowWeather = dataWeather["SATURDAY"]
        val tomorrowForecast = mutableListOf<WeatherForecasts>()
        tomorrowWeather!!.forEach {
            if (it.getLocationName() == locationName) tomorrowForecast.add(
                it
            )
        }
        return tomorrowForecast
    }


    override fun getWeeklyForecast(location: Pair<Double, Double>): List<WeatherForecast> {
        val weekForecast = mutableListOf<WeatherForecasts>()
        for (info in dataWeather.values) {
            for (day in info) {
                if (day.getLocation() == location) weekForecast.add(day)
            }
        }
        return weekForecast
    }


    override fun getLocationsByCurrentWeatherType(weatherType: WeatherType): List<WeatherForecast> {
        val currentWeatherTypeList = mutableListOf<WeatherForecasts>()
        for (i in dataWeather.values)
            if (i[0].getWeatherType() == weatherType)
                currentWeatherTypeList.add(i[0])
        return currentWeatherTypeList
    }
}