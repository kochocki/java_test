package com.example.mockdemo.app;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import org.easymock.EasyMockRule;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Rule;
import org.junit.Test;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;

public class EasyMockTest {
	@Rule
	public EasyMockRule mocks = new EasyMockRule(this);

	@Mock
	private MessageService mock;

	@TestSubject
	private Messenger messenger = new Messenger(mock);

	@Test
	public void testConnectionTest() {
		expect(mock.checkConnection("inf.ug.edu")).andReturn(
				ConnectionStatus.FAILURE);
		replay(mock);
		assertEquals(1, messenger.testConnection("inf.ug.edu"));
		verify(mock);
	}

	@Test
	public void testConnectionest2() {
		expect(mock.checkConnection("wp.pl")).andReturn(
				ConnectionStatus.SUCCESS);
		replay(mock);
		assertEquals(0, messenger.testConnection("wp.pl"));
		verify(mock);
	}

	@Test
	public void testConnectionTest3() {
		expect(mock.checkConnection("inf.ug.edu.pl")).andReturn(
				ConnectionStatus.SUCCESS);
		replay(mock);
		assertEquals(0, messenger.testConnection("inf.ug.edu.pl"));
		verify(mock);
	}

	@Test
	public void sendMessageTest() throws MalformedRecipientException {
		expect(mock.send("inf.ug.edu.pl", "foo")).andReturn(SendingStatus.SENT);
		replay(mock);
		assertEquals(0, messenger.sendMessage("inf.ug.edu.pl", "foo"));
		verify(mock);
	}

	@Test
	public void sendMessageTest2() throws MalformedRecipientException {
		expect(mock.send("i.", "foo")).andThrow(
				new MalformedRecipientException());
		replay(mock);
		assertEquals(2, messenger.sendMessage("i.", "foo"));
		verify(mock);
	}

	@Test
	public void sendMessageTest3() throws MalformedRecipientException {
		expect(mock.send("wp.pl", "fo")).andThrow(
				new MalformedRecipientException());
		replay(mock);
		assertEquals(2, messenger.sendMessage("wp.pl", "fo"));
		verify(mock);
	}

	@Test
	public void sendMessageTest4() throws MalformedRecipientException {
		expect(mock.send("wp", "fo")).andThrow(
				new MalformedRecipientException());
		replay(mock);
		assertEquals(2, messenger.sendMessage("wp", "fo"));
		verify(mock);
	}

	@Test
	public void sendMessageTest5() throws MalformedRecipientException {
		expect(mock.send("wp.pl", "foobar")).andReturn(
				SendingStatus.SENDING_ERROR);
		replay(mock);
		assertEquals(1, messenger.sendMessage("wp.pl", "foobar"));
		verify(mock);
	}
}
