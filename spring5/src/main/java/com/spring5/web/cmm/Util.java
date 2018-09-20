package com.spring5.web.cmm;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import javax.servlet.http.HttpServletRequest;

public class Util {
	public static Consumer<Integer> logi = System.out::println;
	public static Consumer<String> log = System.out::println;
	public static Function<String, Integer> conInt = Integer::parseInt;
	public static Predicate<String> chkNull = s -> s.equals("") || s.equals("0");
	public static Function<HttpServletRequest, String> ctx = HttpServletRequest::getContextPath;
}
