package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import ui.HomeWiki;
import ui.OnboardingWiki;


public class ViewElementsDisplay implements Question<Boolean> {
    private final Target element;

    private ViewElementsDisplay(Target element) {
        this.element = element;
    }


    public static ViewElementsDisplay nuevoIdioma() {
        return new ViewElementsDisplay(OnboardingWiki.LANGUAGES_ON_ONBOARDING);
    }

    public static ViewElementsDisplay busqueda() {
        return new ViewElementsDisplay(HomeWiki.RESULT);
    }




    @Override
    public Boolean answeredBy(Actor actor) {
        return element.isVisibleFor(actor);
    }
}

