package com.sunbeam;

public class SinglyCircularLinkedListMain {

	public static void main(String[] args) {
	
		List list = new List();
		
		
		list.addFirst('a');
		list.addFirst('s');
		list.addFirst('d');
		
		list.addLast('m');
		list.addLast('o');
		list.addLast('d');
		list.addLast('u');
		list.addLast('l');
		list.addLast('e');
		list.addLast('r');
		
		//list.addPosition('-', 4);
		//list.addPosition('-', 0);
		//list.addPosition('-', 12);
		//list.addPosition('-', 1);
		//list.addPosition('-', 11);
		
		//list.deleteFirst();
		//list.deleteLast();
		
		//list.deletePosition(3);
		//list.deletePosition(0);
		//list.deletePosition(11);
		//list.deletePosition(1);
		//list.deletePosition(9);
		list.deletePosition(10);
		
		list.display();
		System.out.println("Node count : " + list.getCount());
		
		list.deleteAll();
	}

}
