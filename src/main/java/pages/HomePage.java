package pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;
import static org.assertj.core.api.Assertions.assertThat;

@PageUrl("https://imindersingh.com")
public class HomePage extends FluentPage {

    public static final String BANNER = "#Containercomp-jdpppire";
    public static final String BANNER_HEADING_TEXT = "Subscribe now and get 20% off your first order!";

    @FindBy(css = "#Containercomp-jdpppire")
    private FluentWebElement banner;

    @FindBy(css = "._1RsPI")
    private FluentWebElement closeButton;

    @FindBy(css = "#comp-jdpppirv > h2 > span > span > span > span > span")
    private FluentWebElement bannerHeading;

    public HomePage clickCloseButton() {
        closeButton.click();
        return this;
    }

    public void assertBannerHeading(){
        awaitUntilBannerAppears();
        assertThat(bannerHeading.text()).isEqualTo(BANNER_HEADING_TEXT);
    }

    private HomePage awaitUntilBannerAppears() {
        await().atMost(5, TimeUnit.SECONDS).until(el(BANNER)).displayed();
        return this;
    }


}
