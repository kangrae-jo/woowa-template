package oncall.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class DayInfoTest {

    @Test
    void 콤마로_월과_요일을_입력하지않으면_오류가_난다() {
        String input = "1/월";

        assertThrows(IllegalArgumentException.class, () -> {
            DayInfo info = new DayInfo(input, "1");
        });
    }

    @Test
    void 올바른_월과_요일을_입력하지않으면_오류가_난다() {
        String input = "0,뷁";

        assertThrows(IllegalArgumentException.class, () -> {
            DayInfo info = new DayInfo(input, "1");
        });
    }

}