package oncall.domain;

public class DayInfo {

    private final Month month;  // 월
    private final Day day;      // 일
    private final Week week;    // 요일
    private String name = null; // 당번

    public DayInfo(String monthAndWeek, String day) {
        String[] split = splitMonthAndWeek(monthAndWeek);
        this.month = new Month(split[0]);
        this.day = new Day(day);
        this.week = Week.fromKorean(split[1]);
    }

    private DayInfo(Month month, Day day, Week week) {
        this.month = month;
        this.day = day;
        this.week = week;
    }

    public int size() {
        return month.getEndOfMonth();
    }

    public DayInfo next() {
        return new DayInfo(month, day.next(), week.next());
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isWeekend() {
        return week.isWeekend();
    }

    public boolean isHoliday() {
        return Holiday.isHoliday(month, day);
    }

    @Override
    public String toString() {
        return month.toString() + " "
                + day.toString() + " "
                + week.toString() + (isHoliday() ? "(휴일) " : " ")
                + name + "\n";
    }

    private String[] splitMonthAndWeek(String monthAndWeek) {
        try {
            String[] split = monthAndWeek.split(",");
            if (split.length == 2) {
                return split;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
    }

}
