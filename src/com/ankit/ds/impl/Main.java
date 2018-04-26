package com.ankit.ds.impl;

public class Main {

	public static void main(String[] args) {
		MyLinkList list = new MyLinkList();
		list.addAll("Ankit","Kalra","asas","dddd");
		/*list.add("Kalra");
		list.add("asasas");
		list.add("dfed");*/
		list.add("beech me",0);
		while(list !=null) {
			System.out.println(list);
			System.out.println("Head="+list.getHead());
			System.out.println("Tail="+list.getTail());
			list=list.getNext();
		}
	}
}
