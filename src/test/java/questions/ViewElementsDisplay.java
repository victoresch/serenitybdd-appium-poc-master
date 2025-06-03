package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import ui.WikiUi;


public class ViewElementsDisplay implements Question<Boolean> {
    private final Target element;

    private ViewElementsDisplay(Target element) {
        this.element = element;
    }
    public static ViewElementsDisplay nuevoIdioma() {
        return new ViewElementsDisplay(WikiUi.LANGUAGES_ON_ONBOARDING);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return element.isVisibleFor(actor);
    }
}

