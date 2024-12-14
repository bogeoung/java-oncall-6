package oncall;

import java.util.Arrays;
import java.util.List;

public enum MonthType {
    END_WITH_TWENTY_NINE(List.of(2), 29),
    END_WITH_THIRTY(List.of(4, 6, 9, 11), 30),
    END_WITH_THIRTY_ONE(List.of(1, 3, 5, 7, 8, 10, 12), 31);

    private final List<Integer> months;
    private final int lastDay;

    MonthType(List<Integer> months, int lastDay) {
        this.months = months;
        this.lastDay = lastDay;
    }

    public static MonthType getType(int month) {
        return Arrays.stream(values()).filter(type -> type.months.contains(month)).findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INPUT_NOT_VALID.getContent()));
    }

    public int getLastDay() {
        return lastDay;
    }
}
