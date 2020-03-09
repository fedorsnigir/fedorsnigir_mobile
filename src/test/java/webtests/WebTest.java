package webtests;

import pageObjects.web.YandexPage;
import setup.DriverSetup;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static enums.PropertyOptionsEnum.WEB;

@Test(groups = "web")
public class WebTest extends DriverSetup {

    private YandexPage yandexPage;

    @BeforeSuite(description = "Prepare driver")
    public void setUp() throws Exception {
        System.out.println("Driver preparation");
        prepareDriver(WEB);
        yandexPage = new YandexPage(getDriver());
        System.out.println("Driver prepared");
    }

    @AfterSuite(description = "Close driver")
    public void tearDown() throws Exception {
        System.out.println("Driver closure");
        getDriver().quit();
        System.out.println("Driver closed");
    }

    @Test(description = "Google search with EPAM")
    public void webTest() throws Exception {

        //Step 1: Open Google search page
        yandexPage.open(SUT, getWait());
        System.out.println("Yandex is opened");

        //Step2: Make a search using keyword ‘EPAM’
        yandexPage.search("EPAM");
        System.out.println("EPAM is searched");

        //Step 3: Make sure that there are some relevant results (non-empty list)
        yandexPage.checkNonEmptyResults();
        System.out.println("Results are shown");
    }
}
