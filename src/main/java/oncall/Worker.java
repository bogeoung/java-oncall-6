package oncall;

public class Worker {

    private final String name;
    private int workDay;

    public Worker(String name, int workDay) {
        this.name = name;
        this.workDay = workDay;
    }

    public String getName() {
        return name;
    }

    public int getWorkDay() {
        return workDay;
    }

    public void work() {
        this.workDay += 1;
    }
}
