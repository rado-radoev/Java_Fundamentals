package com.ex208;

public class Pair<F, S> {

	private F first;
	private S second;
	
	public F getFirst() {
		return first;
	}

	public S getSecond() {
		return second;
	}

	public void setFirst(F first) {
		this.first = first;
	}

	public void setSecond(S second) {
		this.second = second;
	}
	
	public Pair(F first, S second) {
		setFirst(first);
		setSecond(second);
	}
	
	@Override
	public String toString() {
		return String.format("Key is: %s. Value is: %d ", getFirst(), getSecond());
	}

	public static void main(String[] args) {
		Pair<String, Integer> pair = new Pair("String1", 2);
		
		System.out.println(pair.toString());
	}

}
