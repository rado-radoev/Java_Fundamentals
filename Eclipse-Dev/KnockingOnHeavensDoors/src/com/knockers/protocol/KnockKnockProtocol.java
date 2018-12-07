package com.knockers.protocol;

public class KnockKnockProtocol {
	
	private static final int NUMJOKES = 5;
	
	private int state = STATE.WAITING.numVal;
	private int currentJoke = 0;
	
	private String[] clues = { "Turnip", "Little Old Lady", "Atch", "Who", "Who" };
	private String[] answers = { "Turnip the heat, it's cold in here!",
	                                 "I didn't know you could yodel!",
	                                 "Bless you!",
	                                 "Is there an owl in here?",
	                                 "Is there an echo in here?" };

	 
	 public String processInput(String theInput) {
		 String theOutput = null;
		 
		 if (state == STATE.WAITING.numVal) {
			 theOutput = "Knock Knock";
			 state = STATE.SENTKNOCKKNOCK.numVal;
		 } else if (state == STATE.SENTKNOCKKNOCK.numVal) {
			 if (theInput.equalsIgnoreCase("Who's there?")) {
				 theOutput = clues[currentJoke];
				 state = STATE.SENTCLUE.numVal;
			 } else {
				 theOutput = "You're supposed to say \"Who's there?\"! " +
			                "Try again. Knock! Knock!";
			 }
		 } else if (state == STATE.SENTCLUE.numVal) {
			 if (theInput.equalsIgnoreCase(clues[currentJoke] + "who?")) {
				 theOutput = answers[currentJoke] + " Want another (y/n)?";
				 state = STATE.ANOTHER.numVal;
			 } else {
				 theOutput = "You're supposed to say \"" + 
			                clues[currentJoke] + 
			                " who?\"" + 
			                "! Try again. Knock! Knock!";
			 }
		 } else if (state == STATE.ANOTHER.numVal) {
			 if (theInput.equalsIgnoreCase("y")) {
				theOutput = "Knock! Knock!"; 
				if (currentJoke == (NUMJOKES - 1))
					currentJoke = 0;
				else
					currentJoke++;
				
				state = STATE.SENTKNOCKKNOCK.numVal;
			 } else {
				 theOutput = "Bye.";
				 state = STATE.WAITING.numVal;
			 }
		 }
		
		 return theOutput;
	 }
	 
}
