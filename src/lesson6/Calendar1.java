package lesson6;

import java.util.Calendar;

public class Calendar1 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println("The current date is: " + calendar.getTime());
        calendar.add(Calendar.DATE, -15);
        System.out.println("15 days ago: " + calendar.getTime());
        calendar.add(Calendar.MONTH, 4);
        System.out.println("4 month late: " + calendar.getTime());
        calendar.add(Calendar.YEAR, 2);
    System.out.println("2 years later: " + calendar.getTime());
    }
}
