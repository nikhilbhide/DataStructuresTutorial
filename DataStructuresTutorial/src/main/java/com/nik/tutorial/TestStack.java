package com.nik.tutorial;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class TestStack {
	private Integer[] stack;
	private int top = -1;

	private boolean isEmpty() {
		return top==-1;
	}

	private boolean isFull() {
		return top==stack.length-1;
	}

	public TestStack(int capacity) {
		stack = new Integer[capacity]; 
	}

	public boolean push(int element) {
		if(isFull()) {
			resize();
		} 

		top++;
		stack[top] = element;
		return true;
	}

	private void resize() {
		Integer[] newStack = new Integer[stack.length*2];
		System.arraycopy(stack, 0, newStack, 0, stack.length);
	}

	public int pop() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		else {
			int element = stack[top];
			top--;
			return element;
		}
	}

	public Integer[] getAll() {
		return Arrays.copyOfRange(stack, 0, top+1);
	}
}