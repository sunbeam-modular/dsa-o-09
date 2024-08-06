package com.sunbeam;

public class SinglyLinearLinkedListMain {

	public static void main(String[] args) {
		
		List list = new List();
		
		list.addFirst(40);
		list.addFirst(30);
		list.addFirst(20);
		list.addFirst(10);
		
		// 10->20->30->40
		
		//list.addLast(50);
		//list.addLast(60);
		
		//list.deleteFirst();
		//list.deleteLast();
		
		//list.addPosition(50, 3);
		//list.addPosition(50, 1);
		//list.addPosition(50, -1);
		//list.addPosition(50, 4);
		//list.addPosition(50, 5);
		//list.addPosition(50, 6);
		
		//list.deletePosition(3);
		//list.deletePosition(1);
		//list.deletePosition(0);
		//list.deletePosition(4);
		list.deletePosition(5);
		
		list.display();

		list.deleteAll();
	}

}
