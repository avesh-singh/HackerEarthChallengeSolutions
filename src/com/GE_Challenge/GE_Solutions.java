package com.GE_Challenge;

public class GE_Solutions {

	public static void main(String[] args){
		String text = "";
		for(int i=0;i<100;i++){
			text+=".$$..";
		}
//		System.out.println(text);
//		SubstringSlicing slice = new SubstringSlicing(text);
//		System.out.println(slice.cutAndRearrange());
		PalindromicCuts pc = new PalindromicCuts("abbavv",2);
		System.out.println(pc.cuts());
		pc.getTable();
	}

}
