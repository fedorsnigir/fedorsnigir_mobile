package webtests;

import hooks.Hooks;
import org.testng.annotations.Test;

@Test(groups = "web")
public class WebTest extends Hooks {

    @Test(description = "Yandex search with EPAM")
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
