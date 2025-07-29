package tests;

import pages.Page;
import pages.SearchResultsDropDown;
import pages.TitlePage;
import pages.MemberProfilePage;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class ImdbTest {

    @BeforeClass
    public static void setup() {
        Configuration.browser = "chrome";
        Configuration.timeout = 60000;
    }

    @Test
    @Description("Test for QA search, title check, and cast profile validation")

    public void testSearchAndCastValidation() {
        
        // Params
        String url = "https://www.imdb.com";
        String toSearch = "QA";
        int titleIndx = 0; // index 2, page "Stranger Things" contains "Top cast ection"
        String topCastText = "Top cast";
        int topCastCount = 3;
        int memberIndx = 2;

        Page page = new Page();
        page.pageOpen(url);

        SearchResultsDropDown searchResults = page.search(toSearch);

        String xTitle = searchResults.getTitleName(titleIndx);

        TitlePage titlePage = searchResults.clickTitle(titleIndx);
        titlePage.verifyTitle(xTitle);
        titlePage.verifyTopCast(topCastText);
        titlePage.verifyTopCastCount(topCastCount);
        
        String memberTitle = titlePage.saveMemberTitle(memberIndx);

  
        MemberProfilePage profilePage = titlePage.clickMemberProfile(memberIndx);
        profilePage.verifyMemberName(memberTitle);
    }

     @AfterMethod
     public void tearDown() {
        System.out.println("Cleaning up after test");
    }
     
}

