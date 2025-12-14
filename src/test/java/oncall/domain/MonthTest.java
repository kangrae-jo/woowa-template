package oncall.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class MonthTest {

    @Test
    void 숫자가_아닌_월을_입력하면_오류가_난다() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Month("숫자 아닌 월");
        });
    }

    @Test
    void 숫자_1부터_12까지가_아닌_월을_입력하면_오류가_난다() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Month("0");
        });
    }

}