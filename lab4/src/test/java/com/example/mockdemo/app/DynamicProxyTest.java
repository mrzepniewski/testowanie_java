package com.example.mockdemo.app;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;


import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.MessageServiceSimpleImpl;
import com.example.mockdemo.messenger.SendingStatus;

public class DynamicProxyTest {

	@Test
	public void checkSendingMessage() {

		InvocationHandler ih = new MessageServiceHandler();
		
		MessageService msMock = (MessageService) Proxy.newProxyInstance(
				MessageService.class.getClassLoader(),
				new Class[] { MessageService.class }, ih);
		

		Messenger ms = new Messenger(msMock);

		assertEquals(0, ms.sendMessage("czescwszystkim.pl","odpowiednialiczbaliter"));
	}
	
	class MessageServiceHandler implements InvocationHandler {

		@Override
		public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable {
			if ("checkConnection".equals(method.getName())) {
				return ConnectionStatus.SUCCESS;
			}
			if ("send".equals(method.getName())) {
				return SendingStatus.SENT;
			}

			return -1;
		}
	}
	
	@Test
	public void checkSendingMessage2() {

		InvocationHandler ih = new MessageServiceHandler2();
		
		MessageService msMock = (MessageService) Proxy.newProxyInstance(
				MessageService.class.getClassLoader(),
				new Class[] { MessageService.class }, ih);
		

		Messenger ms = new Messenger(msMock);

		assertEquals(2, ms.sendMessage(null,null));
	}
	
	class MessageServiceHandler2 implements InvocationHandler {

		@Override
		public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable {
			if ("checkConnection".equals(method.getName())) {
				return ConnectionStatus.FAILURE;
			}
			if ("send".equals(method.getName())) {
				throw new MalformedRecipientException();
			}

			return -1;
		}
	}
		@Test
		public void checkSendingMessage3() {

			InvocationHandler ih = new MessageServiceHandler3();
			
			MessageService msMock = (MessageService) Proxy.newProxyInstance(
					MessageService.class.getClassLoader(),
					new Class[] { MessageService.class }, ih);
			

			Messenger ms = new Messenger(msMock);

			assertEquals(2, ms.sendMessage("czescwszystkim.pl","1"));
		}
		
		class MessageServiceHandler3 implements InvocationHandler {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				if ("checkConnection".equals(method.getName())) {
					return ConnectionStatus.SUCCESS;
				}
				if ("send".equals(method.getName())) {
					throw new MalformedRecipientException();
				}

				return -1;
			}
	}
		
		@Test
		public void checkSendingMessage4() {

			InvocationHandler ih = new MessageServiceHandler4();
			
			MessageService msMock = (MessageService) Proxy.newProxyInstance(
					MessageService.class.getClassLoader(),
					new Class[] { MessageService.class }, ih);
			

			Messenger ms = new Messenger(msMock);

			assertEquals(1, ms.sendMessage("czescwszystkim.com","odpowiednialiczbaliter"));
		}
		
		class MessageServiceHandler4 implements InvocationHandler {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				if ("checkConnection".equals(method.getName())) {
					return ConnectionStatus.FAILURE;
				}
				if ("send".equals(method.getName())) {
					return SendingStatus.SENDING_ERROR;
				}

				return -1;
			}
	}
		
		@Test
		public void checkTestConnection() {

			InvocationHandler ih = new MessageServiceHandler5();
			
			MessageService msMock = (MessageService) Proxy.newProxyInstance(
					MessageService.class.getClassLoader(),
					new Class[] { MessageService.class }, ih);
			

			Messenger ms = new Messenger(msMock);

			assertEquals(1, ms.testConnection("czescwszystkim.com"));
		}
		
		class MessageServiceHandler5 implements InvocationHandler {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				if ("checkConnection".equals(method.getName())) {
					return ConnectionStatus.FAILURE;
				}

				return -1;
			}
		}
		@Test
		public void checkTestConnection2() {

			InvocationHandler ih = new MessageServiceHandler6();
			
			MessageService msMock = (MessageService) Proxy.newProxyInstance(
					MessageService.class.getClassLoader(),
					new Class[] { MessageService.class }, ih);
			

			Messenger ms = new Messenger(msMock);

			assertEquals(0, ms.testConnection("czescwszystkim.pl"));
		}
		
		class MessageServiceHandler6 implements InvocationHandler {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				if ("checkConnection".equals(method.getName())) {
					return ConnectionStatus.SUCCESS;
				}

				return -1;
			}
		}
	
}
