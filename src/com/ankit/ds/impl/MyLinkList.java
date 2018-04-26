package com.ankit.ds.impl;

/**
 * My Linked List
 * @author ankit
 *
 */
public class MyLinkList {
	
	private MyLinkList head;
	private MyLinkList tail;
	private String data;
	private MyLinkList next;
	
	public MyLinkList(String data2) {
		this.data = data2;
	}
	public MyLinkList() {
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public MyLinkList getNext() {
		return next;
	}
	public void setNext(MyLinkList next) {
		this.next = next;
	}
	public MyLinkList getHead() {
		return head;
	}
	public void setHead(MyLinkList head) {
		this.head = head;
	}
	public MyLinkList getTail() {
		return tail;
	}
	public void setTail(MyLinkList tail) {
		this.tail = tail;
	}
	public void add(String data) {
		if(data!=null) {
			if(this.data==null) {
				this.data = data;
				head = this;
				tail = this;
			} else {
				tail.next=new MyLinkList(data);
				tail=tail.next;
			}
		}
	}
	public void add(String data, int index) {
		int i=0;
		MyLinkList current = null;
		while(i<(index-1)) {
			if(current == null) {
				current = this;
			} else {
				current = current.next;
			}
			i++;
		}
		if(current == null && index == 0) {
			current = this;
		}
		MyLinkList next = current;
		current = new MyLinkList(data);
		current.setNext(next);
		if(next == null) {
			tail = current.getNext();
		}
		if(next==head) {
			head = current;
		}
	}
	public void addAll(String ...data) {
		for(String dt : data) {
			add(dt);
		}
	}
	public void addFirst(String data) {
		
	}
	public void addLast(String data) {
		
	}
	public void clear() {
		
	}
	public void contains(String data) {
		
	}
	public String element() {
		//Retrieve but don't remove.
		return null;
	}
	public String get(int index) {
		return null;
	}
	public String getFirst() {
		return null;
	}
	public String getLast() {
		return null;
	}
	public Integer indexOf(String data) {
		return null;
	}
	public Integer lastIndexOf(String data) {
		return null;
	}
	public void offer(String data) {
		//add to last element
	}
	@Override
	public String toString() {
		return "MyLinkList [data=" + data + ", next=" + next + "]";
	}
	
}