package com.urlify;

public class URLify {
	
	public static void replaceString(char[] str, int truelenght) {
		int spaceCount = 0, index, i = 0;
		
		for (i = 0; i < truelenght; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		
		index = truelenght + spaceCount * 2;
		if (truelenght < str.length) {
			str[truelenght] = '\0';	// End array
		}
		
		for (i = truelenght - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[index - 1] = '0';
				str[index - 2] = '2';
				str[index - 3] = '%';
			} else {
				str[index - 1] = str[i];
				index--;
			}
		}
	}
	
	
	
	public static String replaceString(String str) {
		StringBuilder sb = new StringBuilder();
		
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == ' ') {
				sb.append("%20");
			} else {
				sb.append(chars[i]);
			}
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String str = "Mr John Smith    ";
		System.out.println(replaceString(str));
	}
}
