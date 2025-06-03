package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import questions.ViewElementsDisplay;
import ui.WikiUi;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static org.hamcrest.Matchers.is;


public class WikiStepsDefinitions {

    @Given("John Wick wants to create a new post")
    public void john_want_to_create_a_new_post() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(WikiUi.SKIP)
        );
    }


    @Given("Estoy en el home de wiki")
    public void estoyEnElHomeDeWiki() {

        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(WikiUi.ADD_OR_EDIT_LANGUAGE, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(WikiUi.ADD_OR_EDIT_LANGUAGE)
        );

    }

    @When("agregar el idioma {string}")
    public void agregarElIdioma(String idioma) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(WikiUi.ADD_LANGUAGES),
                Click.on(WikiUi.SELECT_LANGUAGE.of(idioma)),
                Click.on(WikiUi.BACK)
        );
    }

    @Then("visualizo la configuración del idioma nuevo")
    public void visualizoLaConfiguracionDelIdiomaNuevo() {
        theActorInTheSpotlight().should(
                seeThat("Se ve el nuevo idioma en la lista",
                      ViewElementsDisplay.nuevoIdioma()
        ));
    }
}
