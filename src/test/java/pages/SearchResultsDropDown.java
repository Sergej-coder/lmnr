package pages;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;
import io.qameta.allure.Allure;
//import com.codeborne.selenide.SelenideElement

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;

public class SearchResultsDropDown {

    private final ElementsCollection titles = $$("[id*='react-autowhatever-navSuggestionSearch--item']");

    @Step("Save the name of the title index '{titleIndx}'")
    public String getTitleName(int titleIndx) {
         
        titles.shouldHave(sizeGreaterThan(titleIndx));
            
        int count = titles.size();
 
        Allure.step("Number of titles in dropdown: " + count);

        String xTitle = titles.get(titleIndx).$(".searchResult__constTitle").getText();

          
        Allure.addAttachment("Title", xTitle);
          
           
        

        return xTitle; 
    }
                
    @Step("Click on title with index '{titleNumber}' in the dropdown")
    public TitlePage clickTitle(int titleNumber) {
       
       titles.get(titleNumber).click();
       return new TitlePage();


     }
    }
                    
    



