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
		PalindromicCuts pc = new PalindromicCuts("aabbc");
		System.out.println(pc.result(0,4,2));
		pc.getMap();
	}

}
