package com.sunbeam;

public class DoublyCircularLinkedListMain {

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
		//l1.addPosition(70, 8);
		
		//l1.deleteFirst();
		//l1.deleteLast();
		
		//l1.deletePosition(3);
		//l1.deletePosition(1);
		//l1.deletePosition(6);
		l1.deletePosition(8);
		
		l1.fDisplay();
		l1.rDisplay();
		
		l1.deleteAll();

	}

}
