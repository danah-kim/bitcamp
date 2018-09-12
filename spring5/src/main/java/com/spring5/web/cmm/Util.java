package com.spring5.web.cmm;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Util {
	public static Consumer<Integer> Logi = System.out::println;
	public static Consumer<String> Log = System.out::println;
	public static Function<String, Integer> conInt = Integer::parseInt;
	public static Predicate<String> ChkNull = s -> s.equals("");
}
