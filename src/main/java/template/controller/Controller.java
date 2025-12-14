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

            return Domain.of(Integer.parseInt(intAndStr[0]), intAndStr[1]);
        });
    }

    private <T> T retryUntilValid(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.print(e.getMessage());
            }
        }
    }

}
