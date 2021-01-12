package com.practice.jobQueue.api.BasicImpl;

import com.practice.jobQueue.api.Job;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Anusha Dasari [anusha.dasari@zoomcar.com] on 2021-01-12
 * <p>
 * Zoomcar.com
 */
public class BasicJobQueue {
	static LinkedBlockingQueue<Runnable> workerQueue;
	static Thread[] threads;

	public BasicJobQueue(int capacity) {
		this.workerQueue = new LinkedBlockingQueue<>();
		threads = new Thread[capacity];
		int i = 0;
		for(Thread t : threads){
			t = new Worker("Custom Pool Thread " + ++i);
//			t = new Thread(new Worker());
			t.start();
			i++;
		}
	}

	public void enQueue(Runnable r) {
		try {
			workerQueue.put(r);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enQueueJob(Runnable r) {
		try {
			workerQueue.put(r);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public class Worker extends Thread {
		public Worker(String name) {
			super(name);
		}

		public void run() {
			while (true) {
				try {
					workerQueue.take().run();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

//	public class Worker implements Runnable {
//		public void run() {
//			while (true) {
//				try {
//					workerQueue.take().run();
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}


}
