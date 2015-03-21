package com.example.mockdemo.app;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MessageService;

public class DynamicProxyTest {
	@Test
	public void testConnectionTest() {

		InvocationHandler ih = new IMessageServiceHandler();
		MessageService ms = (MessageService) Proxy.newProxyInstance(
				MessageService.class.getClassLoader(),
				new Class[] { MessageService.class }, ih);

		Messenger messenger = new Messenger(ms);

		assertEquals(0, messenger.testConnection("wp.pl"));
		assertEquals(1, messenger.testConnection("gfrtg.com"));
	}

	class IMessageServiceHandler implements InvocationHandler {

		@Override
		public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable {
			if ("testConnection".equals(method.getName())) {
				if (args[0].toString().endsWith(".pl"))
					return ConnectionStatus.SUCCESS;
				else return ConnectionStatus.FAILURE;
			}
			// if ("add".equals(method.getName())) {
			// return 5.0;
			// }
			return ConnectionStatus.FAILURE;
		}
	}
}
