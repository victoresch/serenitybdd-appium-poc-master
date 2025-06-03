package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.Tasks;
import org.openqa.selenium.WebDriver;

public class StartTheApp implements Task {

    private final WebDriver device;

    public StartTheApp(WebDriver device) {
        this.device = device;
    }

    public static StartTheApp on(WebDriver device) {
        return Tasks.instrumented(StartTheApp.class, device);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.can(BrowseTheWeb.with(device));
    }
}