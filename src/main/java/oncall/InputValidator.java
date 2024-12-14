package oncall;

import java.util.List;
import java.util.regex.Pattern;
import org.junit.platform.commons.util.StringUtils;
import view.OutputView;

public class InputValidator {

    public static final int MIN_MONTH = 1;
    public static final int MAX_MONTH = 12;
    private static final Pattern NAME_REGEX = Pattern.compile("^[ㄱ-ㅎ가-힣]*$");

    public static boolean validateMonthAndDayOfWeek(String monthInput, String startDayOfWeek) {
        try {
            int month = Integer.parseInt(monthInput);
            return validateMonth(month) && validateDayOfWeek(startDayOfWeek);
        } catch (NumberFormatException e) {
            OutputView.inputIsNotValid();
            return false;
        }
    }

    private static boolean validateMonth(Integer month) {
        return MIN_MONTH <= month && month <= MAX_MONTH;
    }

    private static boolean validateDayOfWeek(String dayOfWeek) {
        return Month.DAY_OF_WEEK_KR.contains(dayOfWeek);
    }

    public static boolean isWeekDayWorkersNotValid(String workers) {
        if (StringUtils.isBlank(workers)) {
            return false;
        }

        final List<String> weekDayWorkOrders = Util.splitInputWithSeparator(workers, ",");
        if (isValidWorkers(weekDayWorkOrders)) {
            return false;
        }

        OutputView.inputIsNotValid();
        return true;
    }

    private static boolean isValidWorkers(List<String> weekDayWorkOrders) {
        return isDuplicateNameExist(weekDayWorkOrders)
                && validateNameOfPerson(weekDayWorkOrders)
                && isNumbersOfWorkerValid(weekDayWorkOrders.size());
    }

    private static boolean isDuplicateNameExist(List<String> weekDayWorkOrders) {
        for (String workerName : weekDayWorkOrders) {
            if (weekDayWorkOrders.indexOf(workerName) != weekDayWorkOrders.lastIndexOf(workerName)) {
                return false;
            }
        }
        return true;
    }

    private static boolean validateNameOfPerson(List<String> weekDayWorkOrders) {
        return weekDayWorkOrders.stream()
                .noneMatch(workerName -> StringUtils.isBlank(workerName) && workerName.length() > 4
                        && NAME_REGEX.matcher(workerName).matches());
    }

    private static boolean isNumbersOfWorkerValid(int numbersOfWorker) {
        return 5 <= numbersOfWorker && numbersOfWorker <= 35;
    }


    public static boolean validateWeekendWorkOrders(String weekendWorkOrder, String weekDayWorkOrder) {
        List<String> weekendWorkOrders = Util.splitInputWithSeparator(weekendWorkOrder, ",");
        List<String> weekDayWorkOrders = Util.splitInputWithSeparator(weekDayWorkOrder, ",");
        if (isWeekDayWorkersNotValid(weekendWorkOrder)) {
            OutputView.inputIsNotValid();
            return false;
        }
        if (!validateNamePair(weekendWorkOrders, weekDayWorkOrders)) {
            OutputView.inputIsNotValid();
            return false;
        }
        return true;

    }

    private static boolean validateNamePair(List<String> weekendWorkOrders, List<String> weekDayWorkOrders) {
        for (String workerName : weekendWorkOrders) {
            if (!weekDayWorkOrders.contains(workerName)) {
                return false;
            }
        }
        for (String workerName : weekDayWorkOrders) {
            if (!weekendWorkOrders.contains(workerName)) {
                return false;
            }
        }
        return true;
    }
}
