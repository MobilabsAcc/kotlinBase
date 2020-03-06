package eu.vmpay.algotests.oop.Weather

import android.os.Build
import androidx.annotation.RequiresApi
import eu.vmpay.algotests.oop.Weather.Forecast
import eu.vmpay.algotests.oop.Weather.ForecastDetails
import eu.vmpay.algotests.oop.Weather.Location
import eu.vmpay.algotests.oop.Weather.WeatherType
import java.time.LocalDateTime


class ForecastDatabase {

    @RequiresApi(Build.VERSION_CODES.O)
    val forecastList = mutableListOf(
        Forecast(
            Location("Warsaw", Pair(27.0, 37.3)),
            ForecastDetails(
                87.3,
                22.4,
                1100.3,
                WeatherType.CLOUDY
            ),
            LocalDateTime.of(2000, 4, 22, 20, 0)
        ),
        Forecast(
            Location("Warsaw", Pair(27.0, 37.3)),
            ForecastDetails(
                87.3,
                21.4,
                1070.3,
                WeatherType.CLOUDY
            ),
            LocalDateTime.of(2000, 4, 23, 20, 0)
        ),
        Forecast(
            Location("Warsaw", Pair(27.0, 37.3)),
            ForecastDetails(
                47.3,
                32.4,
                1040.3,
                WeatherType.CLOUDY
            ),
            LocalDateTime.of(2000, 4, 24, 20, 0)
        ),
        Forecast(
            Location("Warsaw", Pair(27.0, 37.3)),
            ForecastDetails(
                97.3,
                13.4,
                1300.3,
                WeatherType.CLOUDY
            ),
            LocalDateTime.of(2000, 4, 26, 20, 0)
        ),
        Forecast(
            Location("Warsaw", Pair(27.0, 37.3)),
            ForecastDetails(
                7.3,
                12.4,
                1010.3,
                WeatherType.CLOUDY
            ),
            LocalDateTime.of(2000, 4, 27, 20, 0)
        ),
        Forecast(
            Location("Warsaw", Pair(27.0, 37.3)),
            ForecastDetails(
                87.3,
                22.4,
                1100.3,
                WeatherType.CLOUDY
            ),
            LocalDateTime.of(2000, 4, 1, 20, 0)
        ),
        Forecast(
            Location("Warsaw", Pair(27.0, 37.3)),
            ForecastDetails(
                87.3,
                25.7,
                1070.3,
                WeatherType.CLOUDY
            ),
            LocalDateTime.of(2000, 4, 29, 20, 0)
        ),
        Forecast(
            Location("Warsaw", Pair(27.0, 37.3)),
            ForecastDetails(
                47.3,
                24.6,
                1040.3,
                WeatherType.WINDY
            ),
            LocalDateTime.of(2000, 4, 26, 20, 0)
        ),
        Forecast(
            Location("Warsaw", Pair(27.0, 37.3)),
            ForecastDetails(
                97.3,
                29.4,
                1300.3,
                WeatherType.CLOUDY
            ),
            LocalDateTime.of(2000, 4, 22, 20, 0)
        ),
        Forecast(
            Location("Tokio", Pair(27.0, 37.3)),
            ForecastDetails(
                7.3,
                11.7,
                1010.3,
                WeatherType.SUNNY
            ),
            LocalDateTime.of(2000, 4, 25, 20, 0)
        ),
        Forecast(
            Location("Tokio", Pair(27.0, 37.3)),
            ForecastDetails(
                87.3,
                22.4,
                1100.3,
                WeatherType.RAINY
            ),
            LocalDateTime.of(2000, 4, 23, 20, 0)
        ),
        Forecast(
            Location("Warsaw", Pair(27.0, 37.3)),
            ForecastDetails(
                87.3,
                14.9,
                1070.3,
                WeatherType.WINDY
            ),
            LocalDateTime.of(2000, 4, 22, 20, 0)
        ),
        Forecast(
            Location("Tokio", Pair(12.0, 89.2)),
            ForecastDetails(
                47.3,
                28.6,
                1040.3,
                WeatherType.RAINY
            ),
            LocalDateTime.of(2000, 4, 22, 20, 0)
        ),
        Forecast(
            Location("Tokio", Pair(12.0, 89.2)),
            ForecastDetails(
                47.3,
                28.6,
                1040.3,
                WeatherType.CLOUDY
            ),
            LocalDateTime.of(2000, 4, 24, 20, 0)
        ),
        Forecast(
            Location("Tokio", Pair(12.0, 89.2)),
            ForecastDetails(
                47.3,
                14.5,
                1001.3,
                WeatherType.RAINY
            ),
            LocalDateTime.of(2000, 4, 25, 20, 0)
        ), Forecast(
            Location("Tokio", Pair(12.0, 89.2)),
            ForecastDetails(
                47.3,
                26.9,
                1012.3,
                WeatherType.RAINY
            ),
            LocalDateTime.of(2000, 4, 25, 20, 0)
        ),
        Forecast(
            Location("Tokio", Pair(12.0, 89.2)),
            ForecastDetails(
                47.3,
                26.9,
                1012.3,
                WeatherType.RAINY
            ),
            LocalDateTime.of(2000, 4, 25, 20, 0)
        ), Forecast(
            Location("Tokio", Pair(12.0, 89.2)),
            ForecastDetails(
                47.3,
                26.9,
                1012.3,
                WeatherType.RAINY
            ),
            LocalDateTime.of(2000, 4, 21, 20, 0)
        ), Forecast(
            Location("Tokio", Pair(12.0, 89.2)),
            ForecastDetails(
                47.3,
                26.9,
                1012.3,
                WeatherType.RAINY
            ),
            LocalDateTime.of(2000, 4, 21, 20, 0)
        ), Forecast(
            Location("Tokio", Pair(12.0, 89.2)),
            ForecastDetails(
                47.3,
                25.1,
                1010.3,
                WeatherType.SUNNY
            ),
            LocalDateTime.of(2000, 4, 23, 20, 0)
        ), Forecast(
            Location("Tokio", Pair(12.0, 89.2)),
            ForecastDetails(
                25.9,
                222.4,
                1040.3,
                WeatherType.CLOUDY
            ),
            LocalDateTime.of(2000, 4, 23, 20, 0)
        ), Forecast(
            Location("Tokio", Pair(12.0, 89.2)),
            ForecastDetails(
                25.9,
                222.4,
                1040.3,
                WeatherType.CLOUDY
            ),
            LocalDateTime.of(2000, 4, 23, 20, 0)
        ),
        Forecast(
            Location(
                "Orlando",
                Pair(54.00, 27.3)
            ),
            ForecastDetails(
                87.5,
                42.4,
                1010.3,
                WeatherType.CLOUDY
            ),
            LocalDateTime.of(2000, 4, 25, 20, 0)
        ), Forecast(
            Location(
                "Orlando",
                Pair(54.00, 27.3)
            ),
            ForecastDetails(
                59.8,
                42.4,
                1010.3,
                WeatherType.CLOUDY
            ),
            LocalDateTime.of(2000, 4, 25, 20, 0)
        ), Forecast(
            Location(
                "Orlando",
                Pair(54.00, 27.3)
            ),
            ForecastDetails(
                47.9,
                42.4,
                1010.3,
                WeatherType.CLOUDY
            ),
            LocalDateTime.of(2000, 4, 23, 20, 0)
        ),
        Forecast(
            Location(
                "Orlando",
                Pair(54.00, 27.3)
            ),
            ForecastDetails(
                72.1,
                42.4,
                1010.3,
                WeatherType.SUNNY
            ),
            LocalDateTime.of(2000, 4, 22, 20, 0)
        ),
        Forecast(
            Location(
                "Orlando",
                Pair(54.00, 27.3)
            ),
            ForecastDetails(
                87.5,
                42.4,
                1010.3,
                WeatherType.CLOUDY
            ),
            LocalDateTime.of(2000, 4, 1, 20, 0)
        ), Forecast(
            Location(
                "Orlando",
                Pair(54.00, 27.3)
            ),
            ForecastDetails(
                59.8,
                42.4,
                1010.3,
                WeatherType.CLOUDY
            ),
            LocalDateTime.of(2000, 4, 25, 20, 0)
        ), Forecast(
            Location(
                "Orlando",
                Pair(54.00, 27.3)
            ),
            ForecastDetails(
                47.9,
                42.4,
                1010.3,
                WeatherType.CLOUDY
            ),
            LocalDateTime.of(2000, 4, 3, 20, 0)
        ),
        Forecast(
            Location(
                "Orlando",
                Pair(54.00, 27.3)
            ),
            ForecastDetails(
                72.1,
                42.4,
                1010.3,
                WeatherType.SUNNY
            ),
            LocalDateTime.of(2000, 4, 4, 20, 0)
        ), Forecast(
            Location(
                "Orlando",
                Pair(54.00, 27.3)
            ),
            ForecastDetails(
                87.5,
                42.4,
                1010.3,
                WeatherType.CLOUDY
            ),
            LocalDateTime.of(2000, 4, 27, 20, 0)
        ), Forecast(
            Location(
                "Orlando",
                Pair(54.00, 27.3)
            ),
            ForecastDetails(
                59.8,
                42.4,
                1010.3,
                WeatherType.CLOUDY
            ),
            LocalDateTime.of(2000, 4, 6, 20, 0)
        ), Forecast(
            Location(
                "Orlando",
                Pair(54.00, 27.3)
            ),
            ForecastDetails(
                47.9,
                42.4,
                1010.3,
                WeatherType.CLOUDY
            ),
            LocalDateTime.of(2000, 4, 25, 20, 0)
        ),
        Forecast(
            Location(
                "Orlando",
                Pair(54.00, 27.3)
            ),
            ForecastDetails(
                72.1,
                42.4,
                1010.3,
                WeatherType.SUNNY
            ),
            LocalDateTime.of(2000, 4, 25, 20, 0)
        )

    )








}
