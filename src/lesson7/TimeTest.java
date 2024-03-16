package lesson7;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class TimeTest {
    public static void main(String[] args) {
        //ZoneId.getAvailableZoneIds().forEach(System.out::println);
        //System.out.println(new Date(0));
//        ZonedDateTime zonedDateTime = ZonedDateTime.now();
//        System.out.println(zonedDateTime);
        //ZonedDateTime now = ZonedDateTime.now(ZoneId.of("America/Santo_Domingo"));
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Pacific/Yap"));
        System.out.println(now);

    }
}
