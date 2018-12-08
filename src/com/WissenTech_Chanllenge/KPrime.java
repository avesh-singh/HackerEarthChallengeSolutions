package com.WissenTech_Chanllenge;

import java.util.Arrays;
import java.util.Scanner;

public class KPrime {

	private static int N,K;
	private static int[] A;
	public boolean isPrime(int n){
		if(n<=1) return false;
		if(n==2 || n==3) return true;
		
		if(n%2==0 || n%3==0) return false;
		for(int i=5;i*i<=n;i+=6){
			if(n%i==0 || n % (i+2)==0) return false;
		}
		return true;
	}
	
	public int convertToKPrime(){
		int[] operations = new int[N];
		for(int i=0;i<N;i++){
			operations[i] = nearestPrime(A[i])-A[i];
		}
//		print(operations);
		Arrays.sort(operations);
		int result=0;
		for(int i=0;i<K;i++){
			result+=operations[i];
		}
		return result;
	}
	
	public void print(int[] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	public int nearestPrime(int a){
		if(a<=2) return 2;
		if(a==3) return 3;
		int k=(a-a%6)/6;
		while(true){
			if(6*k-1 >= a) return 6*k-1;
			k++;
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
	    K = scan.nextInt();
		A = new int[N];
		for(int i=0;i<N;i++){
			A[i] = scan.nextInt();
		}
		KPrime kp = new KPrime();
		System.out.println(kp.convertToKPrime());
//		System.out.println(kp.nearestPrime(14));
		scan.close();
	}

//	4 3
//	2 8 1 14
}
