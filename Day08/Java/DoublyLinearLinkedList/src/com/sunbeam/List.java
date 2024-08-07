package com.sunbeam;

public class List {
	static class Node{
		private int data;
		private Node next;
		private Node prev;
		public Node(int value) {
			data = value;
			next = null;
			prev = null;
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
		return head == null;
	}
	
	public void addFirst(int value) {
		//1. create node for data
		Node newnode = new Node(value);
		//2. if list is empty
		if(head == null)
			// add newnode into head and tail
			head = tail = newnode;
		//3. if list is not empty
		else {
			//a. add first node into next of newnode
			newnode.next = head;
			//b. add newnode into prev of first node
			head.prev = newnode;
			//c. move head on newnode
			head = newnode;
		}
		count++;
	}
	
	public void addLast(int value) {
		//1. create node for data
		Node newnode = new Node(value);
		//2. if list is empty
		if(head == null)
			// add newnode into head and tail
			head = tail = newnode;
		//3. if list is not empty
		else {
			//a. add last node into prev of newnode
			newnode.prev = tail;
			//b. add newnode into next iof last node
			tail.next = newnode;
			//c. move tail on newnode
			tail = newnode;
		}
		count++;
	}
	
	public void addPosition(int value, int pos) {
		if(pos < 1 || pos > count+1) {
			System.out.println("Invalid position is given");
			System.out.println("Valid positions : " + 1 + " to " + (count + 1));
			return;
		}
		//1. create node
		Node newnode = new Node(value);
		//2. if list is empty
		if(head == null)
			// add newnode into head and tail
			head = tail = newnode;
		else if(pos == 1) {
			addFirst(value);
			return;
		}
		else if(pos == count+1) {
			addLast(value);
			return;
		}
		//3. if list is not empty
		else {
			//a. traverse till pos-1 node
			Node trav = head;
			for(int i = 1 ; i < pos-1 ; i++)
				trav = trav.next;
			//b. add pos node into next of newnode
			newnode.next = trav.next;
			//c. add pos-1 node into prev of newnode
			newnode.prev = trav;
			//d.  add newnode into prev of pos node
			trav.next.prev = newnode;
			//e. add newnode into next of pos-1 node
			trav.next = newnode;
		}
		count++;
	}
	
	public void deleteFirst() {
		//1. if list is empty
		if(head == null)
			return;
		//2. if list has single node
		if(head.next == null)
			head = tail = null;
		//3. if list has multiple nodes
		else {
			//a. move head on second node
			head = head.next;
			//b. make prev of second node equal to null
			head.prev = null;
		}
		count--;
	}
	
	public void deleteLast() {
		//1. if list is empty
		if(head == null)
			return;
		//2. if list has single node
		if(head.next == null)
			head = tail = null;
		//3. if list has multiple nodes
		else {
			//a. move tail on second last node
			tail = tail.prev;
			//b. make next of second last node equal to null
			tail.next = null;
		}
		count--;
	}
	
	public void deletePosition(int pos) {
		if(pos < 1 || pos > count)
			return;
		//1. if list is empty
		if(head == null)
			return;
		//2. if list has single node
		if(head.next == null)
			head = tail = null;
		else if(pos == 1) {
			deleteFirst();
			return;
		}
		else if(pos == count) {
			deleteLast();
			return;
		}
		//3. if list has multiple nodes
		else {
			//a. traverse till pos node
			Node trav = head;
			for(int i = 1 ; i < pos ; i ++)
				trav = trav.next;
			//b. add pos+1 node into next of pos-1 node
			trav.prev.next = trav.next;
			//c. add pos-1 node into prev of pos+1 node
			trav.next.prev = trav.prev;
		}
		count--;
	}
	
	public void forwardDisplay() {
		// forward display
		//1. create trav and start at first node
		Node trav = head;
		System.out.print("Forward List : ");
		while(trav != null) {
			//2. print/visit current node(trav.data)
			System.out.print(" " + trav.data);
			//3. go on next node(trav.next)
			trav = trav.next;
		}//4. repeat step 2 and 3 till last node
		System.out.println("");
	}
	
	public void reverseDisplay() {
		// reverse display
		//1. create trav and start at last node
		Node trav = tail;
		System.out.print("Reverse List : ");
		while(trav != null) {
			//2. print/visit current node(trav.data)
			System.out.print(" " + trav.data);
			//3. go on prev node(trav.prev)
			trav = trav.prev;
		}//4. repeat step 2 and 3 till first node
		System.out.println("");
	}
	
	public int getCount() {
		return count;
	}
	
	public void deleteAll() {
		head = tail = null;
		count = 0;
	}
}
















