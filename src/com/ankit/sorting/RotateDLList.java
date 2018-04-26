package com.ankit.sorting;

import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class RotateDLList {

	public static void main(String[] args) {
		AList list = new AList();
		list.setData(1);
		AtomicReference<AList> second = new AtomicReference<>();
		second.set(list);
		IntStream.range(2, 8).forEach(num->{
			AList list2 = new AList();
			list2.setData(num);
			second.get().setNext(list2);
			list2.setPrevious(second.get());
			second.set(list2);
		});
		//System.out.println(list);
		AList temp = list;
		while(temp.getNext()!=null) {
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
		list = rotate(list, 4);
		System.out.println("After rotate");
		temp = list;
		while(temp.getNext()!=null) {
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
	}
	private static AList rotate(AList aList, int i) {
		AList initial = aList;
		AList start = aList;
		AList current = null;
		AList last = null;
		while(start.getNext()!=null) {
			last = start.getNext();
			if(i==0) {
				current = last;
			}
			i--;
			start = last;
		}
		//if(current.getPrevious()!=null) {
			AList previous = current.getPrevious();
			current.setPrevious(null);
			previous.setNext(null);
			
		//}
		last.setNext(initial);
		initial.setPrevious(last);
		return current;
		
	}
	static class AList{
		private int data;
		private AList next;
		private AList previous;
		
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public AList getNext() {
			return next;
		}
		public void setNext(AList next) {
			this.next = next;
		}
		public AList getPrevious() {
			return previous;
		}
		public void setPrevious(AList previous) {
			this.previous = previous;
		}
		@Override
		public String toString() {
			return "AList [data=" + data + ", next=" + next + ", previous=" + previous + "]";
		}
	}
}