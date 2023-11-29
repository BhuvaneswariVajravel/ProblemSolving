package com.wm_practice.advanced;

/*
 * 
 * Problem:
 * To make sure that the producer won’t try to add 
 * data into the buffer if it’s full and that the consumer 
 * won’t try to remove data from an empty buffer.
 * 
 */

import java.lang.Thread;

class Producer extends Thread {

	// Creating a string buffer
	StringBuffer buffer;
	boolean dp = false;

	// Initializing the string buffer
	Producer() {
		buffer = new StringBuffer(4);
	}

	// Overriding the run method
	public void run() {
		synchronized (buffer) {

			for (int i = 0; i < 4; i++) {
				try {
					buffer.append(i);
					System.out.println("Produced " + i);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			System.out.println("Buffer is FUll");
			buffer.notify();
		}
	}
}

// Consumer class which extends
// the thread
class Consumer extends Thread {

	// Creating the object of the
	// producer class
	Producer p;

	// Assigning the object of the
	// producer class
	Consumer(Producer temp) {
		p = temp;
	}

	// Overriding the run method
	public void run() {

		// Controlling the access of the
		// buffer to the shared producer
		synchronized (p.buffer) {
			try {
				p.buffer.wait();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Printing the values of the string buffer
			// and consuming the buffer
			for (int i = 0; i < 4; i++) {
				System.out.print(p.buffer.charAt(i) + " ");
			}
			System.out.println("\nBuffer is Empty");
		}
	}
}

class ProduceConsumerProblem {
	public static void main(String args[]) {
		Producer p = new Producer();

		Consumer c = new Consumer(p);
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(c);
		t2.start();
		t1.start();
	}
}
