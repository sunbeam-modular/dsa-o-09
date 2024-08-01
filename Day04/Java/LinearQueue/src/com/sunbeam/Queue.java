package com.sunbeam;

public class Queue {
	private int arr[];
	private int front;
	private int rear;
	private final int SIZE;
	private int count;
	public Queue(int size) {
		SIZE = size;
		arr = new int[SIZE];
		front = rear = -1;
		count = 0;
	}
	
	public void push(int value) {
		//a. reposition rear
		rear = (rear+1) % SIZE;
		//b. add value at rear index
		arr[rear] = value;
		count++;
	}
	
	public int pop() {
		int temp = arr[front+1];
		//a. reposition front
		front = (front+1) % SIZE;
		count--;
		return temp;
	}
	
	public int peek() {
		//a. read/return value of front + 1 index
		return arr[(front+1)%SIZE];
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	public boolean isFull() {
		return count == SIZE;
	}
	
}














