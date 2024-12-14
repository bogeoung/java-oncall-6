package oncall;

public class DayWithDayOfWeek {
    private final Day day;
    private final String dayOfWeek;

    private DayWithDayOfWeek(Day day, String dayOfWeek) {
        this.day = day;
        this.dayOfWeek = dayOfWeek;
    }

    public static DayWithDayOfWeek of(Day day,  String dayOfWeek) {
        return new DayWithDayOfWeek(day, dayOfWeek);
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public Day getDay() {
        return day;
    }
}
