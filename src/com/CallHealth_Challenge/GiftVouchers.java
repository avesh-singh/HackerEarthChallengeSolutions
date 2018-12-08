package com.CallHealth_Challenge;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * Distribute gifts the every kth passenger of flights
 * given that which two passengers are going to same flight
 * 
 * input: N M K
 * 		  6 3 2
 * 		  1 4
 * 		  5 4
 * 		  3 6
 * output: 2
 * 		   4 6
 * 
 * */


public class GiftVouchers {
	
	public static void print(Node[] conn){
		for(int i=0;i<conn.length;i++){
			System.out.print(conn[i]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
//		
//		int N = scan.nextInt();
//		int M = scan.nextInt();
//		int K = scan.nextInt();
		int N=6,M=3,K=2;
		Node[] connections = new Node[N+1];
		for(int n=0;n<=N;n++){
			connections[n] = new Node(n,-n);
		}
//		scan.next();
		int a=0,b=0;
		
		for(int i=0;i<M;i++){
			a = scan.nextInt();
			b = scan.nextInt();
			int temp = a;
			if(a>b){
				a = b;
				b = temp;
			}
			// now a<b
			if(connections[b].value>0){
				if(connections[b].value==a) continue;
				temp = a;
				a = b;
				b = temp;
				while(connections[b].value>0){
					b = connections[b].value;
				}
			}
			connections[b].value = a;
		}
//		print(connections);
		for(int i=1;i<=N;i++){
			for(int j=1;j<=N;j++){
				if(connections[j].value<0) continue;
				connections[j].value = connections[connections[j].value].value;
			}
		}
		Arrays.sort(connections);
//		print(connections);
		int count = 0,flight=connections[1].value,total=0;
		LinkedList<Node> result = new LinkedList<Node>();
		for(int i=1;i<=N;i++){
			if(connections[i].value!=flight){
				count=1;
				flight = connections[i].value;
			}
			else{
				count++;
				if(count%K==0){
					total++;
					result.add(connections[i]);
				}
			}
		}
		System.out.println(total);
		for(int i=0;i<result.size();i++){
			System.out.print(result.get(i).key+" ");
		}
		scan.close();
	}

}
