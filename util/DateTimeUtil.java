package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    private DateTimeUtil() {
    }
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }
    public static String formateDate(LocalDateTime date){
        return date.format(formatter);
    }
}
