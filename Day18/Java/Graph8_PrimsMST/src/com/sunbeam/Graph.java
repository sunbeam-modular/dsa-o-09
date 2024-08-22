package com.sunbeam;

import java.util.Scanner;

public class Graph {
	static class Table{
		private boolean mst[];
		private int parents[];
		private int keys[];
		public Table(int vCount) {
			mst = new boolean[vCount];
			parents = new int[vCount];
			keys = new int[vCount];
			for(int i = 0 ; i < vCount ; i++) {
				mst[i] = false;
				parents[i] = -1;
				keys[i] = INF;
			}
		}
		
		public int findMinKeyVertex(int vCount){
			int minKey = INF, minKeyVertex = -1;
			for(int i = 0 ; i < vCount ; i++){
				if(!mst[i] && keys[i] < minKey){
					minKey = keys[i];
					minKeyVertex = i;
				}
			}
			return minKeyVertex;
		}
		
		public int printMST(int vCount) {
			int wt = 0;
			System.out.println("primsMST : ");
			for(int i = 0 ; i < vCount ; i++) {
				System.out.print("(" + parents[i] + "-" + i + ")");
				wt += keys[i];
			}
			System.out.println("");
			return wt;
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
			adjMat[dest][src] = wt;		//comment this line if graph is directed graph
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
	
	public int primsMST(int start) {
		//0. create table to mark mst, parent and keys of vertices
		Table tbl = new Table(vertexCount);
		//1. choose start vertex and make its key equal to 0
		//start
		tbl.keys[start] = 0;
		//2.While mst doesn't include all the vertices
		int count = 0;
		while(count < vertexCount) {
			//3. find minimum key vertex which is not added into mst
			int u = tbl.findMinKeyVertex(vertexCount);
			//4. add min key vertex into mst
			tbl.mst[u] = true;
			//5. increment count of mst vertices
			count++;
			//6. update keys and parents of adjacent vertices which are node added into MST
			for(int v = 0 ; v < vertexCount ; v++) {
				if(!tbl.mst[v] && adjMat[u][v] != INF && adjMat[u][v] < tbl.keys[v]) {
					tbl.keys[v] = adjMat[u][v];
					tbl.parents[v] = u;
				}
			}
		}
		//7. print MST and return wt of it
		return tbl.printMST(vertexCount);
	}
	

}









