package com.integrador.utilities;

public class StringHelper {
	public static boolean isNullOrEmpty(String s) {
		return s == null || s == "" || s.length() == 0;
	}

	public static boolean isNullOrWhitespace(String s) {
		return s == null || isWhitespace(s) ||  s.equals("") ;

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

	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
