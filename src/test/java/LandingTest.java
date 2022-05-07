import Steps.ElementStep;
import Steps.LandingStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LandingTest extends BaseTest {

    ElementStep elementStep = new ElementStep(webDriver);
    LandingStep landingStep = new LandingStep(webDriver);
    //ElementsStep elementsStep = new ElementsStep(webDriver);

    @Test
    public void testMenuOptionElment() {
        landingStep.clicOPtion(0);
        System.out.println(elementStep.getText());
        Assert.assertEquals(elementStep.getText(), "Text Box");
    }

    @Test
    public void testFormTextBox() {
        landingStep.clicOPtion(0);
        elementStep.clickTextBoxOpt();
    }
}
