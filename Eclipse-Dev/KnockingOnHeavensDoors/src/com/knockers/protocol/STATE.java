package com.knockers.protocol;

public enum STATE {
	WAITING(0), SENTKNOCKKNOCK(1), SENTCLUE(2), ANOTHER(3);
	
	protected final int numVal;
	
	STATE(int numVal) {
		this.numVal = numVal;
	}
}
