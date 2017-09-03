package com.ex2115;

public class Line<T> extends Queue<T> {

	private int maxCustomersInLine;
	private int highestWaitTime;
	
	public Line() {
		super();
	}

	public int getMaxCustomersInLine() {
		return maxCustomersInLine;
	}

	public void setMaxCustomersInLine(int maxCustomersInLine) {
		this.maxCustomersInLine = maxCustomersInLine;
	}

	public int getHighestWaitTime() {
		return highestWaitTime;
	}

	public void setHighestWaitTime(int highestWaitTime) {
		this.highestWaitTime = highestWaitTime;
	};
	
}
