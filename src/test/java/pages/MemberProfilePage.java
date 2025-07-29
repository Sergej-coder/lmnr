package pages;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class MemberProfilePage {


    @Step("Verify cast memeber profile page shows correct name")
    public void verifyMemberName(String expectedName) {

        $("h1").shouldHave(text(expectedName));
    }
}

