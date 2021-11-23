package pages;

import lombok.Getter;
import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;
import static org.assertj.core.api.Assertions.assertThat;

@PageUrl("https://imindersingh.com")
public class HomePage extends FluentPage {

    private static final String BANNER = "#Containercomp-jdpppire";

    @FindBy(css = "#Containercomp-jdpppire")
    @Getter
    private FluentWebElement banner;

    @FindBy(css = "._1RsPI")
    private FluentWebElement closeButton;

    @FindBy(css = "#comp-jdpppirv > h2 > span > span > span > span > span")
    @Getter
    private FluentWebElement bannerHeading;

    @FindBy(css = "input[name='email']")
    private FluentWebElement emailField;

    @FindBy(css = "#comp-kvk9iyo3 > button")
    private FluentWebElement submitButton;

    @FindBy(css = "a > .wQYUw")
    private FluentWebElement subscribeButton;

    @FindBy(css = "#comp-kvk9iynz > input._3ESMu")
    private FluentWebElement privacyCheckBox;

    @FindBy(xpath = "//span[text()='Thanks for Subscribing!']")
    @Getter
    private FluentWebElement thanksForSubscribingMessage;

    public HomePage clickCloseButton() {
        closeButton.click();
        return this;
    }

    public void awaitUntilBannerAppears() {
        await().atMost(5, TimeUnit.SECONDS).until(el(BANNER)).displayed();
    }

    public HomePage enterEmail(final String email){
        emailField.write(email);
        return this;
    }

    public  HomePage clickSubscribeButton() {
        subscribeButton.click();
        return this;
    }

    public HomePage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public HomePage tickPrivacyCheckBox() {
        privacyCheckBox.click();
        return this;
    }
}
