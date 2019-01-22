package com.nik.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.nik.tutorial.dsnalgo.linkedlist.LinkedListAlgos;
import com.nik.tutorial.dsnalgo.linkedlist.Node;

public class LinkedListAlgoTest {
	private LinkedListAlgos instance;
	
	@Before
	public void init() {
		instance = new LinkedListAlgos();
	}
	
	@After
	public void tearDown() {
		instance = null;
	}
	
	
	@Test
	public void testFindMiddleOfNodeSimpleLinkedListSuccess() {
		instance.add(10);
		instance.add(20);
		instance.add(30);
		Node midNode = instance.findMidNode();
		Assert.assertTrue(midNode.getData()==20);
	}
	
	@Test
	public void testFindMiddleOfNodeComplexLinkedListSuccess() {
		instance.add(10);
		instance.add(20);
		instance.add(30);
		instance.add(40);
		instance.add(50);
		instance.add(60);
		instance.add(70);
		instance.add(80);
		instance.add(90);
		instance.add(100);

		Node midNode = instance.findMidNode();
		Assert.assertTrue(midNode.getData()==50);
	}
	
	@Test
	public void testFindMiddleOfNodeComplexOddLinkedListSuccess() {
		instance.add(10);
		instance.add(20);
		instance.add(30);
		instance.add(40);
		instance.add(50);
		instance.add(60);
		instance.add(70);
		instance.add(80);
		instance.add(90);
		instance.add(100);
		instance.add(110);
		instance.add(120);
		instance.add(130);
		instance.add(140);
		instance.add(150);

		Node midNode = instance.findMidNode();
		Assert.assertTrue(midNode.getData()==80);
	}
	
	@Test
	public void testNthNodeFromEndComplexListSuccess() {
		instance.add(10);
		instance.add(20);
		instance.add(30);
		instance.add(40);
		instance.add(50);
		instance.add(60);
		instance.add(70);
		instance.add(80);
		instance.add(90);
		instance.add(100);
		instance.add(110);
		instance.add(120);
		instance.add(130);
		instance.add(140);
		instance.add(150);

		Node midNode = instance.findNthNodeFromEnd(6);
		Assert.assertTrue(midNode.getData()==100);
	}
	
	@Test
	public void testNthNodeFromEndOfListEvenSizedSuccess() {
		instance.add(10);
		instance.add(20);
		instance.add(30);
		instance.add(40);
		instance.add(50);
		instance.add(60);
		instance.add(70);
		instance.add(80);
		instance.add(90);
		instance.add(100);

		Node midNode = instance.findNthNodeFromEnd(10);
		Assert.assertTrue(midNode.getData()==10);
	}
}