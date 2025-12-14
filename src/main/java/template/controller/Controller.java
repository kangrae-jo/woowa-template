package template.controller;

import java.util.function.Supplier;
import template.domain.Domain;
import template.dto.Result;
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
        outputView.printResult(Result.from(domain));
    }

    private Domain readDomain() {
        return retryUntilValid(() -> {
            String input = inputView.read();
            return Domain.from(input);
        });
    }

    private <T> T retryUntilValid(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (Exception e) {
                outputView.printError(e.getMessage());
            }
        }
    }

}
