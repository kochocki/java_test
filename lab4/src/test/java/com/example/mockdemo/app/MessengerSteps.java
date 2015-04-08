package com.example.mockdemo.app;

import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.MessageServiceSimpleImpl2;

public class MessengerSteps {
	
	private MessageService msDummy = new MessageServiceSimpleImpl2();
	private Messenger messenger;
	String server;
	String message;
	
	@Given("a messenger")
	public void calulatorSetup(){
		messenger = new Messenger(msDummy);
	}
	
	@When("set server to $server")
	public void setServer(String server){
		this.server = server;
	}
	
	@When("set message to $message")
	public void setMessage(String message){
		this.message = message;
	}
	
    @Then("testing connection should return $result")
	public void shouldTest(int result){
		assertEquals(result, messenger.testConnection(server));
	}
    
    @Then("sending a message should return $result")
  	public void shouldSend(int result){
  		assertEquals(result, messenger.sendMessage(server, message));
  	}
}
