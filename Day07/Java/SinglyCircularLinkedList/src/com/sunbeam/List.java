package com.sunbeam;

public class List {
	static class Node{
		private char data;
		private Node next;
		public Node(char value) {
			data = value;
			next = null;
		}
	}
	
	private Node head;
	private Node tail;
	private int count;
	public List() {
		head = tail = null;
		count = 0;
	}
	
	public boolean isEmpty() {
		return head == null && tail == null;
		// return count == 0;
	}
	
	public void addFirst(char value) {
		//1. create node with value
		Node newnode = new Node(value);
		//2. if list is empty
		if(isEmpty()) {
			//a. add newnode into head and tail
			head = tail = newnode;
			//b. make list circular
			newnode.next = newnode;
		}
		//3. if list is not empty
		else {
			//a. add first node into next of newnode
			newnode.next = head;
			//b. add newnode into next of last node
			tail.next = newnode;
			//c. move head on newnode
			head = newnode;
		}
		count++;
	}
	
	public void addLast(char value) {
		//1. create node with value
		Node newnode = new Node(value);
		//2. if list is empty
		if(isEmpty()) {
			//a. add newnode into head and tail
			head = tail = newnode;
			//b. make list circular
			newnode.next = newnode;
		}
		//3. if list is not empty
		else {
			//a. add first node into next of newnode
			newnode.next = head;
			//b. add newnode into next of last node
			tail.next = newnode;
			//c. move tail on newnode
			tail = newnode;
		}
		count++;
	}
	
	public void addPosition(char value, int pos) {
		// valid positions : 1 >= pos <= count + 1
		// invalid positions : 1 < pos > count + 1
		if(pos < 1 || pos > count + 1)
			return;
		//1. create node with given data
		Node newnode = new Node(value);
		//2. if list is empty
		if(isEmpty()) {
			// add newnode into head and tail itself
			head = tail = newnode;
			// make list circular
			newnode.next = newnode;
		}
		// special case : pos is 1
		else if(pos == 1) {
			addFirst(value);
			return;
		}
		//3. if list is not empty
		else {
			//a. traverse till pos - 1 node
			Node trav = head;
			for(int i = 1 ; i < pos - 1 ; i++)
				trav = trav.next;
			//b. add pos node into next of newnode
			newnode.next = trav.next;
			//c. add newnode into next of pos-1 node
			trav.next = newnode;
			//special case : if pos is count + 1
			if(trav == tail)
				tail = newnode;
		}
		count++;
	}
	
	public void deleteFirst() {
		//1. if list is empty
		if(isEmpty())
			return;
		//2. if list has single node
		else if(head == tail)
			head = tail = null;
		//3. if list has multiple nodes
		else {
			//a. add second node into next of last node
			tail.next = head.next;
			//b. move head on second node
			head = head.next;
		}
		count--;
	}
	
	public void deleteLast() {
		//1. if list is empty
		if(isEmpty())
			return;
		//2. if list has single node
		else if(head == tail)
			head = tail = null;
		//3. if list has multiple nodes
		else {
			//a. traverse till second last node
			Node trav = head;
			while(trav.next.next != head)
				trav = trav.next;
			//b. add first node into next of second last node
			trav.next = head;
			//c. move tail on second last node
			tail = trav;
		}
		count--;
	}
	
	public void display() {
		//0 if list is empty
		if(isEmpty())
			return;
		//1. create trav and start at head
		Node trav = head;
		System.out.print("List :: ");
		do {
			//2. print data of current node
			System.out.print(" " + trav.data);
			//3. go on next node
			trav = trav.next;
		}while(trav != head);	//4. repeat step 2 and 3 till last node
		System.out.println("");
		System.out.println("Last node : " + tail.data);
	}
	
	public int getCount() {
		return count;
	}
	
	public void deleteAll() {
		head = tail = null;
		count = 0;
	}
}












