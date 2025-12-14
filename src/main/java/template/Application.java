package template;


import camp.nextstep.edu.missionutils.Console;
import template.config.AppConfig;
import template.controller.Controller;

public class Application {

    public static void main(String[] args) {
        try {
            AppConfig appConfig = new AppConfig();
            Controller controller = appConfig.controller();
            controller.run();
        } finally {
            Console.close();
        }
    }

}
