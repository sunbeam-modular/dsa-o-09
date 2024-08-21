package com.sunbeam;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;



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
	
	public void singleSourcePathLength(int start) {
		//0. create queue to push vertices
		Queue<Integer> q = new LinkedList<Integer>();
		//0. create an array to mark vertices
		boolean marked[] = new boolean[vertexCount];
		//1. Create path length array to keep length of vertex from start vertex.
		int length[] = new int[vertexCount];
		//2. push start on queue, mark it and make length of it 0. 
		q.offer(start);			// push
		marked[start] = true;
		length[start] = 0;
		while(!q.isEmpty()) {
			//3. pop the vertex. 
			int u = q.poll();			// pop
			//4. push all its non-marked neighbors on the queue, mark them.
			for(int v = 0 ; v < vertexCount ; v++) {
				if(!marked[v] && adjMat[u][v]) {
					q.offer(v);
					marked[v] = true;
					//5. For each such vertex calculate length as length[neighbor] = length[current] + 1 
					length[v] = length[u] + 1;
					//6. print current vertex to that neighbor vertex edge.
					System.out.print("(" + u + "-" + v + ")");
				}
			}
		}//7. repeat steps 3-6 until queue is empty. 
		//8. Print path length array.
		System.out.println("\n Path lengths from start vertex: ");
		for(int i = 0 ; i < vertexCount ; i++) {
			System.out.println(start + "->" + i + "=" + length[i]);
		}

	}
	
	public boolean isConnected(int start) {
		//0. create stack to push vertices
		Stack<Integer> st = new Stack<Integer>();
		//0. create an array to mark vertices
		boolean marked[] = new boolean[vertexCount];
		//1. push start on stack & mark it. 
		st.push(start);
		marked[start] = true;
		//2. begin counting marked vertices from 1. 
		int count = 1;
		while(!st.isEmpty()) {
			//3. pop and print a vertex. 
			int u = st.pop();
			//4. push all its non-marked neighbors on the stack, mark them and increment count. 
			for(int v = 0 ; v < vertexCount ; v++) {
				if(!marked[v] && adjMat[u][v]) {
					st.push(v);
					marked[v] = true;
					count++;
				}
			}
			//5. if count is same as number of vertex, graph is connected (return). 
			if(count == vertexCount)
				return true;
		}//6. repeat steps 3-5 until stack is empty. 
		//7. graph is not connected (return)
		return false;
	}
	
	public boolean isBipartite(int start) {
		//0. create stack to push  vertices
		Stack<Integer> st = new Stack<Integer>();
		//0. create array to store colors : color1 = -1, color2 = 1, no color = 0
		//1. keep colors of all vertices in an array. Initially vertices have no color.
		int color[] = new int[vertexCount];
		//2. push start on stack & Assign it color1.
		st.push(start);
		color[start] = -1;
		while(!st.isEmpty()) {
			//3. pop the vertex.
			int u = st.pop();
			//4. push all its neighbors on the stack
			for(int v = 0 ; v < vertexCount ; v++) {
				if(adjMat[u][v]) {
					//5. For each such vertex if no color is assigned yet, assign opposite color of current vertex (c1-c2, c2-c1).
					if(color[v] == 0) {
						st.push(v);
						color[v] = color[u] * -1;
					}
					//6. If vertex is already colored with same of current vertex, graph is not bipartite (return).
					if(color[u] == color[v])
						return false;
				}
			}
		}//7. repeat steps 3-6 until stack is empty.
		return true;
	}
	
	public void DFSSpaningTree(int start) {
		//0. create stack to push vertices
		Stack<Integer> st = new Stack<Integer>();
		//0. create an array to mark vertices
		boolean marked[] = new boolean[vertexCount];
		//1. push starting vertex on stack & mark it.
		st.push(start);
		marked[start] = true;
		System.out.print("DFS Spanning Tree : ");
		while(!st.isEmpty()) {
			//2. pop the vertex.
			int u = st.pop();
			//3. push all its non-marked neighbors on the stack, mark them. 
			for(int v = 0 ; v < vertexCount ; v++) {
				if(!marked[v] && adjMat[u][v]) {
					st.push(v);
					marked[v] = true;
					//Also print the vertex to neighboring vertex edges.
					System.out.print("(" + u + "-" + v + ")");
				}
			}
		}//4. repeat steps 2-3 until stack is empty.
		System.out.println("");
	}
	
	public void BFSSpanningTree(int start) {
		//0. create queue to push vertices
		Queue<Integer> q = new LinkedList<Integer>();
		//0. create an array to mark vertices
		boolean marked[] = new boolean[vertexCount];
		//1. push starting vertex on queue & mark it.
		q.offer(start);
		marked[start] = true;
		System.out.print("BFS Spanning Tree : ");
		while(!q.isEmpty()) {
			//2. pop the vertex.
			int u = q.poll();
			//3. push all its non-marked neighbors on the queue, mark them. 
			for(int v = 0 ; v < vertexCount ; v++) {
				if(!marked[v] && adjMat[u][v]) {
					q.offer(v);
					marked[v] = true;
					//Also print the vertex to neighboring vertex edges.
					System.out.print("(" + u + "-" + v + ")");
				}
			}
		}//4. repeat steps 2-3 until queue is empty.
		System.out.println("");
	}
	
}


































