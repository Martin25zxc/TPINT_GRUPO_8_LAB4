package com.integrador.utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateHelper {
	public static LocalDate LocalDateFormat(String string) {
		LocalDate date = null;
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		date = LocalDate.parse(string, dateFormatter);
		return date;
	}

	public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		int d1 = Integer.parseInt(formatter.format(birthDate));
		int d2 = Integer.parseInt(formatter.format(currentDate));
		int age = (d2 - d1) / 10000;
		return age;
	}
	
	public static String localDateToFormatString(LocalDate date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String fecha = date.format(formatter);
		return fecha;
	}
}
