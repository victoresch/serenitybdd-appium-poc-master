package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.ScrollTo;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import org.apache.commons.compress.archivers.sevenz.CLI;
import questions.ViewElementsDisplay;
import tasks.Acciones;
import ui.HomeWiki;
import ui.OnboardingWiki;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class WikiStepsDefinitions {


    @Given("Estoy en el onboarding de wiki")
    public void estoyEnElOnboardingDeWiki() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(OnboardingWiki.ADD_OR_EDIT_LANGUAGE, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(OnboardingWiki.ADD_OR_EDIT_LANGUAGE)
        );

    }

    @When("agregar el idioma {string}")
    public void agregarElIdioma(String idioma) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(OnboardingWiki.ADD_LANGUAGES),
                Click.on(OnboardingWiki.SELECT_LANGUAGE.of(idioma)),
                Click.on(OnboardingWiki.BACK)
        );
    }

    @Then("visualizo la configuración del idioma nuevo")
    public void visualizoLaConfiguracionDelIdiomaNuevo() {
        theActorInTheSpotlight().should(
                seeThat("Se ve el nuevo idioma en la lista",
                      ViewElementsDisplay.nuevoIdioma()
        ));
    }

    @Given("Estoy en el home de wiki")
    public void estoyEnElHomeDeWiki() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Acciones.omitirOnboarding2()
        );
    }

    @When("realizar una busqueda con {string}")
    public void realizarUnaBusquedaCon(String aBuscar) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Acciones.realizarBusqueda(aBuscar)
        );
        seleccionoElPrimerResultado(aBuscar);

    }

    @And("selecciono el primer resultado")
    public void seleccionoElPrimerResultado(String aBuscar) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(HomeWiki.FIRST_ELEMENT),
                Check.whether(Visibility.of(HomeWiki.CLOSE_INFO))
                        .andIfSo(Click.on(HomeWiki.CLOSE_INFO)),
                Click.on(HomeWiki.RESULT.of(aBuscar))

        );


    }

    @Then("visualizo el resultado")
    public void visualizoElResultado() {
        theActorInTheSpotlight().should(
                seeThat("Se ve resultado de la busqueda",
                        ViewElementsDisplay.busqueda()
                ));

    }
}
