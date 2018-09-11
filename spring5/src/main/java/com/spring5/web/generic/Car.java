package com.spring5.web.generic;

import java.util.Comparator;

import lombok.Data;

@Data
public class Car {
	String name;
	int price;
	Car(String name, int price){
		this.name = name;
		this.price = price;
	}
}

class BMW extends Car{
	BMW(String name, int price){
		super(name, price);
	}
}
class Avante extends Car{
	Avante(String name, int price){
		super(name, price);
	}
}
class Sonata extends Car{
	Sonata(String name, int price){
		super(name, price);
	}
}
class Genesis extends Car{
	Genesis(String name, int price){
		super(name, price);
	}
}
//class BMWOrderD implements Comparator<BMW>{
//	public int compare(BMW b1, BMW b2) {
//		return b2.price-b1.price;
//	}
//}
//class AvanteOrderD implements Comparator<Avante>{
//	public int compare(Avante a1, Avante a2) {
//		return a2.price-a1.price;
//	}
//}
//class SonataOrderD implements Comparator<Sonata>{
//	public int compare(Sonata s1, Sonata s2) {
//		return s2.price-s1.price;
//	}
//}
//class GenesisOrderD implements Comparator<Genesis>{
//	public int compare(Genesis g1, Genesis g2) {
//		return g2.price-g1.price;
//	}
//}
class CarOrderD implements Comparator<Car>{
	public int compare(Car c1, Car c2) {
		return c2.price-c1.price;
	}
}
class CarOrderA implements Comparator<Car>{
	public int compare(Car c1, Car c2) {
		return c1.price-c2.price;
	}
}
class CarBox<T extends Car> extends Box<T>{}