package com.sunbeam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Graph {
	static class Adjacent{
		private int dest;
		private int wt;
		public Adjacent(int d, int w) {
			dest = d;
			wt = w;
		}
	}
	
	private int vertexCount;
	private int edgeCount;
	private List<Adjacent> adjList[];
	public Graph(int vCount) {
		vertexCount = vCount;
		adjList = new List[vertexCount];
		for(int i = 0 ; i < vertexCount ; i++)
			adjList[i] = new ArrayList<Adjacent>();
	}
	
	public void accept(Scanner sc) {
		System.out.print("Enter Edge count: ");
		edgeCount = sc.nextInt();
		System.out.println("Enter Edges (src, dest, wt) : ");
		for(int i = 0 ; i < edgeCount ; i++) {
			int src = sc.nextInt();
			int dest = sc.nextInt();
			int wt = sc.nextInt();
			adjList[src].add(new Adjacent(dest, wt));
			adjList[dest].add(new Adjacent(src, wt));		//comment this line if graph is directed graph
		}
	}
	
	public void print() {
		System.out.println("Graph : ");
		for(int i = 0 ; i < vertexCount ; i++) {
			System.out.print(i + " : ");
			for(Adjacent a : adjList[i]) {
				System.out.print("(" + a.dest + "," + a.wt + " )");
			}
			System.out.println("");
		}
	}
	

}









