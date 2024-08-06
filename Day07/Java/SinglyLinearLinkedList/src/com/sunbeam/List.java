package com.sunbeam;

public class List {
	static class Node{
		private int data;
		private Node next;
		public Node(int value) {
			data = value;
			next = null;
		}
	}
	
	private Node head;
	public List() {
		head = null;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void addFirst(int value) {
		//1. create newnode with given data/value
		Node newnode = new Node(value);
		//2. add first node into next of newnode
		newnode.next = head;
		//3. move head on newnode
		head = newnode;
	}
	
	public void addLast(int value) {
		//1. create newnode with given data
		Node newnode = new Node(value);
		//2. if list is empty
		if(isEmpty())
			// add newnode into head itself
			head = newnode;
		//3. if list is not empty
		else {
			//a. traverse till last node
			Node trav = head;
			while(trav.next != null)
				trav = trav.next;
			//b. add newnode into next of last
			trav.next = newnode;
		}
	}
	
	public void addPosition(int value, int pos) {
		//1. create node with given data
		Node newnode = new Node(value);
		//2. if list is empty
		if(isEmpty())
			// add newnode into head itself
			head = newnode;
		//special case 1 : pos <= 1
		else if(pos <= 1) {
			newnode.next = head;
			head = newnode;
		}
		//3. if list is not empty
		else {
			//a. traverse till pos - 1 node
			Node trav = head;
										// special case 2 : pos > count+1
			for(int i = 1 ; i < pos - 1 && trav.next != null ; i++)
				trav = trav.next;
			//b. add pos node into next of newnode
			newnode.next = trav.next;
			//c. add newnode into next of pos-1 node
			trav.next = newnode;
		}
	}
	
	public void deleteFirst() {
		//1. if list is empty
		if(isEmpty())
			return ;
		//2. if list is not empty
		else
			//a. move head on second node
			head = head.next;
	}
	
	public void deleteLast() {
		//1. if list is empty
		if(isEmpty())
			return;
		//2. if list has single node
		else if(head.next == null)
			head = null;
		//3. if list has multiple nodes
		else {
			//a. traverse till second last node
			Node trav = head;
			while(trav.next.next != null)
				trav = trav.next;
			//b. make next of second last node null
			trav.next = null;
		}
	}
	
	public void deletePosition(int pos) {
		//1. if list is empty
		if(isEmpty())
			return;
		//2. if list has single node
		else if(head.next == null)
			head = null;
		// special case 1 : pos <= 1
		else if(pos <= 1) {
			head = head.next;
		}
		//3. if list has multiple nodes
		else {
			//a. traverse till pos-1 node
			Node trav = head;
										// special case 2 : pos > count
			for(int i = 1 ; i < pos-1 && trav.next.next != null ; i++)
				trav = trav.next;
			//b. add pos+1 node into next of pos-1 node
			trav.next = trav.next.next;
		}
	}
	
	public void display() {
		//1. create trav referance and start at first node
		Node trav = head;
		System.out.print("List :: ");
		while(trav != null) {
			//2. print/visit current node (trav.data)
			System.out.print(" " + trav.data);
			//3. go on next node (trav.next)
			trav = trav.next;
		}//4. repeat step 2 and 3 till last node
		System.out.println("");
	}
	
	public void deleteAll() {
		head = null;
	}
	
}










