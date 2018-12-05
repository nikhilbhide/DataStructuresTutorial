package com.nik.tutorial;

public class Node {
	public Node(int item) {
		element = new Integer(item);
	}

	public Boolean insert(int num) {
		if(num<=element.intValue()) {
			if(this.left==null) {
				Node node = new Node(num);
				this.setLeft(node);
			}
			else {
				this.left.insert(num);
			}
		}
		else {
			if(this.right==null) {
				Node node = new Node(num);
				this.setRight(node);
			}
			else {
				this.right.insert(num);
			}
		}
		return true;
	}

	Integer element = null;
	public Integer getElement() {
		return element;
	}
	public void setElement(Integer element) {
		this.element = element;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	Node left = null;
	Node right = null;	
}
