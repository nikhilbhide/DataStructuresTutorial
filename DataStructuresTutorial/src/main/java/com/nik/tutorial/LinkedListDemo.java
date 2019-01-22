package com.nik.tutorial;

import java.util.LinkedList;

public class LinkedListDemo {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList();
		list.add(10);
		list.add(20);
		list.addLast(30);
		list.addFirst(40);
		for(int num:list) {
			System.out.println("No is " + num);
		}
		list.forEach(n->System.out.println("Num is "+n));
	}
}