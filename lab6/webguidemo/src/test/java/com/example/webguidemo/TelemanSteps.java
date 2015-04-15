package com.example.webguidemo;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.*;

public class TelemanSteps {
	
	private final Pages pages;

	
	
	public TelemanSteps(Pages pages) {
		this.pages = pages;
	}
	
	@Given("user is on Home page")
    public void userIsOnHomePage(){        
        pages.home().open();        
    }
 
    @When("user opens Sport link")
    public void userClicksOnSportLink(){        
        pages.home().findElement(By.linkText("SPORT")).click();
    }
 
    @Then("Sport page is shown")
    public void sportPageIsShown(){
       assertEquals("Sport w Programie TV - Program telewizyjny Teleman.pl", pages.sport().getTitle());
    }	
    
    @When("user opens list channels and choose Polsat channel")
    public void userClicksOnChannelList(){        
        pages.home().findElement(By.xpath(".//*[@id='main-menu-stations']")).click();
        pages.home().findElement(By.xpath(".//*[@id='stations-index']/ul/li[4]/a[13]")).click();
    }
    
    @Then("Polsat page is shown")
    public void polsatPageIsShown(){
       assertEquals("Polsat - Aktualny Program TV", pages.polsat().getTitle());
    }
  
    @When("user searches $result")
    public void userSearchChannel(String result){        
        WebElement inputField = pages.home().findElement(By.xpath(".//*[@id='search-form']/input[1]"));
        inputField.sendKeys(result);
        pages.home().findElement(By.xpath(".//*[@id='search-form']/input[2]")).click();
        
    }
  
    @Then("showing the Polsat channel on third position")
    public void showingTheSearchProgram3(){
    	String searchPolsat = pages.searchPolsat().findElement(By.xpath(".//*[@id='content']/ul/li[3]/div")).getText();
      	assertEquals("stacja TV - Polsat to pierwszy komercyjny kana³ który otrzyma³ koncesjê na ogólnopolskie nadawanie programu TV. To jednoczeœnie jedna z najchêtniej ogl¹danych stacji TV w Polsce.",searchPolsat);
    }
    
    @Then("showing the Polsat Viasat History channel on second position")
    public void showingTheSearchProgram2(){
    	String searchPolsat = pages.searchPolsat().findElement(By.xpath(".//*[@id='content']/ul/li[2]/a[2]")).getText();
      	assertEquals("Polsat Viasat History",searchPolsat);
    }
    
    @Then("showing the Polsat Viasat Explore channel on first position")
    public void showingTheSearchProgram1(){
    	String searchPolsat = pages.searchPolsat().findElement(By.xpath(".//*[@id='content']/ul/li[1]/a[2]")).getText();
      	assertEquals("Polsat Viasat Explore",searchPolsat);
    }
    
    @When("user click on Polsat programmes")
    public void userSearchPolsatProgrammes(){        
        pages.searchPolsat().findElement(By.xpath(".//*[@id='search-navig']/a[2]")).click();
        
    }
    
    @Then("Then it checks the program display on $day $month at $hour")
    public void showingTheSearchChannelProgrammesOn23KwietniaAt9(String month, String day, String hour){
    	String polsatProgrammes = pages.polsatProgrammes().findElement(By.xpath(".//*[@id='content']/ul/li[23]/div[2][contains(.,'"+month+"')][contains(.,'"+day+"')][contains(.,'"+hour+"')]")).getText();
      	assertEquals("Polsat News, czwartek, "+month+" "+day+" "+hour+"",polsatProgrammes);
    }
    
}
