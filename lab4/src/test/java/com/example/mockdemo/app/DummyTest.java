package com.example.mockdemo.app;

import static org.junit.Assert.*;
import org.junit.Test;

import com.example.mockdemo.messenger.MessageServiceSimpleImpl;

public class DummyTest {

	@Test
	public void testOk1() {
		MessageServiceSimpleImpl ms = new MessageServiceSimpleImpl();
		Messenger messenger = new Messenger(ms);
		assertEquals(0, messenger.testConnection("wp.pl"));
	}

	@Test
	public void testNotOk1() {
		MessageServiceSimpleImpl ms = new MessageServiceSimpleImpl();
		Messenger messenger = new Messenger(ms);
		assertEquals(1, messenger.testConnection("wp.com"));
	}

	@Test
	public void TestOk2() {
		MessageServiceSimpleImpl ms = new MessageServiceSimpleImpl();
		Messenger messenger = new Messenger(ms);
		assertEquals(0, messenger.testConnection("inf.ug.edu.pl"));
	}

	@Test
	public void TestNotOk2() {
		MessageServiceSimpleImpl ms = new MessageServiceSimpleImpl();
		Messenger messenger = new Messenger(ms);
		assertEquals(1, messenger.testConnection("inf.ug.edu"));
	}

	@Test
	public void sendMessageTest1() {
		MessageServiceSimpleImpl ms = new MessageServiceSimpleImpl();
		Messenger messenger = new Messenger(ms);
		assertEquals(1, messenger.sendMessage("inf.ug.edu", "foo"));
	}
	
	@Test
	public void sendMessageTest2() {
		MessageServiceSimpleImpl ms = new MessageServiceSimpleImpl();
		Messenger messenger = new Messenger(ms);
		assertEquals(2, messenger.sendMessage("inf.ug.edu", "fo"));
	}
	
	@Test
	public void sendMessageTest3() {
		MessageServiceSimpleImpl ms = new MessageServiceSimpleImpl();
		Messenger messenger = new Messenger(ms);
		assertEquals(0, messenger.sendMessage("inf.ug.edu.pl", "foo"));
	}
}
