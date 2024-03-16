package lesson6;
import java.util.Calendar;

public class Calendar2 {
    public static void main(String[] args) {
    Calendar calendar = Calendar.getInstance();
        System.out.println("At present Calendar's Year: "+ calendar.get(Calendar.YEAR));
        System.out.println("At present Calendar's Day: "+ calendar.get(Calendar.DATE));
    }
}
