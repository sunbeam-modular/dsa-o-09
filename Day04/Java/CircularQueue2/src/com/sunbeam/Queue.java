package com.sunbeam;

public class Queue {
	private int arr[];
	private int front, rear;
	private final int SIZE;
	public Queue(int size) {
		SIZE = size;
		arr = new int[SIZE];
		front = rear = -1;
	}
	
	public void push(int value) {
		//a. reposition rear
		rear = (rear + 1) % SIZE;
		//b. add value at rear index
		arr[rear] = value;
	}
	
	public void pop() {
		//a. reposition front
		front = (front + 1) % SIZE;
		//b. if queue becomes empty then move front and rear at -1
		if(front == rear)
			front = rear = -1;
	}
	
	public int peek() {
		//a. read/return value from front end (front + 1)
		return arr[(front + 1) % SIZE];
	}
	
	public boolean isEmpty() {
		return front == rear && rear == -1;
	}
	
	public boolean isFull() {
		return (front == -1 && rear == SIZE-1) || (front == rear && rear != -1);
	}
}















