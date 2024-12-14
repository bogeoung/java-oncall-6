package oncall;

import java.util.ArrayList;
import java.util.List;

public class Workers {

    private List<Worker> weekDayWorkers;
    private List<Worker> weekendWorkers;

    public Workers(List<String> weekDayWorkersOrders, List<String> weekendWorkersOrders) {
        weekDayWorkers = getWorkers(weekDayWorkersOrders);
        weekendWorkers = getWorkers(weekendWorkersOrders);
    }

    public List<Worker> getWorkers(List<String> workersOrder) {
        List<Worker> workers = new ArrayList<>();
        for (String worker : workersOrder) {
            workers.add(new Worker(worker, 0));
        }
        return workers;
    }

    public List<Worker> getWeekDayWorkers() {
        return weekDayWorkers;
    }

    public List<Worker> getWeekendWorkers() {
        return weekendWorkers;
    }

    public List<Worker> getMinimumWeekDayWorkers() {
        int minimumWeekDayWorkTimes = getMinimumWorkDayTimes(weekDayWorkers);
        return weekDayWorkers.stream().filter(s -> s.getWorkDay() == minimumWeekDayWorkTimes).toList();
    }

    public List<Worker> getMinimumWeekendWorkers() {
        int minimumWeekendWorkTimes = getMinimumWorkDayTimes(weekendWorkers);
        return weekendWorkers.stream().filter(s -> s.getWorkDay() == minimumWeekendWorkTimes).toList();
    }

    private int getMinimumWorkDayTimes(List<Worker> workers) {
        return workers.stream().mapToInt(Worker::getWorkDay).min().getAsInt();
    }
}
