package oncall.domain;

public enum Holiday {

    DAY_0101("1", "1"),
    DAY_0301("3", "1"),
    DAY_0505("5", "5"),
    DAY_0606("6", "6"),
    DAY_0815("8", "15"),
    DAY_1003("10", "3"),
    DAY_1009("10", "9"),
    DAY_1225("12", "25");

    private final String month;
    private final String day;

    Holiday(String month, String day) {
        this.month = month;
        this.day = day;
    }

    public static boolean isHoliday(Month month, Day day) {
        boolean flag = false;
        for (Holiday holiday : Holiday.values()) {
            if (holiday.isEqualTo(month, day)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    private boolean isEqualTo(Month month, Day day) {
        return month.isEqualTo(this.month) && day.isEqualTo(this.day);
    }

}
