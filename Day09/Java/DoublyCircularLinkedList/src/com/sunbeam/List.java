package com.sunbeam;

public class List {
	static class Node{
		private int data;
		private Node next;
		private Node prev;
		public Node(int value) {
			data = value;
			next = prev = null;
		}
	}
	
	private Node head;
	public List() {
		head = null;
	}
	
	public void insert(Node after, Node newnode, Node before) {
		//1. add before node into next of newnode
		newnode.next = before;
		//2. add after node into prev of newnode
		newnode.prev = after;
		//3. add newnode into next of after node
		after.next = newnode;
		//4. add newnode into prev of before node
		before.prev = newnode;
	}
	
	public void addFirst(int value) {
		//1. create newnode
		Node newnode = new Node(value);
		//2. if list is empty
		if(head == null) {
			//a. add newnode into head
			head = newnode;
			//b. make list circular
			newnode.next = newnode.prev = newnode;
		}
		//3. if list is not empty
		else {
			//a. call insert 
			insert(head.prev, newnode, head);
			//b. move head on newnode
			head = newnode;
		}
	}
	
	public void addLast(int value) {
		//1. create newnode
		Node newnode = new Node(value);
		//2. if list is empty
		if(head == null) {
			//a. add newnode into head
			head = newnode;
			//b. make list circular
			newnode.next = newnode.prev = newnode;
		}
		//3. if list is not empty
		else {
			//a. call insert 
			insert(head.prev, newnode, head);
		}
	}
	
	public void addPosition(int value, int pos) {
		//1. create newnode
		Node newnode = new Node(value);
		//2. if list is empty
		if(head == null) {
			//a. add newnode into head
			head = newnode;
			//b. make list circular
			newnode.next = newnode.prev = head;
		}
		// special case
		if(pos <= 1) {
			addFirst(value);
		}
		//3. if list is not empty
		else {
			//a. traverse till pos-1 node
			Node trav = head;
										  //special case
			for(int i = 1 ; i < pos -1 && trav.next != head ; i++)
				trav = trav.next;
			//b. call insert method
			insert(trav, newnode, trav.next);
		}
	}
	
	public void delete(Node after, Node before) {
		//1. add before node into next of after node
		after.next = before;
		//2. add after node into prev of before node
		before.prev = after;
	}
	
	public void deleteFirst() {
		//1. if list is empty
		if(head == null)
			return;
		//2. if list has single node
		else if(head.next == head)
			head = null;
		//3. if list has multiple nodes
		else {
			//a. call delete method
			delete(head.prev, head.next);
			//b. move head on second node
			head = head.next;
		}
	}
	
	public void deleteLast() {
		//1. if list is empty
		if(head == null)
			return;
		//2. if list has single node
		else if(head.next == head)
			head = null;
		//3. if list has multiple nodes
		else {
			//a. call delete method
			delete(head.prev.prev, head);
		}
	}

	public void deletePosition(int pos) {
		//1. if list is emtpy
		if(head == null)
			return;
		//2. if list has single node
		else if(head.next == head)
			head = null;
		else if(pos <= 1)
			deleteFirst();
		//3. if list has multiple nodes
		else {
			//a. traverse till pos node	
			Node trav = head;
			for(int i = 1 ; i < pos && trav.next != head ; i++)
				trav = trav.next;
			//a. call delete method
			delete(trav.prev, trav.next);
		}
	}

	public void fDisplay() {
		//0. if list is empty
		if(head == null)
			return;
		//1. start at first node
		Node trav = head;
		System.out.print("Forward List : ");
		do {
			//2. print current node (trav.data)
			System.out.print(" " + trav.data);
			//3. go on next node (trav.next)
			trav = trav.next;
		}while(trav != head);//4. repeat step 2 and 3 till last node
		System.out.println("");
	}
	
	public void rDisplay() {
		//0. if list is empty
		if(head == null)
			return;
		//1. start at last node
		Node trav = head.prev;
		System.out.print("Reverse List : ");
		do {
			//2. print current node (trav.data)
			System.out.print(" " + trav.data);
			//3. go on prev node (trav.next)
			trav = trav.prev;
		}while(trav != head.prev);//4. repeat step 2 and 3 till first node
		System.out.println("");
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void deleteAll() {
		head = null;
	}
	
}











