package com.ankit.problems;

public class PubSubProblem {
	public static void main(String[] args) throws InterruptedException {
		Message msg = new Message();
		// BlockingQueue<String> queue = new ArrayBlockingQueue<String>(100);
		Publisher pub = new Publisher(msg);
		Subscriber sub = new Subscriber(msg);
		pub.start();
		sub.start();
		pub.join();
		sub.join();
	}
}

class Message {
	String msg;
}

class Publisher extends Thread {
	/*
	 * private BlockingQueue<String> queue;
	 * 
	 * public Publisher(BlockingQueue<String> queue) { this.queue = queue; }
	 */
	Message msg;

	public Publisher(Message msg) {
		this.msg = msg;
	}

	public void run() {
		System.out.println("Running Publisher");
		int i = 0;
		while (true) {
			synchronized (msg) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				msg.msg = ("Msg " + i);
				msg.notify();
				i++;
				try {
					msg.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

class Subscriber extends Thread {
	/*
	 * private BlockingQueue<String> queue;
	 * 
	 * public Subscriber(BlockingQueue<String> queue) { this.queue = queue; }
	 */
	private Message msg;

	public Subscriber(Message msg) {
		this.msg = msg;
	}

	public void run() {
		System.out.println("Running subscriber");
		synchronized (msg) {
			while (true) {
				if (msg.msg != null && !"".equals(msg.msg)) {
					// String msg = queue.poll();
					System.out.println("Subscribed " + msg.msg);
					msg.notify();
				} // else {
				try {
					msg.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// }
				// }
			}

		}
	}
}