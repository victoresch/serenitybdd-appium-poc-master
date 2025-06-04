package ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.time.Duration;

public class Config {


    public static final Target MORE = Target.the("Selecciona la opción mas..")
            .located(By.xpath("//android.widget.TextView[@resource-id=\"org.wikipedia.alpha:id/navigation_bar_item_small_label_view\" and @text=\"More\"]"))
            .waitingForNoMoreThan(Duration.ofSeconds(2));
    public static final Target SETTINGS = Target.the("Selecciona la opción configuración")
            .located(By.xpath("//android.widget.TextView[@text=\"Settings\"]"))
            .waitingForNoMoreThan(Duration.ofSeconds(2));
    public static final Target WIKIPEDIA_LANGUAGES = Target.the("Selecciona la opción lenguages de wikipedia")
            .located(By.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Wikipedia languages\"]"))
            .waitingForNoMoreThan(Duration.ofSeconds(2));
    public static final Target EXPLORE_FEED = Target.the("Selecciona la opción explore feed")
            .located(By.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Explore feed\"]"))
            .waitingForNoMoreThan(Duration.ofSeconds(10));
    public static final Target MORE_OPTIONS = Target.the("Selecciona mas opciones")
            .located(By.xpath("//android.widget.ImageView[@content-desc=\"More options\"]"))
            .waitingForNoMoreThan(Duration.ofSeconds(2));
    public static final Target HIDE_ALL = Target.the("Selecciona ocultar todas")
            .located(By.xpath("//android.widget.TextView[@resource-id=\"org.wikipedia.alpha:id/title\" and @text=\"Hide all\"]"))
            .waitingForNoMoreThan(Duration.ofSeconds(2));
    public static final Target BTN_CUSTOMIZE = Target.the("Botón para personalizar el feed")
            .located(By.xpath("//android.widget.Button[@resource-id=\"org.wikipedia.alpha:id/view_announcement_action_positive\"]"))
            .waitingForNoMoreThan(Duration.ofSeconds(2));




}


