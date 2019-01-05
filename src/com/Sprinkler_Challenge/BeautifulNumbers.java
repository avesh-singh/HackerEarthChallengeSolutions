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

	private static List<Integer> beautyNums,result;
	
	private static void findRange(Long X){
		int p = 0;
		if(beautyNums.size()>X){
			result.add(findN(X));
			return;
		}
		while(Math.pow(2, p)<X){
			p++;
		}
		while(beautyNums.size()<=Math.pow(2, p)){
			beautyNums.add(0);
		}
		print();
		for(int i=0;i<Math.pow(2, p-1);i++){
			beautyNums.set((int)Math.pow(2, p-1)+i, beautyNums.get(i)+1);
		}
		result.add(findN(X));
	}
	
	private static int findN(Long X){
		Long sum = new Long(0);
		int i=0;
		while(sum<X){
			sum += beautyNums.get(i);
		}
		return i;
	}
	
	private static void print(){
		for(int i=0;i<beautyNums.size();i++){
			System.out.print(beautyNums.get(i));
		}
		System.out.println();
	}
	
//	private static Long sumArray(int end){
//		Long sum = new Long(0);
//		for(int i=0;i<end;i++){
//			sum += beautyNums.get(i);
//		}
//		return sum;
//	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		Long X;
		beautyNums = new ArrayList<>();
		beautyNums.add(0);beautyNums.add(1);
		result = new ArrayList<>();
		for(int i=0;i<T;i++){
			X = scan.nextLong();
			System.out.println(X);
			findRange(X);
		}
	}

}
