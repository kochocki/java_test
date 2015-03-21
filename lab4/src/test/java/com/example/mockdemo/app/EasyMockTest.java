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
	private Messenger Messenger = new Messenger(mock);

	@Test
	public void checkConnectionTest() {
		expect(mock.checkConnection("inf.ug.edu")).andReturn(
				ConnectionStatus.FAILURE);
		replay(mock);
		assertEquals(ConnectionStatus.FAILURE,
				mock.checkConnection("inf.ug.edu"));
		verify(mock);
	}

	@Test
	public void checkConnectionTest2() {
		expect(mock.checkConnection("wp.pl")).andReturn(
				ConnectionStatus.SUCCESS);
		replay(mock);
		assertEquals(ConnectionStatus.SUCCESS, mock.checkConnection("wp.pl"));
		verify(mock);
	}

	@Test
	public void checkConnectionTest3() {
		expect(mock.checkConnection("inf.ug.edu.pl")).andReturn(
				ConnectionStatus.SUCCESS);
		replay(mock);
		assertEquals(ConnectionStatus.SUCCESS,
				mock.checkConnection("inf.ug.edu.pl"));
		verify(mock);
	}

	@Test
	public void sendTest() throws MalformedRecipientException {
		expect(mock.send("inf.ug.edu.pl", "foo")).andReturn(SendingStatus.SENT);
		replay(mock);
		assertEquals(SendingStatus.SENT, mock.send("inf.ug.edu.pl", "foo"));
		verify(mock);
	}

	@Test(expected = MalformedRecipientException.class)
	public void sendTest2() throws MalformedRecipientException {
		expect(mock.send("i.", "foo")).andThrow(
				new MalformedRecipientException());
		replay(mock);
		mock.send("i.", "foo");
		verify(mock);
	}
	
	@Test(expected = MalformedRecipientException.class)
	public void sendTest3() throws MalformedRecipientException {
		expect(mock.send("wp.pl", "fo")).andThrow(
				new MalformedRecipientException());
		replay(mock);
		mock.send("wp.pl", "fo");
		verify(mock);
	}
	
	@Test(expected = MalformedRecipientException.class)
	public void sendTest4() throws MalformedRecipientException {
		expect(mock.send("wp", "fo")).andThrow(
				new MalformedRecipientException());
		replay(mock);
		mock.send("wp", "fo");
		verify(mock);
	}
	
	@Test
	public void sendTest5() throws MalformedRecipientException {
		expect(mock.send("wp.pl", "foobar")).andReturn(
				SendingStatus.SENDING_ERROR);
		replay(mock);
		assertEquals(SendingStatus.SENDING_ERROR, mock.send("wp.pl", "foobar"));
		verify(mock);
	}
}
