package com.spring5.web.generic;

public class GenericIntro {
	public static void main(String[] args) {
		Box<String> bx = new Box<>();
		bx.setItem("aaa");
		Box<Integer> bx2 = new Box<>();
		bx2.setItem(5);
	}

}
