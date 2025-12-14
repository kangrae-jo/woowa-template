package template;


import template.config.AppConfig;
import template.controller.Controller;

public class Application {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        Controller controller = appConfig.controller();
        controller.run();
    }

}
