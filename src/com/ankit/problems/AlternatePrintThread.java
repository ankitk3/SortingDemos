package com.ankit.problems;

public class AlternatePrintThread extends Thread {

	public static void main(String[] args) throws Exception {
		LockClass lock = new LockClass();
		Thread1 t1 = new Thread1(lock, "Thread1");
		Thread2 t2 = new Thread2(lock, "Thread2");
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}
}

class Thread1 extends Thread {
	final int max=40;
	LockClass lockClass;
	String threadName;

	public Thread1(LockClass lockClass, String threadName) {
		this.lockClass = lockClass;
		this.threadName = threadName;
	}

	public void run() {
		while (lockClass.getValue()<max) {
			synchronized (lockClass) {
				while (lockClass.getValue() % 2 != 0) {
					try {
						lockClass.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(threadName + "::" + lockClass.getValue());
				lockClass.setValue(lockClass.getValue() + 1);
				lockClass.notifyAll();
			}
		}
	}
}

class Thread2 extends Thread {
	final int max=40;
	LockClass lockClass;
	String threadName;

	public Thread2(LockClass lockClass, String threadName) {
		this.lockClass = lockClass;
		this.threadName = threadName;
	}

	public void run() {
		while (lockClass.getValue()<max) {
			synchronized (lockClass) {
				while (lockClass.getValue() % 2 == 0) {
					try {
						lockClass.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(threadName + "::" + lockClass.getValue());
				lockClass.setValue(lockClass.getValue() + 1);
				lockClass.notifyAll();
			}
		}
	}
}

class LockClass {
	int i = 1;

	public int getValue() {
		return i;
	}

	public void setValue(int i) {
		this.i = i;
	}
}