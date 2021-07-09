package edu.bjtu.oldcare.oldback.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

    public static Date checkDate(String origin) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

        Date result = null;

        try {
            result = fmt.parse(origin);
        } catch (ParseException e) {
            return null;
        }

        return result;
    }
}
