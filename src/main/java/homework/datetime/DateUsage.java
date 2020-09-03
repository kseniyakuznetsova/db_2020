package homework.datetime;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateUsage {


    public static Date convert(LocalDate date) {
        // todo finish this
        return Date.from(date.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }

    public static LocalDateTime convert(Date date) {
        // todo finish this
        return  date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    // 1981/02/30&18:20
    public static long daysBetween(String firstDate, String lastDate) {
        //JSR 310
        //todo finish this
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd&HH:mm");
        LocalDate firstLocalDate = LocalDate.parse(firstDate, formatter);
        LocalDate lastLocalDate = LocalDate.parse(lastDate, formatter);

        return ChronoUnit.DAYS.between(firstLocalDate, lastLocalDate);
    }

    public static void main(String[] args) {
        System.out.println(DateUsage.daysBetween("1981/03/29&18:20", "1982/03/30&18:20"));
        System.out.println(DateUsage.convert(new Date()));
        System.out.println(DateUsage.convert(LocalDate.now()));
    }
}
