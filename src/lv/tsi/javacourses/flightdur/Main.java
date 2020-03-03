package lv.tsi.javacourses.flightdur;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {
    private static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm", Locale.ENGLISH);

    public static void main(String[] args) {
        /*for (var z : ZoneId.getAvailableZoneIds()) {
            System.out.println(z);
        }*/

        printFlightInfo("28-Feb-2020 23:55", "Europe/London", "01-Mar-2020 12:03", "Australia/Sydney");
        printFlightInfo("28-Feb-2019 20:33", "Europe/London", "02-Mar-2019 07:19", "Australia/Sydney");
    }

    private static void printFlightInfo(String depTime, String depZone, String arrTime, String arrZone) {
        var depZoneTime = createZonedDateTime(depTime, depZone);
        var arrZoneTime = createZonedDateTime(arrTime, arrZone);
        Duration dur = Duration.between(depZoneTime, arrZoneTime);
        System.out.println(dur);
    }

    private static ZonedDateTime createZonedDateTime(String strTime, String strZone) {
        LocalDateTime dt = LocalDateTime.parse(strTime, format);
        ZoneId z = ZoneId.of(strZone);
        return ZonedDateTime.of(dt, z);
    }
}
