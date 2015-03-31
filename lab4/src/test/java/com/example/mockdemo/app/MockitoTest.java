package com.example.mockdemo.app;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.internal.stubbing.answers.ThrowsException;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.MessageServiceSimpleImpl;
import com.example.mockdemo.messenger.SendingStatus;


@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {
	
	@Mock 
	private MessageService ms;
	
	
	private Messenger messenger;
	private Messenger SpyMessenger;
	

	@Test	
	public void SpyTestConnection1() throws MalformedRecipientException{

		messenger = new Messenger(ms);
		SpyMessenger = spy(messenger);
		
		when(ms.checkConnection("czescwszystkim.pl")).thenReturn(ConnectionStatus.SUCCESS);
		when(ms.send("czescwszystkim.pl","odpowiednialiczbaliter")).thenReturn(SendingStatus.SENT);
		assertEquals(SpyMessenger.testConnection("czescwszystkim.pl"), 0);
		
	}
	
	@Test	
	public void SpySendMessageTest1() throws MalformedRecipientException{

		messenger = new Messenger(ms);
		SpyMessenger = spy(messenger);
		
		when(ms.checkConnection("czescwszystkim.pl")).thenReturn(ConnectionStatus.SUCCESS);
		when(ms.send("czescwszystkim.pl","odpowiednialiczbaliter")).thenReturn(SendingStatus.SENT);
		assertEquals(SpyMessenger.sendMessage("czescwszystkim.pl", "odpowiednialiczbaliter"), 0);
		
	}
	
	@Test	
	public void SpySendMessageTest2() throws MalformedRecipientException{

		messenger = new Messenger(ms);
		SpyMessenger = spy(messenger);
		
		when(ms.checkConnection("czescwszystkim.pl")).thenReturn(ConnectionStatus.SUCCESS);
		when(ms.send("czescwszystkim.pl","1")).thenThrow(new MalformedRecipientException());
		assertEquals(SpyMessenger.sendMessage("czescwszystkim.pl", "1"), 2);
		
	}
	
	@Test	
	public void SpyTestConnection2() throws MalformedRecipientException{

		messenger = new Messenger(ms);
		SpyMessenger = spy(messenger);
		
		when(ms.checkConnection("czescwszystkim.com")).thenReturn(ConnectionStatus.FAILURE);
		when(ms.send("czescwszystkim.com","1")).thenReturn(SendingStatus.SENDING_ERROR);
		assertEquals(SpyMessenger.testConnection("czescwszystkim.com"), 1);
		
	}
	
	
	@Test
	public void answerTestConnection() throws MalformedRecipientException {
		
		messenger = new Messenger(ms);
		SpyMessenger = spy(messenger);
		
		when(ms.checkConnection("czescwszystkim.pl")).thenAnswer(new Answer<ConnectionStatus>(){

			@Override
			public ConnectionStatus answer(InvocationOnMock invocation)
					throws Throwable {
					
				return ConnectionStatus.SUCCESS;
			}

		
		  });
		  
		  assertEquals(SpyMessenger.testConnection("czescwszystkim.pl"), 0);

		}
	
	@Test
	public void answerSendMessageTest1() throws MalformedRecipientException {
		
		messenger = new Messenger(ms);
		SpyMessenger = spy(messenger);
		
		when(ms.checkConnection("czescwszystkim.pl")).thenAnswer(new Answer<ConnectionStatus>(){

			@Override
			public ConnectionStatus answer(InvocationOnMock invocation)
					throws Throwable {
					
				return ConnectionStatus.SUCCESS;
			}

		
		  });
		
		when(ms.send("czescwszystkim.pl", "odpowiednialiczbaliter")).thenAnswer(new Answer<SendingStatus>(){

			@Override
			public SendingStatus answer(InvocationOnMock invocation)
					throws Throwable {
					
				return SendingStatus.SENT;
			}

		
		  });
		  
		  assertEquals(SpyMessenger.sendMessage("czescwszystkim.pl","odpowiednialiczbaliter"), 0);

		}
	
	@Test
	public void answerSendMessageTest2() throws MalformedRecipientException {
		
		messenger = new Messenger(ms);
		SpyMessenger = spy(messenger);
		
		when(ms.checkConnection("czescwszystkim.com")).thenAnswer(new Answer<ConnectionStatus>(){

			@Override
			public ConnectionStatus answer(InvocationOnMock invocation)
					throws Throwable {
					
				return ConnectionStatus.FAILURE;
			}

		
		  });
		
		when(ms.send("czescwszystkim.com", "odpowiednialiczbaliter")).thenAnswer(new Answer<SendingStatus>(){

			@Override
			public SendingStatus answer(InvocationOnMock invocation)
					throws Throwable {
					
				return SendingStatus.SENDING_ERROR;
			}

		
		  });
		  
		  assertEquals(SpyMessenger.sendMessage("czescwszystkim.com","odpowiednialiczbaliter"), 1);

		}
}

