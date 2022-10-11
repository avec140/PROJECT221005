import java.util.Calendar;

public class problem6_5 {
    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();

        int hourOfDay = now.get(Calendar.HOUR_OF_DAY);

        if(4<=hourOfDay && hourOfDay<12)
            System.out.println("Good Morning");
        else if(12<=hourOfDay && hourOfDay<18)
            System.out.println("Good Afternoon");
        else if(18<=hourOfDay && hourOfDay<22)
            System.out.println("Good Evening");
        else
            System.out.println("Good Night");
    }
}