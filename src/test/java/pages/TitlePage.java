package pages;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;
import io.qameta.allure.Allure;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;

public class TitlePage {

    private final SelenideElement topCast = $("section[data-testid='title-cast']");
    private final ElementsCollection topCastMembers = topCast.$$("div[data-testid='title-cast-item']");

    @Step("Verify page title is '{expectedTitle}'")
    public void verifyTitle(String expectedTitle) {
    
        $("h1").shouldHave(text(expectedTitle));
        
    }

    @Step("Verify top cast section contain text '{inText}'")
    public void verifyTopCast(String inText) {

        topCast.$("h3").shouldHave(text(inText));

    }


    @Step("Verify top cast has more than {minCount} members")
    public void verifyTopCastCount(int minCount) {
        topCastMembers.shouldHave(sizeGreaterThan(minCount));
        
    }
    
    @Step("Save top cast member title with index {titleIndx}")
    public String saveMemberTitle(int titleIndx) {
        
        String memberTitle = topCastMembers.get(titleIndx).$("a[data-testid='title-cast-item__actor']").getText();

        Allure.step("Cast member title: " + memberTitle);
        
        return memberTitle;

    }
    
    @Step("Click on top cast memeber with index '{titleIndx}'")
    public MemberProfilePage clickMemberProfile(int titleIndx) {
 
        topCastMembers.get(titleIndx).$("a[data-testid='title-cast-item__actor']").click();
    
        return new MemberProfilePage();


     }
    
}

