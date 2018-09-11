package com.spring5.web.generic;

import java.util.Collections;

public class CarMain {
	public static void main(String[] args) {
		CarBox<BMW> bBox = new CarBox<>();
		CarBox<Avante> aBox = new CarBox<>();
		CarBox<Car> cBox = new CarBox<>();
		aBox.add(new Avante("아반테a", 1500));
		aBox.add(new Avante("아반테b", 1800));
		aBox.add(new Avante("아반테c", 2000));
		bBox.add(new BMW("bmwa", 1900));
		bBox.add(new BMW("bmwb", 2500));
		bBox.add(new BMW("bmwc", 4000));
		cBox.add(new Avante("아반테a", 1500));
		cBox.add(new Avante("아반테b", 1800));
		cBox.add(new Avante("아반테c", 2000));
		cBox.add(new BMW("bmwa", 1900));
		cBox.add(new BMW("bmwb", 2500));
		cBox.add(new BMW("bmwc", 4000));
		System.out.println("========내림차순======");
		Collections.sort(aBox.getList(), new CarOrderD());
		Collections.sort(bBox.getList(), new CarOrderD());
		Collections.sort(cBox.getList(), new CarOrderD());
		System.out.println(aBox);
		System.out.println(bBox);
		System.out.println(cBox);
		System.out.println("========오름차순======");
		Collections.sort(aBox.getList(), new CarOrderA());
		Collections.sort(bBox.getList(), new CarOrderA());
		Collections.sort(cBox.getList(), new CarOrderA());
		System.out.println(aBox);
		System.out.println(bBox);
		System.out.println(cBox);
	}
}