package Steps;

import Pages.LandingPage;
import org.openqa.selenium.WebDriver;

public class LandingStep extends BaseSteps {

    LandingPage landingPage = new LandingPage(webDriver);

    public LandingStep(WebDriver webDriver) {
        super(webDriver);
    }

    //Clic en el boton Elements
    public void clicOPtion(int option) {

        landingPage.getMenuOptions().get(option).click();
    }
}
