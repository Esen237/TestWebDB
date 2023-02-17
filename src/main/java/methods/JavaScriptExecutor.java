package methods;

import drivers.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class JavaScriptExecutor {

    public JavaScriptExecutor jsClick(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click",element);
        return this;
    }
    public JavaScriptExecutor jsScrollToEnd(){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
        return this;
    }

    public int getAllElementsJS() {
       JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        List<WebElement> eles = (List<WebElement>) js.executeScript("var results = new Array();"
               + "var element = document.evaluate(\"//tbody/tr[@role='row']\", document, null, XPathResult.ORDERED_NODE_SNAPSHOT_TYPE, null);"
               + "for ( var i = 0 ; i < element.snapshotLength ; i++ )"
               + "{"
               +    "results.push(element.snapshotItem(i));"
               + "}"
               + "return results;","");
        return eles.size();
    }
}
