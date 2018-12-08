package com.WissenTech_Chanllenge;

import java.util.Scanner;

public class LIS {

	private static int N,Q;
	private static String input;
	public static void getLIS(char[] input){
		
	}
	
	public static void replace(char[] input,char c,int id){
		input[id-1] = c;
	}
	
	public static void print(char[] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]);
		}
		System.out.println();
	}
	// to do later
	public static void takeInput(){
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		System.out.println(scan.hasNextLine());
		String input = scan.nextLine();
		scan.next();
//		System.out.println(scan.hasNextLine());
		char[] sequence = input.toCharArray();
//		System.out.println(scan.hasNextInt());
		int Q = scan.nextInt();
//		System.out.println(scan.hasNextInt());
		for(int i=0;i<Q;i++){
//			System.out.println("in loop ");
			System.out.println(scan.nextLine());
			String[] temp = scan.nextLine().split(" ");
//			System.out.println(temp[0]);
//			for(int j=0;j<temp.length;j++){
//				System.out.print(temp[j]);
//			}
			if(Integer.parseInt(temp[0])==1){
				System.out.println(temp[0]);
				replace(sequence,temp[1].charAt(0),Integer.parseInt(temp[2]));
			}
			if(Integer.parseInt(temp[0])==2){
				getLIS(sequence);
			}
		}
		scan.close();
	}
	
	public static void main(String[] args) {
		N = 8;
		Q = 3;
		input = "aabccaee";
		char[] sequence = input.toCharArray();
		getLIS(sequence);
		replace(sequence,'d',6);
		print(sequence);
		getLIS(sequence);
	}

}
