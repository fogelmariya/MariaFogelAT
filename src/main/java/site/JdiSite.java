package site;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import entities.User;
import enums.HeaderMenuItems;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import site.elements.MyMenu;
import site.forms.LoginnForm;
import site.pages.HomePageJdi;
import site.pages.MetalsColorsPage;
import site.sections.Header;


@JSite("https://epam.github.io/JDI")
public class JdiSite extends WebSite {

    public static HomePageJdi homePage;
    public static LoginnForm loginForm;
    public static Header header;

    @JFindBy(css = ".profile-photo")
    private static Label profilePhoto;

    @FindBy(css = ".logout .submit")
    private static Button logOutButton;

    @JFindBy(css = ".nav")
    public static MyMenu<HeaderMenuItems> menuHeader;

    @JPage(url = "/metals-colors.html", title = "Metal and Colors")
    public static MetalsColorsPage metalsColorsPage;

    @Step
    public static void login(User user) {
        profilePhoto.click();
        loginForm.loginAs(user);
    }

    @Step
    public static void logout() {
        profilePhoto.click();
        logOutButton.click();
    }

    @Step
    public static void openPage(String page) {
        menuHeader.select(page);
        // TODO what happened in case if we open another page ?
    }
}
