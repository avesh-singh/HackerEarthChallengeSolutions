package com.GlobalHiring_Challenge;

public class AlmostVowel {

	public static void main(String[] args) {
		String s ="rrrrerrr";
		int finalLength = 0;
		int st = 0,end = 1,zero = 0,last = s.length()-1;
		String trimmedFromStart = s.substring(st);
		// if vowel(s) occurs at the beginning of the string
		while(end<s.length() && isVowel(s.substring(st,end))){
			finalLength++;
			trimmedFromStart = s.substring(end);
			end++;
			zero++;
		}
		// if vowel(s) occur at the end of the string
		end = trimmedFromStart.length();
		st = end-1;
		while(st>=0 && isVowel(trimmedFromStart.substring(st,end))){
			finalLength++;
			st--;
			last--;
		}
		int maxVowels = 0;
		st=zero;
		end=st+1;
		while(end<=last && st<end){
			if(isVowel(s.substring(st,end))){
				if(end-st>maxVowels){
					maxVowels = end-st;
				}
				end++;
			}else{
				st++;
				end = st+1;
			}
		}
		int result = finalLength+maxVowels;
		System.out.println(result);
	}
	
	public static boolean isVowel(String str){
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)!='a' && str.charAt(i)!='e' && str.charAt(i)!='i' && str.charAt(i)!='o' && str.charAt(i)!='u'){
				return false;
			}
		}
		return true;
	}

}
