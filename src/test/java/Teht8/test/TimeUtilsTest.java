package Teht8.test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import timeUtils.TimeUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeUtilsTest {

    @ParameterizedTest(name = "{0} sekuntia on aikana {1}")
    @CsvSource({
        "0, 0:00:00",		 // Testaa nolla sekuntia
        "10, 0:00:10",		 // Testaa 10 sekuntia
        "30, 0:00:30",       // Testaa vain sekuntien tapaus
        "60, 0:01:00",       // Testaa täysi minuutti
        "150, 0:02:30",      // Sekunteja ja minuutteja
        "3600, 1:00:00",     // Täysi tunti
        "3665, 1:01:05",     // Sekunteja, minuutteja ja tunteja
        "3599, 0:59:59",     // Testaa sekunti ennen täyttä tuntia
        "3601, 1:00:01",     // Testaa sekunti täyden tunnin jälkeen
        "31999, 8:53:19",    // Testaa raja lähellä 32 000
        "-1, -1",            // Negatiivinen luku
        "32000, -1",         // Raja-arvo (suurempi tai yhtä suuri kuin 32 000)
        "50000, -1"          // Suuri luku, yli rajan
    })
    public void testSecToTime(int seconds, String expectedTime) {
        String actualTime = TimeUtils.secToTime(seconds);
        assertEquals(expectedTime, actualTime, 
                     "Ajan muuntaminen sekunneista formaattiin hh:mm:ss epäonnistui");
    }
}

