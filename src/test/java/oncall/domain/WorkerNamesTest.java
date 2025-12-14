package oncall.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class WorkerNamesTest {

    @Test
    void 콤마로_구분되지_않는_입력은_오류가난다() {
        String names = "kng.ko.gy.wns.";

        assertThrows(IllegalArgumentException.class, () -> {
            WorkerNames workerNames = new WorkerNames(names);
        });
    }

    @Test
    void 같은_이름을_중복해서_입력하면_오류가난다() {
        String names = "kng,kng,gy,wns";

        assertThrows(IllegalArgumentException.class, () -> {
            WorkerNames workerNames = new WorkerNames(names);
        });
    }

}