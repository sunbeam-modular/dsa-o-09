package com.sunbeam;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BSTree {
	static class Node{
		private int data;
		private Node left;
		private Node right;
		public Node(int value) {
			data = value;
			left = right = null;
		}
	}

	private Node root;
	public BSTree() {
		root = null;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public void addNode(int value) {
		//1. create node with given value
		Node newnode = new Node(value);
		//2. if BST is empty
		if(isEmpty())
			//add newnode into root itself
			root = newnode;
		//3. if BST is not empty
		else {
			//3.1  create trav and start at root node
			Node trav = root;
			while(true) {
				//3.2 if value is less than current data (trav.data)
				if(value < trav.data) {
					//3.2.1 if left of current node is empty
					if(trav.left == null) {
						// add newnode into left of current node
						trav.left = newnode;
						break;
					}
					//3.2.2 if left of current node is not empty
					else
						// go into left of current node
						trav = trav.left;
				}
				//3.3 if value is greater or eqaul than current data (trav.data)
				else {
					//3.3.1 if right of current node is empty
					if(trav.right == null) {
						// add newnode into right of current node
						trav.right = newnode;
						break;
					}
					//3.3.2 if right of current node is not empty
					else
						// go into right of current node
						trav = trav.right;
				}
			}//3.4 repeat step 3.2 or 3.3 untill node is added into BST
		}
	}
	
	private void preorder(Node trav) {
		if(trav == null)
			return;
		System.out.print(" " + trav.data);	// V
		preorder(trav.left);	// L
		preorder(trav.right);	// R
	}
	
	public void preorder() {				// wrapper method
		System.out.print("Preorder : ");
		preorder(root);
		System.out.println("");
	}
	
	private void inorder(Node trav) {
		if(trav == null)
			return;
		inorder(trav.left);	// L
		System.out.print(" " + trav.data);	// V
		inorder(trav.right);	// R
	}
	
	public void inorder() {				// wrapper method
		System.out.print("Inorder : ");
		inorder(root);
		System.out.println("");
	}
	
	private void postorder(Node trav) {
		if(trav == null)
			return;
		postorder(trav.left);	// L
		postorder(trav.right);	// R
		System.out.print(" " + trav.data);	// V
	}
	
	public void postorder() {				// wrapper method
		System.out.print("Postorder : ");
		postorder(root);
		System.out.println("");
	}
	
	public void DFSTraversal() {
		//0. create stack to push nodes
		Stack<Node> st = new Stack<BSTree.Node>();
		//1. push root on stack
		st.push(root);
		System.out.print("DFS Traversal : ");
		while(!st.isEmpty()) {
			//2. pop node from stack
			Node trav = st.pop();
			//3. visit poped node
			System.out.print(" " + trav.data);
			//4. if popped node has right
			if(trav.right != null)
				// push it on stack
				st.push(trav.right);
			//5. if poped node has left
			if(trav.left != null)
				// push it on stack
				st.push(trav.left);
		}//6. repeat step 2 to 5 till stack iss not empty 
		System.out.println("");
	}
	
	public void BFSTraversal() {
		Queue<Node> q = new LinkedList<BSTree.Node>();
		//1. push root on queue
		q.offer(root);
		System.out.print("BFS Traversal : ");
		while(!q.isEmpty()) {	
			//2. pop node from queue
			Node trav = q.poll();
			//3. visit poped node
			System.out.print(" " + trav.data);
			//5. if poped node has left
			if(trav.left != null)
				// push it on queue
				q.offer(trav.left);
			//4. if popped node has right
			if(trav.right != null)
				// push it on queue
				q.offer(trav.right);
		}//6. repeat step 2 to 5 till stack iss not empty 
		System.out.println("");
	}
	
	public Node searchNode(int key) {
		//1. start from root
		Node trav = root;
		while(trav != null) {
			//2. if key is equal to current data
			if(key == trav.data)
				//return current node
				return trav;
			//3. if key is less than current data
			if(key < trav.data)
				// search key into left of current node
				trav = trav.left;
			//4. if key is greater than current data
			else
				// search key into right of current node
				trav = trav.right;
		}//5. repeat step 2 to 4 till leaf nodes 
		//6. key is not found
		return null;
	}
	
	public void deleteNode(int key) {
		
	}
	
	public void deleteAll() {
		root = null;
	}
	
}














