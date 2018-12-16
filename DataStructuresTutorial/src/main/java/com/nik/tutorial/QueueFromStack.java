package com.nik.tutorial;

import java.util.NoSuchElementException;
import java.util.Stack;

public class QueueFromStack<T> {
	private Stack<T> stackInstance1;
	private Stack<T> stackInstance2;

	public QueueFromStack() {
		stackInstance1 = new Stack();
		stackInstance2 = new Stack();		
	}

	public T remove() {
		if(stackInstance1.isEmpty() && stackInstance2.isEmpty()) {
			throw new NoSuchElementException();
		}
		else {
			while(!stackInstance1.isEmpty()) {
				stackInstance2.push(stackInstance1.pop());
			}
			return stackInstance2.pop();
		}
	}

	public boolean add(T element) {
		stackInstance1.push(element);
		return true;
	}
	
	public int length() {
		return stackInstance1.size() + stackInstance2.size();
	}
}