package com.nik.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Test;

import com.nik.tutorial.TestStack;
import com.nik.tutorial.dsnalgo.AlgoDemo;

import junit.framework.Assert;

public class StackTest {

	@Test
	public void testStackPushSuccess() {
		TestStack instance = new TestStack(5);
		instance.push(10);
		instance.push(20);
		instance.push(30);
		Integer[] expectedStackArray = {10,20,30};
		assertArrayEquals(instance.getAll(), expectedStackArray);		
	}
	
	@Test
	public void testStackPopSuccess() {
		TestStack instance = new TestStack(5);
		instance.push(10);
		instance.push(20);
		instance.push(30);
		int element1 = instance.pop();
		int element2 = instance.pop();
		int element3 = instance.pop();
		Integer[] expected = {30,20,10};
		Integer[] result = {element1,element2,element3};
		assertArrayEquals(result, expected);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testStackPopNoSuchElementExceptionSuccess() {
		TestStack instance = new TestStack(5);
		instance.push(10);
		instance.push(20);
		instance.push(30);
		int element1 = instance.pop();
		int element2 = instance.pop();
		int element3 = instance.pop();
		int element4 = instance.pop();
	}
}