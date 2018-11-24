package com.GE_Challenge;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class PalindromicCuts {
	
	private String input;
	private int len;
	private SubstringSlicing slice;
	private HashMap<String,Integer> palindromes;
	private int[][] pals;
	public PalindromicCuts(String st){
		input = st;
		len = st.length();
		palindromes = new HashMap<String,Integer>();
		pals = new int[len][len];
		for(int i=0;i<len;i++){
			for(int j=0;j<len;j++){
				if(i==j) pals[i][j] = 1;
				else pals[i][j] = -1;
			}
		}
		slice = new SubstringSlicing(input);
	}
	
//	public int cuts(int start, int end, int k){
////		System.out.println("cuts("+start+","+end+","+k+")");
////		if(len-start<=k && k!=0){
////			return 0;
////		}
//		if(start==end){
//			return 1;
//		}else if(start>end || k<0 ){
//			return 0;
//		}else if(k==0){
////			System.out.println(input.substring(start, end+1)+" "+k);
//			String temp = input.substring(start, end+1);
//			if(palindromes.containsKey(temp)){
//				return palindromes.get(temp);
//			}else{
//				palindromes.put(temp, slice.palindrome(input.substring(start, end+1))?1:0);
//			}
//			return slice.palindrome(input.substring(start, end+1))?1:0;
//		}else if(k>0){
//			System.out.println(input.substring(start, start+1) + "|"+input.substring(start+1, end+1));
//			return result(start,end,k);
//		}
//		return 0;
//	}
	
	public int result(int start,int end, int k){
		int sum = 0;
		for(int i=start;i<=end-k;i++){
			for(int j=i;j<=end-k;j++){
				System.out.println("cuts("+i+","+j+",0) + cuts("+(j+1)+","+(len-1)+","+(k-1)+")");
				System.out.print(input.substring(i, j+1)+"|");
				sum = sum + cuts(i,j,0) + cuts(j+1,len-1,k-1);
//				System.out.println("sum "+sum);
				
			}
		}
		return sum;
	}
	
	public int cuts(int start, int end, int k){
		if(k==0){
//		System.out.println(input.substring(start, end+1)+" "+k);
		String temp = input.substring(start, end+1);
		if(pals[start][end]!=-1){
			return pals[start][end];
		}else{
			pals[start][end] = slice.palindrome(input.substring(start, end+1))?1:0;
		}
		return pals[start][end];
		}
		else return 0;
	}
	
	public void getMap(){
		for (String name: palindromes.keySet()){

            String key =name.toString();
            String value = palindromes.get(name).toString();  
            System.out.println(key + " " + value);  
		}
	}
}
