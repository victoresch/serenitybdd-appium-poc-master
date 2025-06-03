package hooks;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import tasks.StartTheApp;
import utils.DriverFactory;

public class SetUp {

    @Before
    public void setUp() throws Exception {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Usuario").wasAbleTo(StartTheApp.on(DriverFactory.createDriver()));
    }


}