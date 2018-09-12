package com.spring5.web.lambda;

import java.util.function.Consumer;
import java.util.function.Function;

public class LambdaMethod {
	public static void main(String[] args) {
		Function<String, Integer> f = Integer::parseInt;
		int a = f.apply("1");
		System.out.println(a);
		Consumer<String> c = s -> System.out.println(s);
		c.accept("Hello Lamdba");
	}
}
