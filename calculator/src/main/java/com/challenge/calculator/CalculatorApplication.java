package com.challenge.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.text.DecimalFormat;

@SpringBootApplication
public class CalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculatorApplication.class, args);
	}

	public String round(double number, int precision) {
		if (precision<0) {
			throw new IllegalArgumentException("Precision can't be bellow 0");
		}
		String pattern = "#";
		if (precision > 0) {
			pattern += ".";
			for (int i = 0; i < precision; i++) {
				pattern += "#";
			}
		}

		DecimalFormat df_obj = new DecimalFormat(pattern);
		return df_obj.format(number);
	}

	public String sum(double a, double b, int precision) {
		return round(a + b, precision);
	}

	public String subtraction(double a, double b, int precision) {
		return round(a - b, precision);
	}

	public String multiplication(double a, double b, int precision) {
		return round(a * b, precision);
	}

	public String division(double a, double b, int precision) {
		if(b==0){
			throw new ArithmeticException("Cannot divide by zero");
		}
		return round(a / b, precision);
	}
}
