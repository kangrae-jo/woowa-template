package oncall.domain;

public class Day {

    private final String day;

    public Day(String day) {
        this.day = day;
    }

    public Day next() {
        return new Day(String.valueOf(Integer.parseInt(day) + 1));
    }

    public boolean isEqualTo(String day) {
        return this.day.equals(day);
    }

    @Override
    public String toString() {
        return day + "일";
    }

}
