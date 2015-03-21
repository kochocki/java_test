package com.example.mockdemo.app;

import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

import org.junit.Test;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;

public class DynamicProxyTest {
	@Test
	public void ConnectionStatusTest() {
		InvocationHandler ih = new IMessageServiceHandler();
		MessageService ms = (MessageService) Proxy.newProxyInstance(
				MessageService.class.getClassLoader(),
				new Class[] { MessageService.class }, ih);
		Messenger messenger = new Messenger(ms);

		assertEquals(0, messenger.testConnection("wp.pl"));
	}

	@Test
	public void ConnectionStatusTest2() {
		InvocationHandler ih = new IMessageServiceHandler();
		MessageService ms = (MessageService) Proxy.newProxyInstance(
				MessageService.class.getClassLoader(),
				new Class[] { MessageService.class }, ih);
		Messenger messenger = new Messenger(ms);

		assertEquals(1, messenger.testConnection("inf.ug.edu.com"));
	}

	@Test
	public void ConnectionStatusTest3() {
		InvocationHandler ih = new IMessageServiceHandler();
		MessageService ms = (MessageService) Proxy.newProxyInstance(
				MessageService.class.getClassLoader(),
				new Class[] { MessageService.class }, ih);
		Messenger messenger = new Messenger(ms);

		assertEquals(0, messenger.testConnection("inf.ug.edu.pl"));
	}

	@Test
	public void sendStatusTest1() {
		InvocationHandler ih = new IMessageServiceHandler();
		MessageService ms = (MessageService) Proxy.newProxyInstance(
				MessageService.class.getClassLoader(),
				new Class[] { MessageService.class }, ih);
		Messenger messenger = new Messenger(ms);

		assertThat(messenger.sendMessage("inf.ug.edu.pl", "foo"), either(is(0)).or(is(1)));
	}

	@Test
	public void sendStatusTest2() {
		InvocationHandler ih = new IMessageServiceHandler();
		MessageService ms = (MessageService) Proxy.newProxyInstance(
				MessageService.class.getClassLoader(),
				new Class[] { MessageService.class }, ih);
		Messenger messenger = new Messenger(ms);

		assertThat(messenger.sendMessage("wp.pl", "fo"), either(is(1)).or(is(2)));
	}

	@Test
	public void sendStatusTest3() {
		InvocationHandler ih = new IMessageServiceHandler();
		MessageService ms = (MessageService) Proxy.newProxyInstance(
				MessageService.class.getClassLoader(),
				new Class[] { MessageService.class }, ih);
		Messenger messenger = new Messenger(ms);

		assertThat(messenger.sendMessage("w.", "foobar"), either(is(1)).or(is(2)));
	}

	public void sendStatusTest4() {
		InvocationHandler ih = new IMessageServiceHandler();
		MessageService ms = (MessageService) Proxy.newProxyInstance(
				MessageService.class.getClassLoader(),
				new Class[] { MessageService.class }, ih);
		Messenger messenger = new Messenger(ms);

		assertThat(messenger.sendMessage("w.pl", "foo"), either(is(0)).or(is(1)));
	}

	class IMessageServiceHandler implements InvocationHandler {

		@Override
		public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable {
			Random random = new Random();
			if ("checkConnection".equals(method.getName())) {
				if (args[0].toString().endsWith(".pl"))
					return ConnectionStatus.SUCCESS;
				else
					return ConnectionStatus.FAILURE;
			}

			if ("send".equals(method.getName())) {
				boolean connection = random.nextBoolean();
				if ((connection && args[0].toString().length() >= 4)
						&& (args[0].toString().endsWith(".pl"))
						&& args[1].toString().length() >= 3)
					return SendingStatus.SENT;
				else if (!connection)
					return SendingStatus.SENDING_ERROR;
				else throw new MalformedRecipientException();
			}

			return null;
		}
	}
}
