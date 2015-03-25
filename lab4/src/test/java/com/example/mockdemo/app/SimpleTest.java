package com.example.mockdemo.app;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Assert;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.MessageServiceSimpleImpl;
import com.example.mockdemo.messenger.SendingStatus;

import static org.hamcrest.BaseMatcher.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class SimpleTest {
	
	Messenger ms = new Messenger(new MessageServiceSimpleImpl());
	
	@Test
	public void testConnectionTest(){
		assertEquals(0, ms.testConnection("czescwszystkim.pl"));
	}
	
	public void testConnectionTest2(){
		assertEquals(1, ms.testConnection("czescwszystkim.com"));
	}
	
	@Test
	public void sendMessageTest() throws MalformedRecipientException{
		assertEquals(0, ms.sendMessage("czescwszystkim.com.pl","odpowiednialiczbaliter"));
	}
	
	@Test
	public void sendMessageTest2() throws MalformedRecipientException{
		assertEquals(2, ms.sendMessage(".pl","odpowiednialiczbaliter"));
	}
	
	@Test
	public void sendMessageTest3() throws MalformedRecipientException{
		assertEquals(2, ms.sendMessage(null,"odpowiednialiczbaliter"));
	}
	
	@Test
	public void sendMessageTest4() throws MalformedRecipientException{
		assertEquals(2, ms.sendMessage(null,null));
	}
	
	@Test
	public void sendMessageTest5() throws MalformedRecipientException{
		assertEquals(2, ms.sendMessage("czescwszystkim.pl",null));
	}
	
	@Test
	public void sendMessageTest6() throws MalformedRecipientException{
		assertEquals(2, ms.sendMessage("czescwszystkim.pl","1"));
	}
	
	@Test
	public void sendMessageTest7() throws MalformedRecipientException{
		assertEquals(1, ms.sendMessage("czescwszystkim.com","odpowiednialiczbaslow"));
	}
}
