package com.CallHealth_Challenge;

public class Node implements Comparable<Node> {
	@Override
	public String toString() {
		return "[key=" + key + ", value=" + value + "]";
	}
	int key;
	int value;
	public Node(int a, int b){
		key = a;
		value = b;
	}
	
	public int compareTo(Node n){
		return n.value-this.value;
	}
}
