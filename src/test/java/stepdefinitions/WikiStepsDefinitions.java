package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import questions.ViewElementsDisplay;
import tasks.Acciones;
import ui.Config;
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

    @When("agrego el idioma {string}")
    public void agregoElIdioma(String idioma) {
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
    }

    @And("selecciono el primer resultado")
    public void seleccionoElPrimerResultado() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(HomeWiki.FIRST_ELEMENT),
                Check.whether(Visibility.of(HomeWiki.CLOSE_INFO))
                        .andIfSo(Click.on(HomeWiki.CLOSE_INFO))
        );
    }

    @Then("visualizo el resultado {string}")
    public void visualizoElResultado(String busqueda) {
        theActorInTheSpotlight().should(
                seeThat("Se ve resultado de la busqueda",
                        ViewElementsDisplay.busqueda(busqueda)
                ));
    }

    @When("ingreso a configuracion de {string}")
    public void ingresoAConfiguracion(String opcion) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Acciones.configuracionParametro(opcion)
        );
    }

    @Then("visualizo la nueva configuración")
    public void visualizoLaNuevaConfiguracion() {
        theActorInTheSpotlight().should(
                seeThat("Se ve el nuevo idioma en la configuración",
                        ViewElementsDisplay.nuevoIdiomaEnConfiguracion()
                ));

    }

    @Then("visualizo la nueva configuración del feed")
    public void visualizoLaNuevaConfiguracionDelFeed() {
        theActorInTheSpotlight().should(
                seeThat("Se ve la nueva configuración del feed",
                        ViewElementsDisplay.nuevaConfiguracionFeed()
                ));
    }

    @And("personalizo el feed")
    public void personalizoElFeed() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(Config.MORE_OPTIONS),
                Click.on(Config.HIDE_ALL),
                Click.on(OnboardingWiki.BACK),
                Click.on(OnboardingWiki.BACK)
        );
    }
}
