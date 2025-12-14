package template.controller;

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
        Domain domain = Domain.of(1, "temp");
    }

}
