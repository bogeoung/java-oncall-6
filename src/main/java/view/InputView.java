package view;

import camp.nextstep.edu.missionutils.Console;
import oncall.Message;

public class InputView {

    public static String getMonthAndStartDayOfWeek() {
        System.out.printf(Message.GET_MONTH_AND_START_DAY.getContent());
        return getLine();
    }

    public static String getWeekDayWorkList() {
        System.out.printf(Message.GET_WEEK_DAY_LIST.getContent());
        return getLine();
    }

    public static String getWeekendWorkList() {
        System.out.printf(Message.GET_WEEKEND_LIST.getContent());
        return getLine();
    }

    private static String getLine() {
        return Console.readLine();
    }
}
