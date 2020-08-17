package com.ankit.problems;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PubSubBlockingQueueProblem {
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(100);
		PublisherP pub = new PublisherP(queue);
		SubscriberS sub = new SubscriberS(queue);
		pub.start();
		sub.start();
		pub.join();
		sub.join();
	}
}

class PublisherP extends Thread {

	private BlockingQueue<String> queue;

	public PublisherP(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	public void run() {
		System.out.println("Running Publisher");
		int i = 0;
		while (true) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			queue.add("Msg " + i);
			i++;
		}
	}
}

class SubscriberS extends Thread {

	private BlockingQueue<String> queue;

	public SubscriberS(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	public void run() {
		System.out.println("Running subscriber");
		try {
			for (String s = queue.take(); s != null;s=queue.take()) {
				System.out.println(s);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}