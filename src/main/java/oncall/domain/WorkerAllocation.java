package oncall.domain;

public class WorkerAllocation {

    private final WorkerNames forWeek;
    private final WorkerNames forDayOff;

    public WorkerAllocation(WorkerNames forWeek, WorkerNames forDayOff) {
        validate(forWeek, forDayOff);
        this.forWeek = forWeek;
        this.forDayOff = forDayOff;
    }

    public WorkerNames getForWeek() {
        return forWeek;
    }

    public WorkerNames getForDayOff() {
        return forDayOff;
    }

    private void validate(WorkerNames forWeek, WorkerNames forDayOff) {
        if (forWeek.size() != forDayOff.size()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
        if (!forWeek.hasSameWorkers(forDayOff)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }

}
