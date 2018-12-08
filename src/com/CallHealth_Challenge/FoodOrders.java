package com.CallHealth_Challenge;

import java.util.Scanner;

public class FoodOrders {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt(),K = scan.nextInt(),n = scan.nextInt(),m = scan.nextInt(),P = scan.nextInt();
		double d = P/K;
		double x=(N-P)/((d+1)*m)-n;
		System.out.println(Math.ceil(x));
//		double _N = N;
//		for(int i=0;i<=P/K;i++){
//			_N = _N - (n+Math.ceil(x))*m - K;
//			if(_N>0)
//				p+=K;
//		}
		scan.close();
	}

}
