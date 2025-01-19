package com.challenge;

import java.text.DecimalFormat;

public class CalculatorService {

	public String calculate(String request) {
		String[] message = request.split(",");
		double a = Double.parseDouble(message[1]);
		double b = Double.parseDouble(message[2]);
		int precision = Integer.parseInt(message[3]);
		switch (message[0]) {
			case "addition":
				return addition(a, b, precision);
			case "subtraction":
				return subtraction(a, b, precision);
			case "multiplication":
				return multiplication(a, b, precision);
			case "division":
				return division(a, b, precision);
			default:
				return "Invalid operation";
		}
	}

	public String round(double number, int precision) {
		if (precision < 0) {
			throw new IllegalArgumentException("Precision can't be bellow 0");
		}
		String pattern = "#";
		if (precision > 0) {
			pattern += ".";
			for (int i = 0; i < precision; i++) {
				pattern += "#";
			}
		}

		DecimalFormat df = new DecimalFormat(pattern);
		System.out.println(df.format(number));
		return df.format(number);
	}

	public String addition(double a, double b, int precision) {
		return round(a + b, precision);
	}

	public String subtraction(double a, double b, int precision) {
		return round(a - b, precision);
	}

	public String multiplication(double a, double b, int precision) {
		return round(a * b, precision);
	}

	public String division(double a, double b, int precision) {
		if (b == 0) {
			throw new ArithmeticException("Cannot divide by zero");
		}
		return round(a / b, precision);
	}
}
