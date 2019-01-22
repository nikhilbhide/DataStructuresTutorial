package com.nik.tutorial.dsnalgo.linkedlist;

/**
 * The linked list class that provides implementation of following algorithms 
 * 1. Find the middle node of the linked list
 * 2.  
 * 
 * @author nikhil.bhide
 */
public class LinkedListAlgos {
	private Node root;
	private Node lastNode;

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public Node getLastNode() {
		return lastNode;
	}

	private void setLastNode(Node lastNode) {
		this.lastNode = lastNode;
	}

	/**
	 * Inserts input data into the linked list
	 * 
	 * @param data Number to be added 
	 * 
	 * @return The data is appended at the end of the linked list
	 */
	public boolean add(int data) {
		Node node = new Node(data);
		if(getRoot()==null) {
			root = node;
			lastNode = node;
		}
		else {
			lastNode.setNext(node);
			lastNode = node;
		}
		return true;
	}

	/**
	 * Identifies the middle node of the linked list
	 * 
	 * @return The middle node of the linked list
	 */
	public Node findMidNode() {
		Node firstCounter = root;
		return findMidNode(firstCounter,firstCounter);
	}

	/**
	 * This method keeps two counters. 
	 * First counter initially points to root node and initially second counter points to a node which is two places ahead of root counter.
	 * When secondCounter increments by two, firstCounter also increments by one.
	 * This continues until second counter reaches second counter can not look beyond two places ahead.
	 * At that point, firstCounter is at the middle of the linked list.
	 * 
	 * @param firstCounter The reference of first counter
	 * @param secondCounter The reference of second counter
	 * @return
	 */
	private Node findMidNode(Node firstCounter, Node secondCounter) {
		if(secondCounter.getNext()!=null) {
			if(secondCounter.getNext().getNext()!=null) {
				Node temp = secondCounter;
				secondCounter = secondCounter.getNext().getNext();
				firstCounter = firstCounter.getNext();
				return findMidNode(firstCounter,secondCounter);
			}
		}
		return firstCounter;
	}

	/**
	 * Find the nth node from the last node of the linked list.
	 * Find the length of the linked list and then starts traverse from root node for length - n + 1 nodes.
	 * 
	 * @param n The nth position from the end of the linked list
	 * 
	 * @return The nth node from the last node of the linked list
	 */
	public Node findNthNodeFromEnd(int n) {
		int size = 0;
		Node currentNode = getRoot();

		while(currentNode.getNext()!=null) {
			currentNode = currentNode.getNext();
			size ++;
		}

		//traverse from the front and traverse for (length - n + 1) 
		int traversalLength = size - n+1;
		int counter = 0;
		currentNode = getRoot();

		while(counter<traversalLength) {
			currentNode = currentNode.getNext();
			counter++;
		}
		
		return currentNode;
	}
}