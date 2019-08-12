package Instrument;

import java.io.IOException;
import java.util.Calendar;

public class MyInput {
    public static String input() {
        byte[] b = new byte[50];
        try {
            System.in.read(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(b).trim();
    }

    public static String getDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        String time = year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;
        return time;
    }
}
