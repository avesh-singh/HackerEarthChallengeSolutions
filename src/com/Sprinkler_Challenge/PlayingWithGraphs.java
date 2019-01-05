package com.Sprinkler_Challenge;

import java.util.Scanner;

/**
 * Input: N - nodes
 * 		N space separated integers
 * 		Q - No of queries
 * 		Next Q lines contain query of types
 * 		1 X - move from X node till you reach at end point/if loop print LOOP
 * 		2 X - remove the outgoing edge from node X
 * Output:
 * 	type 1 query - end node or LOOP
 * 	type 2 no o/p
 * 
 * Test case:
 * i/p:
 * 3
 * 2 3 1
 * 6
 * 1 2
 * 2 1
 * 1 2
 * 1 1
 * 2 2
 * 1 2
 * o/p:
 * LOOP
 * 1
 * 1
 * 2
 * */
public class PlayingWithGraphs {

	private static void traverse(int[] graph,int start){
		int current = start;
		boolean[] visited = new boolean[graph.length];
		while(graph[current]!=0){
			if(visited[current]){
				System.out.println("LOOP");
				return;
			}
			visited[current] = true;
			current = graph[current];
		}
		System.out.println(current);
	}
	
	private static void removeEdge(int[] graph,int node){
		graph[node] = 0;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] graph = new int[N+1];
		graph[0] = 0;
		for(int i=1;i<=N;i++){
			graph[i] = scan.nextInt();
		}
		int Q = scan.nextInt();
		scan.nextLine();
		for(int i=0;i<Q;i++){
			if(scan.nextInt()==1){
				traverse(graph,scan.nextInt());
			}else{
				removeEdge(graph,scan.nextInt());
			}
		}
	}

}
