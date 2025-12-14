package oncall.controller;

import oncall.domain.Calendar;
import oncall.domain.WorkerAllocation;
import oncall.view.OutputView;

public class ScheduleManager {

    private final Calendar calendar;

    public ScheduleManager(Calendar calendar) {
        this.calendar = calendar;
    }

    // TODO: Getter 쓰는 구조 개선
    public void makeSchedule(WorkerAllocation workerAllocation) {
        calendar.setNames(workerAllocation.getForWeek(), workerAllocation.getForDayOff());
    }

    public void printSchedules() {
        OutputView.printSchedules(calendar.toString());
    }

}
