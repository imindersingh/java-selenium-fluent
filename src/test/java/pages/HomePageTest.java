package pages;

import org.fluentlenium.core.annotation.Page;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePageTest extends BaseTest {

    @Page
    HomePage homePage;

    @Test
    public void bannerHeadingTextIsCorrect() {
        goTo(homePage).awaitUntilBannerAppears();
        final String expectedBannerHeading = "Subscribe now and get 20% off your first order!";
        assertThat(expectedBannerHeading).isEqualTo(homePage.getBannerHeading().text());
        homePage.clickCloseButton();
    }

    @Test
    public void subscribeToNewsLetterSuccessfully() {
        goTo(homePage).clickSubscribeButton()
                .awaitUntilBannerAppears();
        assertThat(homePage.getBanner().displayed()).isTrue();
        final String email = "test@test.com";
        homePage.enterEmail(email)
                .tickPrivacyCheckBox()
                .clickSubmitButton();
        final String expectedSubscriptionMessage = "Thanks for Subscribing!";
        assertThat(expectedSubscriptionMessage).isEqualTo(homePage.getThanksForSubscribingMessage().text());
        homePage.clickCloseButton();
    }
}