package oncall.domain;

import java.util.ArrayList;
import java.util.List;

public class Calendar {

    private final List<DayInfo> calendar;

    public Calendar(DayInfo start) {
        int endOfMonth = start.size();
        this.calendar = new ArrayList<>(endOfMonth);

        DayInfo cur = start;
        for (int i = 1; i <= endOfMonth; i++) {
            calendar.add(cur);
            cur = cur.next();
        }
    }

    // TODO: 틀린 로직 변경
    public void setNames(WorkerNames forWeek, WorkerNames forDayOff) {
        int weekIndex = 0, dayOffIndex = 0;
        for (DayInfo dayInfo : calendar) {
            if (dayInfo.isWeekend() || dayInfo.isHoliday()) {
                dayInfo.setName(forDayOff.get(dayOffIndex++));
            }
            dayOffIndex %= forDayOff.size();
            if (!dayInfo.isWeekend()) {
                dayInfo.setName(forWeek.get(weekIndex++));
            }
            weekIndex %= forWeek.size();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (DayInfo dayInfo : calendar) {
            sb.append(dayInfo.toString());
        }
        return sb.toString();
    }

}
