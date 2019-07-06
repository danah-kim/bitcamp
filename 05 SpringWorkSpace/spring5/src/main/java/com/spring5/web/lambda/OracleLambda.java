package com.spring5.web.lambda;

import java.util.function.Predicate;

public class OracleLambda {
	public static void main(String[] args) {
		Predicate<String> p = s -> s.length() == 0;
		String x = "";
		String y = "Hello";
		String r = (p.test(x)) ? "Null" : "Not Null";
		System.out.println(r);
		r = (p.test(y)) ? "Null" : "Not Null";
		System.out.println(r);
	}
}