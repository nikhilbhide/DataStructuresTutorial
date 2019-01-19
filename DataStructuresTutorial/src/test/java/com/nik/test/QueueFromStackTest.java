package com.nik.test;

import java.util.NoSuchElementException;
import org.junit.Assert;
import org.junit.Test;
import com.nik.tutorial.QueueFromStack;

public class QueueFromStackTest {
	@Test
	public void testSimpleQueueSuccess() {
		QueueFromStack<String> instance = new QueueFromStack();
		instance.add("Rabbit");
		instance.add("Tortoise");
		instance.add("Lion");
		Assert.assertEquals("Rabbit", instance.remove());
		Assert.assertEquals("Tortoise", instance.remove());
		Assert.assertEquals("Lion", instance.remove());
	}
	
	@Test (expected=NoSuchElementException.class)
	public void testQueueEmptyException() {
		QueueFromStack<String> instance = new QueueFromStack();
		instance.add("Rabbit");
		instance.add("Tortoise");
		instance.add("Lion");
		Assert.assertEquals("Rabbit", instance.remove());
		Assert.assertEquals("Tortoise", instance.remove());
		Assert.assertEquals("Lion", instance.remove());
		instance.remove();
	}
	

	@Test
	public void testComplexQueueSuccess() {
		QueueFromStack<String> instance = new QueueFromStack();
		instance.add("Rabbit");
		instance.add("Tortoise");
		instance.add("Lion");
		Assert.assertEquals("Rabbit", instance.remove());
		Assert.assertEquals("Tortoise", instance.remove());
		instance.add("Elephant");
		instance.add("Dino");
		Assert.assertEquals("Lion", instance.remove());
		Assert.assertEquals("Elephant", instance.remove());
	}
}