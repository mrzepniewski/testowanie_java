package com.example.mockdemo.app;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;


public class EasyMockTest {

	private Messenger ms;
	private MessageService mock;

	@Before
	public void setUp() {
		mock = createMock(MessageService.class);
		ms = new Messenger(mock);
	}
	
	@Test
	public void MessengerSendMessage() throws MalformedRecipientException {
		expect(mock.checkConnection("czescwszystkim.pl")).andReturn(ConnectionStatus.SUCCESS).anyTimes();
		expect(mock.send("czescwszystkim.pl", "odpowiednialiczbaliter")).andReturn(SendingStatus.SENT).atLeastOnce();
		replay(mock);
		assertEquals(0, ms.sendMessage("czescwszystkim.pl", "odpowiednialiczbaliter"));
		verify(mock);
	}
	
	@Test
	public void MessengerSendMessage2() throws MalformedRecipientException {
		expect(mock.checkConnection("czescwszystkim.com")).andReturn(ConnectionStatus.FAILURE).anyTimes();
		expect(mock.send("czescwszystkim.com", "1")).andReturn(SendingStatus.SENDING_ERROR).atLeastOnce();
		replay(mock);
		assertEquals(1, ms.sendMessage("czescwszystkim.com", "1"));
		verify(mock);
	}
	
	@Test
	public void MessengerSendMessage3() throws MalformedRecipientException {
		expect(mock.checkConnection("czescwszystkim.pl")).andReturn(ConnectionStatus.SUCCESS).anyTimes();
		expect(mock.send("czescwszystkim.pl", "1")).andThrow(new MalformedRecipientException()).atLeastOnce();
		replay(mock);
		assertEquals(2, ms.sendMessage("czescwszystkim.pl", "1"));
		verify(mock);
	}
	
	@Test
	public void MessengerSendMessage4() throws MalformedRecipientException {
		expect(mock.checkConnection(null)).andReturn(ConnectionStatus.SUCCESS).anyTimes();
		expect(mock.send(null, null)).andThrow(new MalformedRecipientException()).atLeastOnce();
		replay(mock);
		assertEquals(2, ms.sendMessage(null, null));
		verify(mock);
	}
	
	@Test
	public void MessengerSendMessage5() throws MalformedRecipientException {
		expect(mock.checkConnection(".pl")).andReturn(ConnectionStatus.SUCCESS).anyTimes();
		expect(mock.send(".pl", "odpowiednialiczbaliter")).andThrow(new MalformedRecipientException()).atLeastOnce();
		replay(mock);
		assertEquals(2, ms.sendMessage(".pl", "odpowiednialiczbaliter"));
		verify(mock);
	}
	
	@Test
	public void MessengerTestConnection() throws MalformedRecipientException {
		expect(mock.checkConnection("czescwszystkim.com")).andReturn(ConnectionStatus.FAILURE).anyTimes();
		replay(mock);
		assertEquals(1, ms.testConnection("czescwszystkim.com"));
		verify(mock);
	}
	
	@Test
	public void MessengerTestConnection2() throws MalformedRecipientException {
		expect(mock.checkConnection("czescwszystkim.pl")).andReturn(ConnectionStatus.SUCCESS).anyTimes();
		replay(mock);
		assertEquals(0, ms.testConnection("czescwszystkim.pl"));
		verify(mock);
	}

}