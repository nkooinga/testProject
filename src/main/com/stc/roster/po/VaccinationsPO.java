//package com.stc.roster.po;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindAll;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
//
//import java.util.List;
//
//public class VaccinationsPO {
//
//    WebDriver driver;
//
//    public VaccinationsPO(WebDriver driver) {
//        this.driver = new driver;
//        PageFactory.initElements(driver, this);
//        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
//    }
//
//    @FindBy(className = "glyphicon-list")
//    private WebElement studentVacc;
//
//    public WebElement getStudentVacc() {
//        return studentVacc;
//    }
//
//    @FindBy(xpath = "//span[.='Update Vaccinations']")
//    private WebElement updateVaccButton;
//
//    public WebElement getUpdateVaccButton() {
//        return updateVaccButton;
//    }
//
//    @FindBy(id = "listBox28")
//    private WebElement selectVaccine;
//
//    public WebElement getSelectVaccine() {
//        return selectVaccine;
//    }
//
//
//
//    @FindAll( {
//            @FindBy(className = "knRwxH")
//    })
//    private List<WebElement>  selectVaccDate;
//}
