package ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.time.Duration;

public class OnboardingWiki {


    public static final Target SKIP = Target.the("Omitir onboarging ")
            .located(By.xpath("//android.widget.Button[@resource-id=\"org.wikipedia.alpha:id/fragment_onboarding_skip_button\"]"))
            .waitingForNoMoreThan(Duration.ofSeconds(2));
    public static final Target ADD_OR_EDIT_LANGUAGE = Target.the("Agregar o editar idioma ")
            .located(By.xpath("//android.widget.Button[@resource-id=\"org.wikipedia.alpha:id/addLanguageButton\"]"))
            .waitingForNoMoreThan(Duration.ofSeconds(2));
    public static final Target ADD_LANGUAGES = Target.the("Agregar idioma ")
            .located(By.xpath("//android.widget.TextView[@resource-id=\"org.wikipedia.alpha:id/wiki_language_title\" and @text=\"Add language\"]"))
            .waitingForNoMoreThan(Duration.ofSeconds(2));
    public static final Target SELECT_LANGUAGE = Target.the("Seleccionar idioma ")
            .locatedBy(" //android.widget.TextView[contains(@text,'{0}')]")
            .waitingForNoMoreThan(Duration.ofSeconds(2));
    public static final Target YOUR_LANGUAGES = Target.the("Tus lenguajes ")
            .located(By.xpath("//android.widget.TextView[@resource-id=\"org.wikipedia.alpha:id/section_header_text\"]"))
            .waitingForNoMoreThan(Duration.ofSeconds(2));
    public static final Target BACK = Target.the("Botón regresar ")
            .located(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"))
            .waitingForNoMoreThan(Duration.ofSeconds(2));
    public static final Target LANGUAGES_ON_ONBOARDING = Target.the("Botón regresar ")
            .locatedBy("//android.widget.TextView[@resource-id=\"org.wikipedia.alpha:id/option_label\" and @text=\"2.\t\tEspañol\"]");



}


