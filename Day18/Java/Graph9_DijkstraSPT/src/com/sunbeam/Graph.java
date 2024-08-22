package com.sunbeam;

import java.util.Scanner;

public class Graph {
	static class Table{
		private boolean spt[];
		private int parents[];
		private int dist[];
		public Table(int vCount) {
			spt = new boolean[vCount];
			parents = new int[vCount];
			dist = new int[vCount];
			for(int i = 0 ; i < vCount ; i++) {
				spt[i] = false;
				parents[i] = -1;
				dist[i] = INF;
			}
		}
		
		public int findMinDistVertex(int vCount){
			int minDist = INF, minDistVertex = -1;
			for(int i = 0 ; i < vCount ; i++){
				if(!spt[i] && dist[i] < minDist){
					minDist = dist[i];
					minDistVertex = i;
				}
			}
			return minDistVertex;
		}
		
		public void printSPT(int vCount, int start) {
			System.out.println("Dijkstra's SPT :");
			for(int i = 0 ; i < vCount ; i++) {
				System.out.println(start + "-" + i + ":" + dist[i]);
			}
		}
		
	}
	private static final int INF = 999;
	private int vertexCount;
	private int edgeCount;
	private int adjMat[][];
	public Graph(int vCount) {
		vertexCount = vCount;
		adjMat = new int[vertexCount][vertexCount];
		for(int i = 0 ; i < vertexCount ; i++) {
			for(int j = 0 ; j < vertexCount ; j++)
				adjMat[i][j] = INF;
		}
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
	
	public void dijkstrsSPT(int start) {
		//0. create table to mark spt, parent and dists of vertices
		Table tbl = new Table(vertexCount);
		//1. choose start vertex and make its key equal to 0
		//start
		tbl.dist[start] = 0;
		//2.While spt doesn't include all the vertices
		int count = 0;
		while(count < vertexCount) {
			//3. find minimum key vertex which is not added into spt
			int u = tbl.findMinDistVertex(vertexCount);
			//4. add min key vertex into mst
			tbl.spt[u] = true;
			//5. increment count of mst vertices
			count++;
			//6. update keys and parents of adjacent vertices which are node added into MST
			for(int v = 0 ; v < vertexCount ; v++) {
				if(!tbl.spt[v] && adjMat[u][v] != INF && tbl.dist[u] + adjMat[u][v] < tbl.dist[v]) {
					tbl.dist[v] = tbl.dist[u] + adjMat[u][v];
					tbl.parents[v] = u;
				}
			}
		}
		//7. print MST and return wt of it
		tbl.printSPT(vertexCount, start);
	}
	

}









