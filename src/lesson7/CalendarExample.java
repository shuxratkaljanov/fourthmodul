package lesson7;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarExample {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        //System.out.println(calendar);
//        Date date = calendar.getTime();
//        System.out.println(date);
//        System.out.println(calendar.getWeeksInWeekYear());
//        System.out.println(calendar.getWeekYear());
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        Date date = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("y/MM/dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println("format = " + format);
        System.out.println(date);
    }
}
