package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

public class Page {

    @Step("Open '{url}' homepage")
    public void pageOpen(String url) {
        open(url);
        
    }

    @Step("Search for '{query}'")
    public SearchResultsDropDown search(String query) {
        $(byId("suggestion-search")).setValue(query);
        return new SearchResultsDropDown();
    }
}

