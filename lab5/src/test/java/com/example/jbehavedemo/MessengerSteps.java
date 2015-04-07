package com.example.jbehavedemo;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.example.jbehavedemo.messenger.MessageServiceSimpleImpl;
import static org.hamcrest.MatcherAssert.assertThat;

public class MessengerSteps {
	
	private Messenger ms;
	private String message;
	private String server;
	
	@Given("a messenger")
	public void messangerSetup(){
		ms = new Messenger(new MessageServiceSimpleImpl());
	}
	
	@When("set message text to $text")
	public void setMessage(String text){
		message = text;
	}
	
	@When("set server name to $host")
	public void setServer(String host){
		server = host;
	}

	@Then("testConnection should return $result")
	public void testConnection(int result){
		assertThat("testConnection should be "+ms.testConnection(server)+" ",result == ms.testConnection(server));
	}
	
	@Then("sendMessage return $result")
	public void send(int result){
		assertThat("sendMessege should be "+ms.sendMessage(server, message)+" ",result == ms.sendMessage(server, message));
	}

}
