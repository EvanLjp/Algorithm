package CSP.CCF_201712;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by asus on 2018/3/1.
 */
public class Crontab {
    private static SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddHHmm");

    public static void main(String[] args) throws ParseException {
        Scanner scanner=new Scanner(System.in);
        int lines = scanner.nextInt();
        String startTime = scanner.next();
        String endTime = scanner.next();

        for (int i = 0; i < lines; i++) {
            String next = scanner.next();
            String[] split = next.split(" ");

        }
        Calendar calendar=Calendar.getInstance();
        Date start = simpleDateFormat.parse(startTime);
        Date end = simpleDateFormat.parse(endTime);
        while (start.getTime()<end.getTime()){
            calendar.setTime(start);
            int minute=calendar.get(Calendar.MINUTE);
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
            int month = calendar.get(Calendar.MONTH);
            int week = calendar.get(Calendar.DAY_OF_WEEK);
            

        }


        
    }

}
