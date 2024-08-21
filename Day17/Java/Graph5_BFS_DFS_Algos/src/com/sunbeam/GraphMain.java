package com.sunbeam;

import java.util.Scanner;

public class GraphMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter vertex count : " );
		int v = sc.nextInt();
		
		Graph g = new Graph(v);
		
		g.accept(sc);
		//g.print();
		
		//g.singleSourcePathLength(2);
		/*
		boolean ret = g.isConnected(5);
		if(ret)
			System.out.println("Graph is connected");
		else 
			System.out.println("Graph is not connected");
		
		ret = g.isBipartite(3);
		if(ret)
			System.out.println("Graph is bipartite");
		else 
			System.out.println("Graph is not bipartite");
			
			*/
		
		g.DFSSpaningTree(1);
		g.BFSSpanningTree(1);
		
		sc.close();
	}

}

/*
6
7
0 1
0 2
0 3
1 2
1 4
3 4
3 5

6
5
0 1
0 2
1 2
3 4
3 5

6
6
0 3
0 4
1 3
2 3
2 4
2 5


6
7
0 3
0 4
1 3
0 1
2 3
2 4
2 5



*/














