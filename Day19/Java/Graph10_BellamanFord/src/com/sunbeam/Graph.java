package com.sunbeam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Graph {
	
	static class Edge{
		private int src, dest, wt;
		public Edge() {
			src = dest = wt = 0;
		}
		public Edge(int s, int d, int w) {
			src = s;
			dest = d;
			wt = w;
		}
	}
	
	private final int INF = 999;
	private int vertexCount;
	private int edgeCount;
	private int adjMat[][];
	private List<Edge> edgeList;
	
	public Graph(int vCount) {
		vertexCount = vCount;
		adjMat = new int[vertexCount][vertexCount];
		for(int i = 0 ; i < vertexCount ; i++) {
			for(int j = 0 ; j < vertexCount ; j++)
				adjMat[i][j] = INF;
		}
		edgeList = new ArrayList<Graph.Edge>();
	}
	
	public void accept(Scanner sc) {
		System.out.print("Enter Edge count: ");
		edgeCount = sc.nextInt();
		System.out.println("Enter Edges (src, dest, wt) : ");
		for(int i = 0 ; i < edgeCount ; i++) {
			int src = sc.nextInt();
			int dest = sc.nextInt();
			int wt = sc.nextInt();
			adjMat[src][dest] = wt;
			//adjMat[dest][src] = wt;		//comment this line if graph is directed graph
			edgeList.add(new Edge(src, dest, wt));
		}
	}
	
	public void print() {
		System.out.println("Graph : ");
		for(int i = 0 ; i < vertexCount ; i++) {
			for(int j = 0 ; j < vertexCount ; j++) {
				System.out.print(adjMat[i][j] + "\t");
			}
			System.out.println("");
		}
	}
	
	public void bellamanFord(int start) {
		//1. create an array to maintain distances of all the vertices
		int dist[] = new int[vertexCount];
		//2. Initialize distances of all vertices to INF and start vertex to 0
		for(int i = 0 ; i < vertexCount ; i++)
			dist[i] = INF;
		dist[start] = 0;
		//3 relax all the edges V-1 times
		for(int i = 0 ; i < vertexCount-1 ; i++) {
			//3.1 for each edge update distance of dest
			for(Edge e : edgeList) {
				int u = e.src, v = e.dest, wt = e.wt;
				if(dist[u] != INF && dist[u] + wt < dist[v]) {
					dist[v] = dist[u] + wt;
				}
			}
		}
		//4. relax one more time to detect -ve edge cycle
		for(Edge e : edgeList) {
			int u = e.src, v = e.dest, wt = e.wt;
			if(dist[u] != INF && dist[u] + wt < dist[v]) {
				System.out.println("Graph has -ve edge cycle");
				return;
			}
		}
		//5. print shortest distances of all vertices from start vertex
		System.out.println("Shortest distances : ");
		for(int i = 0 ; i < vertexCount ; i++)
			System.out.println(start + "-" + i + ":" + dist[i]);
	}

}
























