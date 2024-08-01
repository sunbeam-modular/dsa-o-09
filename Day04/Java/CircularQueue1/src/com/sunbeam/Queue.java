package com.sunbeam;

public class Queue {
	private int arr[];
	private int front;
	private int rear;
	private final int SIZE;
	public Queue(int size) {
		SIZE = size;
		arr = new int[SIZE];
		front = rear = -1;
	}
	
	public void push(int value) {
		//a. reposition rear
		rear++;
		//b. add value at rear index
		arr[rear] = value;
	}
	
	public int pop() {
		int temp = arr[front+1];
		//a. reposition front
		front++;
		return temp;
	}
	
	public int peek() {
		//a. read/return value of front + 1 index
		return arr[front+1];
	}
	
	public boolean isEmpty() {
		return front == rear;
	}
	
	public boolean isFull() {
		return rear == SIZE-1;
	}
	
}














