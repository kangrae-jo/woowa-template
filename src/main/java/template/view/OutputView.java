package template.view;

import template.dto.Result;

public class OutputView {

    public OutputView() {
    }

    public void printError(String msg) {
        System.out.println("[ERROR] " + msg);
    }

    public void printResult(Result result) {
        System.out.println(result.integer() + " " + result.string());
    }

}
