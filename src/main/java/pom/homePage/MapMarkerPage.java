package pom.homePage;

import mockData.JavaFakerData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pom.BasePom;

public class MapMarkerPage extends BasePom {

    @FindBy(xpath = "//a[@href='/webportal.test/map_marker']")
    private WebElement mapMarkerButton;

    @FindBy(xpath = "//h1[@class='page-title']")
    private WebElement pageTitle;

    @FindBy(xpath = "(//button[@title='Увеличить'])[1]")
    private WebElement zoomButton;

    @FindBy(xpath = "(//button[@title='Уменьшить'])[1]")
    private WebElement zoomOutButton;

    @FindBy(xpath = "//button[@aria-label='Показать спутниковую карту']")
    private WebElement sputnikButton;

    @FindBy(xpath = "//button[@aria-label='Показать карту с названиями объектов']")
    private WebElement mapButton;

    @FindBy(xpath = "//select[@name='region_level']")
    private WebElement regionsSelect;

    @FindBy(xpath = "//select[@name='detail_level']")
    private WebElement objectSelect;

    @FindBy(xpath = "//a[@id='ui-id-2']")
    private WebElement listButton;

    @FindBy(xpath = "//input[@class='form-control input-sm']")
    private WebElement searchField;

//    @FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr/td[2]")
//    private WebElement titleColumn;

    @FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr[1]/td[4]")
    private WebElement regionColumn;

    @FindBy(xpath = "//a[@class='cursor-pointer btn-xs btn-success']")
    private WebElement showButton;

    @FindBy(xpath = "//div[@style='z-index: 3; position: absolute; height: 100%; width: 100%; padding: 0px; border-width: 0px; margin: 0px; left: 0px; top: 0px; touch-action: pan-x pan-y;']")
    private WebElement mapDisplay;


    By markersInList = By.xpath("//*[@id='DataTables_Table_0']/tbody/tr");

//    public MapMarkerPage checkMapDisplay(){
//
//    }
    public MapMarkerPage clickShowButton() {
        baseMethods.click(showButton);
        return this;
    }

    public MapMarkerPage checkTitleColumn() {
        Assert.assertEquals(regionColumn.getText(), "bishkek");
        return this;
    }

    public MapMarkerPage fillSearchField() {
        baseMethods.sendKeys(searchField, "bishkek");
        return this;
    }

    public MapMarkerPage checkListOfMarkers() {
        Assert.assertTrue(listMethods.getAllElements(markersInList).size() > 0);
        return this;
    }

    public MapMarkerPage clickListButton() {
        baseMethods.click(listButton);
        return this;
    }

    public MapMarkerPage selectObject() {
        new Select(objectSelect).selectByIndex(JavaFakerData.getRandomNumber(3));
        return this;
    }

    public MapMarkerPage selectRegion() {
        new Select(regionsSelect).selectByIndex(JavaFakerData.getRandomNumber(8));
        return this;
    }

    public MapMarkerPage clickMapButton() {
        baseMethods.click(mapButton);
        return this;
    }

    public MapMarkerPage clickSputnikButton() {
        baseMethods.click(sputnikButton);
        return this;
    }

    public MapMarkerPage clickZoomOutButton() {
        baseMethods.click(zoomOutButton);
        return this;
    }

    public MapMarkerPage clickZoomButton() {
        baseMethods.click(zoomButton);
        return this;
    }

    public MapMarkerPage textCheck() {
        Assert.assertEquals(baseMethods.getText(pageTitle), "Markers");
        return this;
    }

    public MapMarkerPage clickMapMarkerButton() {
        baseMethods.click(mapMarkerButton);
        return this;
    }


}
