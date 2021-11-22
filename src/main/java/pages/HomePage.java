package pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

@PageUrl("https://imindersingh.com")
public class HomePage extends FluentPage {

    public static final String BANNER = "#Containercomp-jdpppire";

    @FindBy(css = "#Containercomp-jdpppire")
    private FluentWebElement banner;

    @FindBy(css = "._1RsPI")
    private FluentWebElement closeButton;

    public HomePage clickCloseButton() {
        awaitUntilBannerAppears();
        closeButton.click();
        return this;
    }

    private HomePage awaitUntilBannerAppears() {
        await().atMost(5, TimeUnit.SECONDS).until(el(BANNER)).displayed();
        return this;
    }
}
