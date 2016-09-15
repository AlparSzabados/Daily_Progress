package szabados.alpar

import java.time.MonthDay
import java.time.Year
import java.time.format.DateTimeFormatter

class CurrentDate {
    static private final DATE_FORMAT = DateTimeFormatter.ofPattern("MMM-dd")
    static public final TODAY = "${MonthDay.now().format(DATE_FORMAT)}-${Year.now()}"
}