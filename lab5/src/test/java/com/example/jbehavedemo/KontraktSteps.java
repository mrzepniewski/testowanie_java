package com.example.jbehavedemo;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import junit.framework.TestCase;

import org.junit.Assert;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;


public class KontraktSteps {
	
	private Kontrakt kontrakt;
	
	@Given("a kontrakt")
	public void calulatorSetup(){
		kontrakt = new Kontrakt();
	}
	
	@When("set arguments to $value")
	public void setArguments(Integer value){
		kontrakt.setliczba(value);
	}
	
    @Then("cyfrokrad with 3 param should return $result or $result2 or $result3")
	public void shouldCyfrokradWith3Param(Integer result,Integer result2,Integer result3){
    	int actual = kontrakt.cyfrokrad().intValue();
		assertThat(""+actual+"", result == actual || result2 == actual || result3 == actual);
	}
    
    @Then("cyfrokrad with 2 param should return $result or $result2")
	public void shouldCyfrokradWith2Param(Integer result,Integer result2){
    	int actual = kontrakt.cyfrokrad().intValue();
		assertThat(""+actual+"", result == actual || result2 == actual);
	}
 
    
    @Then("nieksztaltek with 2 param should return $result or $result2")
  	public void shouldNieksztaltekWith2Param(Integer result,Integer result2){
    	int actual = kontrakt.nieksztaltek().intValue();
  		assertThat(""+actual+"", result == actual || result2 == actual);
  	}
    
    @Then("nieksztaltek with 1 param should return $result")
  	public void shouldNieksztaltekWith1Param(Integer result){
    	int actual = kontrakt.nieksztaltek().intValue();
  		assertThat(""+actual+"", result == actual);
  	}
    

    @Then("hultajchochla with 3 param should return $result or $result2 or $result3")
  	public void shouldHultajchochlaWith3Param(Integer result,Integer result2,Integer result3) throws NieudanyPsikusException{
    	int actual = kontrakt.hultajchochla().intValue();
		assertThat(""+actual+"", result == actual || result2 == actual || result3 == actual);
  	}
    
    @Then("hultajchochla with 1 param should return $result")
  	public void shouldHultajchochlaWith1Param(Integer result) throws NieudanyPsikusException{
    	int actual = kontrakt.hultajchochla().intValue();
		assertThat(""+actual+"", result == actual );
  	}
}
