package com.integrador.utilities;

public class StringHelper {
	public static boolean isNullOrEmpty(String s) {
		return s == null || s == "" || s.length() == 0;
	}

	public static boolean isNullOrWhitespace(String s) {
		return s == null || isWhitespace(s) ||  s.equals("") ;

	}
	
	public static String padLeft(int length, String str, char ch)
	{
		String string =  String.format("%1$" + length + "s", str).replace(' ', ch);
		return string;
	}
	
	private static boolean isWhitespace(String s) {
		int length = s.length();
		if (length > 0) {
			for (int i = 0; i < length; i++) {
				if (!Character.isWhitespace(s.charAt(i))) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public static String reverseString(String str){  
	    char ch[]=str.toCharArray();  
	    String rev="";  
	    for(int i=ch.length-1;i>=0;i--){  
	        rev+=ch[i];  
	    }  
	    return rev;  
	}  
	
	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
  
	public static String formatDecimal(double number) {
		  String string = "$"+ String.format("%,.2f", number);
		  return string;
	}
}
