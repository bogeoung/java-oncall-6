package oncall;

import java.util.ArrayList;
import java.util.List;
import view.InputView;
import view.OutputView;

public class Application {

    private static Days holidays = new Days(new ArrayList<>(List.of(
//            new Day(1, 1),
//            new Day(3, 1),
//            new Day(5, 5),
//            new Day(6, 6),
//            new Day(8, 15),
//            new Day(10, 3),
//            new Day(10, 9),
//            new Day(12, 5)
            Day.of(1, 1),
            Day.of(3, 1),
            Day.of(5, 5),
            Day.of(6, 6),
            Day.of(8, 15),
            Day.of(10, 3),
            Day.of(10, 9),
            Day.of(12, 25)
    )
    ));

    public static void main(String[] args) {
        Month month = generateMonth();
        Workers workers = getWorkerOrder();
        DevelopmentManager developmentManager = new DevelopmentManager(month, workers);
        List<String> MonthWorkOrders = developmentManager.getMonthlyWorkOrders();
        OutputView printResult(MonthWorkOrders);

    }

    private static Month generateMonth() {
        int month = 0;
        String startDayOfMonth = "";
        while (true) {
            String inputMonthAndStartDayOfWeek = InputView.getMonthAndStartDayOfWeek();
            List<String> inputs = Util.splitInputWithSeparator(inputMonthAndStartDayOfWeek, ",");
            if (inputs.size() < 2) {
                continue;
            }
            String monthInput = inputs.get(0);
            String dayOfWeek = inputs.get(1);

            if (InputValidator.validateMonthAndDayOfWeek(monthInput, dayOfWeek)) {
                month = Integer.parseInt(monthInput);
                startDayOfMonth = dayOfWeek;
            }
            break;
        }

        return new Month(month, startDayOfMonth, holidays.getDaysOfMonth(month));
    }

    private static Workers getWorkerOrder() {
        String weekDayWorkOrder = "";
        String weekendWorkOrder = "";

        while (true) {
            weekDayWorkOrder = InputView.getWeekDayWorkList();
            if (InputValidator.isWeekDayWorkersNotValid(weekDayWorkOrder)) {
                continue;
            }
            weekendWorkOrder = InputView.getWeekendWorkList();
            if (!InputValidator.validateWeekendWorkOrders(weekendWorkOrder, weekDayWorkOrder)) {
                continue;
            }
            break;
        }
        return new Workers(Util.splitInputWithSeparator(weekDayWorkOrder, ","),
                Util.splitInputWithSeparator(weekendWorkOrder, ","));
    }
}
