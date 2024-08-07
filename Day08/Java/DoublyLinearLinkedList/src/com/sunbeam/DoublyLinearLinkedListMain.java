package com.sunbeam;

public class DoublyLinearLinkedListMain {

	public static void main(String[] args) {


		List l1 = new List();
		
		l1.addFirst(40);
		l1.addFirst(30);
		l1.addFirst(20);
		l1.addFirst(10);
		
		l1.addLast(50);
		l1.addLast(60);
		
		//l1.addPosition(70, 3);
		//l1.addPosition(70, 1);
		//l1.addPosition(70, 7);
		//l1.addPosition(70, 0);
		//l1.addPosition(70, 9);
		
		//l1.deleteFirst();
		//l1.deleteLast();
		
		//l1.deletePosition(3);
		//l1.deletePosition(0);
		//l1.deletePosition(1);
		//l1.deletePosition(6);
		l1.deletePosition(7);
		
		l1.forwardDisplay();
		l1.reverseDisplay();
		System.out.println("Node count : " + l1.getCount());
		
		l1.deleteAll();
	}

}
