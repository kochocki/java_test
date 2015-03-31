package com.example.mockdemo.app;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;

public class MockitoTest {
	@Mock
	private MessageService mock = mock(MessageService.class);

	private Messenger messenger = new Messenger(mock);

	@Test
	public void testConnectionTest() {
		when(mock.checkConnection("inf.ug.edu")).thenReturn(
				ConnectionStatus.FAILURE);
		assertEquals(1, messenger.testConnection("inf.ug.edu"));
	}

	@Test
	public void testConnectionest2() {
		when(mock.checkConnection("wp.pl"))
				.thenReturn(ConnectionStatus.SUCCESS);

		assertEquals(0, messenger.testConnection("wp.pl"));

	}

	@Test
	public void testConnectionTest3() {
		when(mock.checkConnection("inf.ug.edu.pl")).thenReturn(
				ConnectionStatus.SUCCESS);

		assertEquals(0, messenger.testConnection("inf.ug.edu.pl"));

	}

	@Test
	public void sendMessageTest() throws MalformedRecipientException {
		when(mock.send("inf.ug.edu.pl", "foo")).thenReturn(SendingStatus.SENT);

		assertEquals(0, messenger.sendMessage("inf.ug.edu.pl", "foo"));

	}

	@Test
	public void sendMessageTest2() throws MalformedRecipientException {
		when(mock.send("i.", "foo"))
				.thenThrow(new MalformedRecipientException());

		assertEquals(2, messenger.sendMessage("i.", "foo"));

	}

	@Test
	public void sendMessageTest3() throws MalformedRecipientException {
		when(mock.send("wp.pl", "fo")).thenThrow(
				new MalformedRecipientException());

		assertEquals(2, messenger.sendMessage("wp.pl", "fo"));

	}

	@Test
	public void sendMessageTest4() throws MalformedRecipientException {
		when(mock.send("wp", "fo")).thenThrow(new MalformedRecipientException());

		assertEquals(2, messenger.sendMessage("wp", "fo"));

	}

	@Test
	public void sendMessageTest5() throws MalformedRecipientException {
		when(mock.send("wp.pl", "foobar")).thenReturn(
				SendingStatus.SENDING_ERROR);

		assertEquals(1, messenger.sendMessage("wp.pl", "foobar"));

	}
}
