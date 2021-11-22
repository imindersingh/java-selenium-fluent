package pages;

import org.fluentlenium.core.annotation.Page;
import org.junit.Test;

public class HomePageTest extends BaseTest {

    @Page
    HomePage homePage;

    @Test
    public void closeBannerDisplaysHome() {
        goTo(homePage).window().maximize();
        homePage.clickCloseButton();
    }
}