package com.cgi.java21;

public class CalculatorApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChinaCalculator cal = new ChinaCalculator();
		System.out.println(cal.addition(10, 20));
		System.out.println(cal.substract(10, 20));
		System.out.println(cal.multiply(10, 20));
		System.out.println(cal.divide(10, 20));
		
		
		IndianCalculator cal1 = new IndianCalculator();
		System.out.println(cal1.addition(10, 20));
		System.out.println(cal1.substract(10, 20));
		System.out.println(cal1.multiply(10, 20));
		System.out.println(cal1.divide(10, 20));

	}

}
