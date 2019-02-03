package com.Sprinkler_Challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Problem: Define beauty = total 1s in binary representation of given integer
 * Find min int N such that sum of beauty nums of 1 to N is atleast X
 * Input:
 * T
 * T lines of Xs
 * eg:
 * i/p:
 * 2
 * 11
 * 5
 * o/p:
 * 7
 * 4 
 * */
public class BeautifulNumbers {

	private static List<Integer> beautyNums,sums;
	
	private static void findRange(Long X){
		int p = 0;
		// if size of beautyNums array>X, then we already have beauty number in the array
		// just findN
		if(beautyNums.size()>X){
			System.out.println(findN(X));
//			result.add(findN(X));
			return;
		}
		while(Math.pow(2, p)<X){
			p++;
		}
		while(beautyNums.size()<Math.pow(2, p)){
			beautyNums.add(0);
		}
		int t = p-1;
		// finding t to determine which additional beautyNums we have to find now
		while(beautyNums.get((int)Math.pow(2, t)-1)==0){
			t--;
		}
		for(int j=t;j<=p;j++){
//			System.out.println(Math.pow(2, j-1));
			for(int i=0;i<Math.pow(2, j-1);i++){
				beautyNums.set((int)Math.pow(2, j-1)+i, beautyNums.get(i)+1);
			}
//			print();
		}
		System.out.println(findN(X));
//		result.add(findN(X));
	}
	
	private static int findN(Long X){
		Long sum = new Long(0);
		int i=sums.size();
//		System.out.println(X);
		while(i>0 && sums.get(i-1)>=X){
			
		}
		while(sum<X){
			sum += beautyNums.get(i);
//			System.out.print(sum+" ");
			i++;
		}
//		System.out.println();
		return i-1;
	}
	
	private static void print(List<Integer> list,String delim){
		for(int i=0;i<list.size();i++){
			System.out.print(list.get(i)+delim);
		}
		System.out.println();
	}
		
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		Long X;
		beautyNums = new ArrayList<>();
		sums = new ArrayList<>();
		beautyNums.add(0);beautyNums.add(1);
		for(int i=0;i<T;i++){
			X = scan.nextLong();
			findRange(X);
		}
		print(beautyNums," ");
//		print(result,"\n");
		scan.close();
	}

}
