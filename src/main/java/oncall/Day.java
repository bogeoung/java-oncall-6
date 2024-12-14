package oncall;

import java.util.Objects;

public class Day {

    private final int month;
    private final int day;

    private Day(int month, int day) {
        this.month = month;
        this.day = day;
    }

    public static Day of(int month, int day) {
        return new Day(month, day);
    }

    public boolean containsInMonth(int month) {
        return this.month == month;
    }

    public int getDay() {
        return day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Day day = (Day) o;
        return month == day.month && this.day == day.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(month, day);
    }
}
