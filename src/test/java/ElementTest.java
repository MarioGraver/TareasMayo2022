import Pages.ElementsPage;
import Steps.ElementStep;
import Steps.LandingStep;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ElementTest extends BaseTest {

    ElementStep elementStep = new ElementStep(webDriver);
    LandingStep landingStep = new LandingStep(webDriver);
    ElementsPage elementsPage = new ElementsPage(webDriver);

    //Req 2
    @Test
    public void testFormElements() {
        landingStep.clicOPtion(0);
        elementStep.clickTextBoxOpt();
        System.out.println(elementStep.getTextFullName());
        Assert.assertEquals(elementStep.getTextFullName(), "Full Name");
        System.out.println(elementStep.getTextEmail());
        Assert.assertEquals(elementStep.getTextEmail(), "Email");
        System.out.println(elementStep.getTextCurrentAddress());
        Assert.assertEquals(elementStep.getTextCurrentAddress(), "Current Address");
        System.out.println(elementStep.getTextPermanentAddress());
        Assert.assertEquals(elementStep.getTextPermanentAddress(), "Permanent Address");
        System.out.println(elementStep.getTextSubmit());
        Assert.assertEquals(elementStep.getTextSubmit(), "Submit");
    }
    //Req 3
    @Test
    public void testFormSubmitInvalidEmail() {
        landingStep.clicOPtion(0);
        elementStep.clickTextBoxOpt();
        elementsPage.getFielTBdFullName().sendKeys("Mario Veri");
        elementsPage.getFielTBdemail().sendKeys("mari123");
        elementsPage.getFielTBcurrentAddress().sendKeys("Cameli123456");
        elementsPage.getFielTBpermanentAddress().sendKeys("National789");
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,500)");
        elementStep.clickBtmSubmit();

        Assert.assertFalse(elementStep.getoutputPresent());
    }
    //Req 4
    @Test
    public void testFormSubmitValidEmail() {
        landingStep.clicOPtion(0);
        elementStep.clickTextBoxOpt();

        elementsPage.getFielTBdFullName().sendKeys("Mario Veri");
        elementsPage.getFielTBdemail().sendKeys("123@ss.com");
        elementsPage.getFielTBcurrentAddress().sendKeys("Camelina 123");
        elementsPage.getFielTBpermanentAddress().sendKeys("Maximi 123");
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,500)");
        elementStep.clickBtmSubmit();


        Assert.assertTrue(elementStep.getoutputPresent());

        System.out.println(elementStep.getTextResultName());
        Assert.assertEquals(elementStep.getTextResultName(), "Name:Mario Veri");
        System.out.println(elementStep.getTextResultEmail());
        Assert.assertEquals(elementStep.getTextResultEmail(), "Email:123@ss.com");
        System.out.println(elementStep.getTextResultCurrentAddress());
        Assert.assertEquals(elementStep.getTextResultCurrentAddress(), "Current Address :Camelina 123");
        System.out.println(elementStep.getTextResultPermanAddress());
        Assert.assertEquals(elementStep.getTextResultPermanAddress(), "Permananet Address :Maximi 123");
    }

}
