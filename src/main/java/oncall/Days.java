package oncall;

import java.util.ArrayList;
import java.util.List;


public class Days {

    private List<Day> days;

    public Days(List<Day> days) {
        this.days = new ArrayList<>(days);
    }

    public List<Day> getDaysOfMonth(final int month) {
        return days.stream().filter(day -> day.containsInMonth(month)).toList();
    }

    public void add(Day day) {
        days.add(day);
    }
}


