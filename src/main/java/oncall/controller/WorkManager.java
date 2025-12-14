package oncall.controller;

import oncall.domain.Calendar;
import oncall.domain.DayInfo;
import oncall.domain.WorkerAllocation;
import oncall.domain.WorkerNames;
import oncall.view.InputView;
import oncall.view.OutputView;

public class WorkManager {

    public Calendar makeCalendar() {
        while (true) {
            try {
                String startMonthAndWeek = InputView.readStartMonthAndWeek();
                DayInfo startDay = new DayInfo(startMonthAndWeek, "1");
                return new Calendar(startDay);
            } catch (Exception e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    public WorkerAllocation getWorkerAllocation() {
        while (true) {
            try {
                WorkerNames forWeek = getWorkerNames("평일");     // 평일 근무자
                WorkerNames forDayOff = getWorkerNames("휴일");   // 휴일 근무자
                return new WorkerAllocation(forWeek, forDayOff);
            } catch (Exception e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private WorkerNames getWorkerNames(String type) {
        String workerNames = InputView.readWorkerNames(type);

        return new WorkerNames(workerNames);
    }

}
