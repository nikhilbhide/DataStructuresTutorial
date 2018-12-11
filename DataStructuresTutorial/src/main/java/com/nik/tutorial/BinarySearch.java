package com.nik.tutorial;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearch {
	Node root = null;

	public BinarySearch(Integer[] array) {
		for(int num:array) {
			createBinarySearch(num);
		}
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public static void main(String[] args) {
		Integer[] array = {10,-100,50,-50,60,-80,40,30,70,90,55,58,62};
		BinarySearch instance = new BinarySearch(array);
		instance.searchNum(20);
		instance.searchNum(-100);
		instance.traversal();
		instance.traversal();
		instance.delete(instance.getRoot(), 60);
		System.out.println("After delete");
		instance.traversal();
		//Integer[] sortedArray = {-100,-50,-80,10,50,60};

		//instance.searchBinaryTreeUsingArray(sortedArray, 0, sortedArray.length-1, -80);
		//	instance.searchBinaryTreeUsingArray(sortedArray, 0, sortedArray.length-1, 50);
		//instance.searchBinaryTreeUsingArray(sortedArray, 0, sortedArray.length-1, 80);
	}	

	private boolean searchNum(int num) {
		return searchNum(root,num);
	}

	private boolean searchNum(Node node, int num) {
		if(node!=null && node.getElement().intValue()==num) {
			System.out.println("Number is found");
			return true;
		}
		else if (node.getElement().intValue()>num && node.getLeft()!=null) {
			return searchNum(node.getLeft(),num);
		}
		else if (node.getElement().intValue()<num && node.getRight()!=null) {
			return searchNum(node.getRight(),num);
		}
		else {
			System.out.println("Number could not be found");
			return false;
		}
	}

	private Boolean searchBinaryTreeUsingArray(Integer[] array, int start, int end, int numToSearch) {
		int midPoint = (start + end)/2;
		if(numToSearch == array[midPoint]) {
			System.out.format("\nNumber found at position %d",midPoint);
			return true;
		}
		else if(midPoint==start || midPoint==end) {
			System.out.format("\nNumber not found");
			return false;
		}
		else if(numToSearch < array[midPoint]) {
			return searchBinaryTreeUsingArray(array, start, midPoint-1, numToSearch);
		}
		else if(numToSearch > array[midPoint]) {
			return searchBinaryTreeUsingArray(array, midPoint+1, end, numToSearch);
		}
		else {
			System.out.format("\nNumber not found");
			return false;
		}
	}

	private Boolean createBinarySearch(int num) {
		if(root==null) {
			Node node = new Node(num);
			this.root = node;
			return true;
		}
		else {
			return root.insert(num);
		}		
	}	

	public void traversal() {
		List<Integer> resultList = new ArrayList();
		//inorderTraversal(root, resultList);
		//postorderTraversal(root, resultList);
		//preorderTraversal(root, resultList);
		Queue<Node> nodeQueue = new LinkedList();
		if(root!=null) {
			nodeQueue.add(root);
		}
		levelTraversal(nodeQueue, resultList);
		resultList.forEach(num->System.out.println(num));
	}

	private void inorderTraversal(Node currentNode, List<Integer> resultList) {
		if(currentNode.left!=null)
			inorderTraversal(currentNode.left, resultList);
		resultList.add(currentNode.element);
		if(currentNode.right!=null)
			inorderTraversal(currentNode.right, resultList);
	}

	private void postorderTraversal(Node currentNode, List<Integer> resultList) {
		if(currentNode.left!=null)
			postorderTraversal(currentNode.left, resultList);
		if(currentNode.right!=null)
			postorderTraversal(currentNode.right, resultList);
		resultList.add(currentNode.element);
	}

	private void preorderTraversal(Node currentNode, List<Integer> resultList) {
		resultList.add(currentNode.element);
		if(currentNode.left!=null)
			preorderTraversal(currentNode.left, resultList);
		if(currentNode.right!=null)
			preorderTraversal(currentNode.right, resultList);
	}

	private void levelTraversal(Queue<Node> nodeQueue, List<Integer> resultList) {
		if(!nodeQueue.isEmpty()) {
			Node currentNode = nodeQueue.remove();
			boolean flag = false;
			if(currentNode!=null) {
				resultList.add(currentNode.getElement());
				if(currentNode.getLeft()!=null) {
					nodeQueue.add(currentNode.getLeft());
					flag = true;
				}
				if(currentNode.getRight()!=null) {
					nodeQueue.add(currentNode.getRight());
					flag = true;
				}
				levelTraversal(nodeQueue,resultList);
			}
		}
	}

	public Node delete(Node currentNode, int num) {
		if(currentNode==null)
			return currentNode;
		else if(currentNode.getElement()>num) {
			currentNode.setLeft(delete(currentNode.getLeft(),num));
		}
		else if(currentNode.getElement()<num) {
			currentNode.setRight(delete(currentNode.getRight(),num));
		}
		else {
			if (currentNode.getLeft()==null) {
				return currentNode.getRight();
			}
			else if(currentNode.getLeft()==null) {
				return currentNode.getLeft();
			}
			else {
				currentNode.setElement(currentNode.getRight().getMin());
				currentNode.setRight(delete(currentNode.getRight(),currentNode.getElement()));
			}
		}
		return currentNode;
	}
}
