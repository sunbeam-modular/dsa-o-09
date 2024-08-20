package com.sunbeam;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

import javax.management.Query;

public class Graph {
	private int vertexCount;
	private int edgeCount;
	private boolean adjMat[][];
	public Graph(int vCount) {
		vertexCount = vCount;
		adjMat = new boolean[vertexCount][vertexCount];
	}
	
	public void accept(Scanner sc) {
		System.out.print("Enter Edge count: ");
		edgeCount = sc.nextInt();
		System.out.println("Enter Edges (src, dest) : ");
		for(int i = 0 ; i < edgeCount ; i++) {
			int src = sc.nextInt();
			int dest = sc.nextInt();
			adjMat[src][dest] = true;
			adjMat[dest][src] = true;		//comment this line if graph is directed graph
		}
	}
	
	public void print() {
		System.out.println("Graph : ");
		for(int i = 0 ; i < vertexCount ; i++) {
			for(int j = 0 ; j < vertexCount ; j++) {
				System.out.print(adjMat[i][j] ? 1 + " ": 0 + " ");
			}
			System.out.println("");
		}
	}
	
	public void DFSTraversal(int start) {
		//0. create statck to push vertices
		Stack<Integer> st = new Stack<Integer>();
		//0. create an array to mark vertices
		boolean marked[] = new boolean[vertexCount];
		//1. Choose a vertex as start vertex. --> start
		//2. Push start vertex on stack & mark it. 
		st.push(start);
		marked[start] = true;
		System.out.print("DFS Traversal : ");
		while(!st.isEmpty()) {
			//3. Pop vertex from stack. 
			int u = st.pop();
			//4. Print the vertex.
			System.out.print(" " + u);
			//5. Put all non-visited neighbours of the vertex on the stack and mark them. 
			for(int v = 0 ; v < vertexCount ; v++) {
				if(!marked[v] && adjMat[u][v]) {
					st.push(v);
					marked[v] = true;
				}
			}
		}//6. Repeat 3-5 until stack is empty.
		System.out.println("");
	}
	
	public void BFSTraversal(int start) {
		//0. Create queue to push vertices
		Queue<Integer> q = new LinkedList<Integer>();
		//0. Create an array to mark vertices
		boolean marked[] = new boolean[vertexCount];
		//1. Choose a vertex as start vertex. - start
		//2. Push start vertex on queue & mark it 
		q.offer(start);
		marked[start] = true;
		System.out.print("BFS Traversal : ");
		while(!q.isEmpty()) {
			//3. Pop vertex from queue. 
			int u = q.poll();
			//4. Print the vertex. 
			System.out.print(" " + u);
			//5. Put all non-visited neighbours of the vertex on the queue and mark them. 
			for(int v = 0 ; v < vertexCount ; v++) {
				if(!marked[v] && adjMat[u][v]) {
					q.offer(v);
					marked[v] = true;
				}
			}
		}//6. Repeat 3-5 until queue is empty.
		System.out.println("");
	}
	

}
















