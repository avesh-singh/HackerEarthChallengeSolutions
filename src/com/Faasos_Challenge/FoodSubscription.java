package com.Faasos_Challenge;

import java.util.Scanner;

public class FoodSubscription {

	public static void print(int[] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] A = new int[N];
		for(int i=0;i<N;i++){
			A[i] = scan.nextInt();
		}
		scan.close();
		if(N>23){
			System.out.println(2499);
			return;
		}
		if(N<4){
			System.out.println(199*N);
			return;
		}
		int week[] = new int[N];
		for(int i=0;i<N;i++){
			week[i]=i;
		}
		int i=0,j=1,size=0,cost=0;
		while(j<N){
			if(A[j]-A[i]<=7){
				week[j] = week[i];
				j++;
			}else{
				cost+=199;
				i++;
				size=0;
				j++;
			}
		}
		System.out.println(cost);
		
	}
	
}
