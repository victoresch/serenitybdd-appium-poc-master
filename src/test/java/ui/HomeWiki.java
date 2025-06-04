package ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.time.Duration;

public class HomeWiki {


    public static final Target CLOSE_INFO = Target.the("Cerrar info")
            .located(By.xpath("//android.widget.ImageView[@content-desc=\"Close\"]"))
            .waitingForNoMoreThan(Duration.ofSeconds(2));
    public static final Target SEARCH_WIKIPEDIA = Target.the("Selecciona el buscador")
            .located(By.xpath("//android.widget.TextView[@text=\"Search Wikipedia\"]"))
            .waitingForNoMoreThan(Duration.ofSeconds(2));
    public static final Target INPUT_SEARCH_WIKIPEDIA = Target.the("Ingresa datos de busqueda")
            .located(By.xpath("//android.widget.AutoCompleteTextView[@resource-id=\"org.wikipedia.alpha:id/search_src_text\"]"))
            .waitingForNoMoreThan(Duration.ofSeconds(2));
    public static final Target FIRST_ELEMENT = Target.the("Selecciona el primer elemento de la busqueda")
            .located(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"org.wikipedia.alpha:id/search_results_list\"]/android.view.ViewGroup[1]"))
            .waitingForNoMoreThan(Duration.ofSeconds(2));
    public static final Target RESULT = Target.the("Selecciona una palabra igual a la busqueda")
            .locatedBy("//android.view.View[contains(@text,'{0}')]");







}


