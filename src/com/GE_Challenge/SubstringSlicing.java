package com.GE_Challenge;

public class SubstringSlicing {
	
	private String input;
	private int len;
	public SubstringSlicing(String st){
		input = st;
		len = st.length();
	}
	
	public boolean cutAndRearrange(){
		if(input.length()==2){
			if(input.charAt(0)==input.charAt(1)) return true;
			else return false;
		}
		String rearrangedInput;
		for(int i=0;i<len-1;i++){
			if(input.charAt(i)==input.charAt(i+1)){
				rearrangedInput = rearrange(input.substring(0,i+1),input.substring(i+1, len));
				System.out.println(rearrangedInput);
				if(palindrome(rearrangedInput)){
					return true;
				}
//				System.out.println(input.substring(0,i+1));
//				System.out.println(input.substring(i+1, len));
			}
		}
		return false;
	}
	
	public String rearrange(String p1,String p2){
		return p2+p1;
	}
	
	public boolean palindrome(String st){
		int i=0,j=st.length()-1;
		for(i=0;i<st.length()/2;i++){
			if(st.charAt(i)!=st.charAt(j)){
				return false;
			}
			j--;
		}
		return true;
	}
}


