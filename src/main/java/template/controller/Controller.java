package template.controller;

import java.util.function.Supplier;
import template.domain.Domain;
import template.view.InputView;
import template.view.OutputView;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Domain domain = readDomain();
    }

    private Domain readDomain() {
        return retryUntilValid(() -> {
            String input = inputView.read();
            String[] intAndStr = input.split(",");

            if (intAndStr.length != 2) {
                throw new IllegalArgumentException("입력은 '숫자,문자열' 형식이어야 합니다.");
            }

            return Domain.of(Integer.parseInt(intAndStr[0].trim()), intAndStr[1].trim());
        });
    }

    private <T> T retryUntilValid(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (Exception e) {
                outputView.printError("잘못된 형식을 입력했습니다.");
            }
        }
    }

}
