package com.spring5.web.generic;

import java.util.ArrayList;

public class Box<T> {
		T item;
		ArrayList<T> list;
		public Box() {};
		public Box(ArrayList<T> list) {
			this.list = new ArrayList<>();
		}
		public void add(T item) {
			list.add(item);
			
		};
		public T getItem() {
			return item;
		}

		public void setItem(T item) {
			this.item = item;
		}
}
