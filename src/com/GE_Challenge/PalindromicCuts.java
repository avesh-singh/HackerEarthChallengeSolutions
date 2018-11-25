package com.GE_Challenge;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

final class triplet{
	public int i;
	public int j;
	public int k;
	
	public triplet(int i,int j, int k){
		this.i = i;
		this.j = j;
		this.k = k;
	}

	@Override
	public String toString() {
		return "[" + i + "," + j + "," + k + "]";
	}
	
	
}

public class PalindromicCuts {
	
	private String input;
	private int len,k;
	private SubstringSlicing slice;
	private Queue<triplet> palindromes;
	private int[][] pals;
	public PalindromicCuts(String st,int k){
		input = st;
		len = st.length();
		this.k = k;
		palindromes = new LinkedList<triplet>();
		pals = new int[len+1][len+1];
		for(int i=0;i<=len;i++){
			for(int j=0;j<=len;j++){
				if((i+1)==j) pals[i][j] = 1;
				else pals[i][j] = -1;
			}
		}
		slice = new SubstringSlicing(input);
	}
	
	public int cuts(){
		palindromes.add(new triplet(0,len,k));
		triplet t;
		int sum = 0,j=0;
		int remaining;
		while(!palindromes.isEmpty()){
			getQueue();
			System.out.println("queue size: "+palindromes.size());
			if(sum>50){
				return 0;
			}
			t = palindromes.remove();
			remaining = t.k;
//			System.out.println(t.i+","+t.j+","+t.k);
			System.out.print(sum+" ");
			if(remaining==0){
				if(pals[t.i][t.j]!=-1) sum+=pals[t.i][t.j];
				else {
					pals[t.i][t.j] = slice.palindrome(input.substring(t.i,t.j))?1:0;
					sum+=pals[t.i][t.j];
				}
				if(!palindromes.isEmpty()){
					triplet next = palindromes.peek();
					int count = next.k;
					for(int i=0;i<count;i++){
						palindromes.add(t);
					}
				}
			}else{
				int i = t.i;
				for(j=t.i+1;j<t.j;j++){
					if(t.j-j>remaining-1){
						palindromes.add(new triplet(i,j,0));
						palindromes.add(new triplet(j,t.j,remaining-1));
					}
				}
			}
			System.out.println(sum);
		}
		return sum;
	}
	
	public void getTable(){
		for(int i=0;i<pals.length;i++){
			for(int j=0;j<pals[0].length;j++){
				System.out.print(pals[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public void getQueue(){
		Queue<triplet> temp = new LinkedList<triplet>();
		triplet t;
		int size = palindromes.size();
		for(int i=0;i<size;i++){
			t = palindromes.poll();
//			System.out.print(t.toString()+" ");
			System.out.print(input.substring(t.i,t.j)+" "+t.k +" ");
			temp.add(t);
		}
		palindromes = temp;
		System.out.println();
	}
	
	public int fact(int n,int res){
		if(n==0) return res;
		else return fact(n-1,res*n);
	}
	
}
