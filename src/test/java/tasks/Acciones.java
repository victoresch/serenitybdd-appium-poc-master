package tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.Visibility;
import ui.Config;
import ui.HomeWiki;
import ui.OnboardingWiki;

public class Acciones {

    private Acciones() {
    }

    public static Performable omitirOnboarding2() {
        return Task.where("{Cerrar info si está visible}", actor -> {
            actor.attemptsTo(
                    Click.on(OnboardingWiki.SKIP)
            );
            actor.attemptsTo(
                    Check.whether(Visibility.of(HomeWiki.CLOSE_INFO))
                            .andIfSo(Click.on(HomeWiki.CLOSE_INFO)));
        });
    }



    public static Performable configuracionParametro(String opcion) {
        if (opcion.equalsIgnoreCase("idioma")) {
            return Task.where("{configuracion lenguaje",actor -> {
                actor.attemptsTo(
                        entrarAconfigurar()
                );
                actor.attemptsTo(
                        Click.on(Config.WIKIPEDIA_LANGUAGES)
                );
            });

        } else if (opcion.equalsIgnoreCase("feed")) {
            return Task.where("{configuracion lenguaje", actor -> {
                actor.attemptsTo(
                        entrarAconfigurar()
                );
                actor.attemptsTo(
                        Click.on(Config.EXPLORE_FEED)
                );
            });

        } else {
            throw new IllegalArgumentException("Opción no válida: " + opcion);
        }
        }

    public static Performable realizarBusqueda(String aBuscar) {
        return Task.where(actor -> actor.attemptsTo(
                Click.on(HomeWiki.SEARCH_WIKIPEDIA),
                Enter.theValue(aBuscar).into(HomeWiki.INPUT_SEARCH_WIKIPEDIA)
        ));

    }
    public static Performable entrarAconfigurar() {
        return Task.where(actor -> actor.attemptsTo(
                Click.on(Config.MORE),
                Click.on(Config.SETTINGS)
        ));

    }

    public static Performable cerrarPopUp(String aBuscar) {
        return Task.where("{Cerrar info si está visible}", actor -> {
            actor.attemptsTo(
                    Check.whether(Visibility.of(HomeWiki.CLOSE_INFO))
                            .andIfSo(Click.on(HomeWiki.CLOSE_INFO)));
        });
    }



}