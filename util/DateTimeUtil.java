package util;

import java.time.LocalDateTime;

public class DateTimeUtil {

    private DateTimeUtil() {
    }

    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }
}
