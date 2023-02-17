package pom;

import drivers.Driver;
import methods.BaseMethods;
import methods.JavaScriptExecutor;
import methods.ListMethods;
import methods.SelectMethods;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePom {

    public BasePom(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
   public BaseMethods baseMethods = new BaseMethods();

   public JavaScriptExecutor javaScriptExecutor = new JavaScriptExecutor();

   public SelectMethods selectMethods = new SelectMethods();

   public ListMethods listMethods = new ListMethods();
}
