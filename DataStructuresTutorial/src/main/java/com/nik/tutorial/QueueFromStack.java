package com.nik.tutorial;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * This class provides implementation of building queue from stack.
 *
 * @author nikhil.bhide
 *
 * @param <T> The type of the element
 */
public class QueueFromStack<T> {
	private Stack<T> stackInstance1;
	private Stack<T> stackInstance2;

	/**
	 * Constructor definition
	 */
	public QueueFromStack() {
		stackInstance1 = new Stack();
		stackInstance2 = new Stack();		
	}

	/**
	 * Provides implementation of remove operation
	 * Remove operation is performed on stackInstance2.
	 * 
	 * @return T the element removed from stackInstance2
	 */
	public T remove() {
		if(length()==0) {
			//if both stacks do not contain any element
			throw new NoSuchElementException();
		}
		else {
			//if elements exist on the first stack
			//Perform pop operation on stack1 until it becomes empty and copy all elements to stack2
			if(stackInstance2.isEmpty()) {
				while(!stackInstance2.isEmpty()) {
					stackInstance2.push(stackInstance1.pop());
				}
			}

			T element = stackInstance2.pop();
			return element;
		}
	}

	/**
	 * Its based on two stacks. Push operation is performed on stack1 and pop operation is performed on stack2.
	 * @param element The element to be added to the queue
	 * 
	 * @return <code> true </code> if add operation is successful
	 * 
	 */
	public boolean add(T element) {
		stackInstance1.push(element);
		return true;
	}

	/**
	 * Find out length of stack
	 * 
	 * @return the size of overall stack (stack1 + stack2)
	 * 
	 */
	public int length() {
		return stackInstance1.size() + stackInstance2.size();
	}
}