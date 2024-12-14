package oncall;

import java.util.ArrayList;
import java.util.List;

public class Month {

    public static final List<String> DAY_OF_WEEK_KR = List.of("월", "화", "수", "목", "금", "토", "일");
    public static final List<String> DAY_OF_WEEK_IN_WEEKEND = List.of("토", "일");
    public static final List<String> DAY_OF_WEEKDAY_IN_WEEKEND = List.of("월", "화", "수", "목", "금");

    private final int month;
    private final List<DayWithDayOfWeek> days;
    private List<Day> holidays;


    public Month(int month, String startDayOfWeek, List<Day> holidays) {
        this.month = month;
        this.holidays = new ArrayList<>(holidays);
        int endDay = MonthType.getType(month).getLastDay();
        this.days = getDays(month, endDay, startDayOfWeek);
    }

    private List<DayWithDayOfWeek> getDays(int month, int endDay, String startDayOfWeek) {
        final List<DayWithDayOfWeek> monthDays = new ArrayList<>();
        int startDayOfWeekIndex = DAY_OF_WEEK_KR.indexOf(startDayOfWeek);

        for (int day = 1; day <= endDay; day++) {
            final Day currentDay = Day.of(month, day);
//            final Day currentDay = new Day(month, day);
            final String dayOfWeek = getDayOfWeek(startDayOfWeekIndex, day);
            final DayWithDayOfWeek currentDayWithDayOfWeek = DayWithDayOfWeek.of(currentDay, dayOfWeek);

            monthDays.add(currentDayWithDayOfWeek);

            if (DAY_OF_WEEK_IN_WEEKEND.contains(dayOfWeek)) {
                holidays.add(currentDayWithDayOfWeek.getDay());
            }
        }
        return monthDays;
    }

    private String getDayOfWeek(int startDayIndex, int day) {
        int dayOfWeekIndex = (startDayIndex + day - 1) % DAY_OF_WEEK_KR.size();
        return DAY_OF_WEEK_KR.get(dayOfWeekIndex);
    }

    public List<DayWithDayOfWeek> getDays() {
        return days;
    }

    public int getMonth() {
        return month;
    }

    public List<Day> getHolidays() {
        return holidays;
    }
}
