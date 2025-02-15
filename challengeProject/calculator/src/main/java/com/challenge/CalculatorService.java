package com.challenge;

import java.text.DecimalFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalculatorService {

	public static void main(String[] args) {
		SpringApplication.run(CalculatorService.class, args);
	}

	public String calculate(String request) {
		String[] message = request.split(",");

		try {
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
		} catch (NumberFormatException e) {
			return "Invalid input";
		}
	}

	private String round(double number, int precision) {
		if (precision < 0) {
			return "Precision can't be bellow 0";
		}
		String pattern = "#";
		if (precision > 0) {
			pattern += ".";
			for (int i = 0; i < precision; i++) {
				pattern += "#";
			}
		}
		//To avoid the case 0*-4 = -0
		if (number == 0) {
			return "0";
		}
		DecimalFormat df = new DecimalFormat(pattern);
		return df.format(number);
	}

	private String addition(double a, double b, int precision) {
		return round(a + b, precision);
	}

	private String subtraction(double a, double b, int precision) {
		return round(a - b, precision);
	}

	private String multiplication(double a, double b, int precision) {
		return round(a * b, precision);
	}

	private String division(double a, double b, int precision) {
		if (b == 0) {
			return "Cannot divide by zero";
		}
		return round(a / b, precision);
	}
}
