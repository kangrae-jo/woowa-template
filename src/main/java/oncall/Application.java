package oncall;

import oncall.controller.ScheduleManager;
import oncall.controller.WorkManager;
import oncall.domain.Calendar;
import oncall.domain.WorkerAllocation;


public class Application {

    public static void main(String[] args) {
        WorkManager workManager = new WorkManager();
        Calendar calendar = workManager.makeCalendar();
        WorkerAllocation workerAllocation = workManager.getWorkerAllocation();

        ScheduleManager scheduleManager = new ScheduleManager(calendar);
        scheduleManager.makeSchedule(workerAllocation);

        scheduleManager.printSchedules();
    }

}
