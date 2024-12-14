package oncall;

import java.util.LinkedList;
import java.util.List;

public class DevelopmentManager {

    private final Month month;
    private final Workers workers;

    public DevelopmentManager(Month month, Workers workers) {
        this.month = month;
        this.workers = workers;
    }

    public List<String> getMonthlyWorkOrders() {
        List<String> monthlyWorkOrders = new LinkedList<>();
        String latestWorker = "";
        for (DayWithDayOfWeek day : month.getDays()) {
            if (Month.DAY_OF_WEEK_IN_WEEKEND.contains(day.getDayOfWeek()) || month.getHolidays()
                    .contains(day.getDay())) {
                Worker worker = determineWeekendWorker(latestWorker);
                latestWorker = worker.getName();
                worker.work();
            }
            if (Month.DAY_OF_WEEKDAY_IN_WEEKEND.contains(day.getDayOfWeek()) && !month.getHolidays()
                    .contains(day.getDay())) {
                Worker worker = determineWeekDayWorker(latestWorker);
                latestWorker = worker.getName();
                worker.work();
            }
            monthlyWorkOrders.add(latestWorker);
        }
        return monthlyWorkOrders;
    }

    private Worker determineWeekDayWorker(String latestWorker) {
        List<Worker> minimumWorkers = workers.getMinimumWeekDayWorkers();
        if (minimumWorkers.get(0).getName().equals(latestWorker)) {
            return minimumWorkers.get(1);
        }
        return minimumWorkers.get(0);
    }

    private Worker determineWeekendWorker(String latestWorker) {
        List<Worker> minimumWorkers = workers.getMinimumWeekendWorkers();
        if (minimumWorkers.get(0).getName().equals(latestWorker)) {
            return minimumWorkers.get(1);
        }
        return minimumWorkers.get(0);
    }


}
