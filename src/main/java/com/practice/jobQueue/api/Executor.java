package com.practice.jobQueue.api;

import java.util.concurrent.Future;

/**
 * @author Anusha Dasari [anusha.dasari@zoomcar.com] on 2021-01-12
 * <p>
 * Zoomcar.com
 */
public class Executor implements Runnable {

	static int initialised = 0;

	void executeMyMethod() {

		if (MyThreadPool.currentCapacity < MyThreadPool.maxCapacity) {
			MyThreadPool.currentCapacity++;
			if(initialised != 1){
				System.out.println("Initialising polling");
				Thread t = new Thread(new Executor());
				initialised = 1;
				t.start();
			}

		} else {
			System.out.println("Threadpool size exceeded, current: " + MyThreadPool.currentCapacity +  "max:" + MyThreadPool.maxCapacity);
		}
	}

	@Override
	public void run() {
		while (true) {
//			int size = MyThreadPool.linkedBlockingQueue.size();
			int size = MyThreadPool.blockingQueue.size();
			if ( size != 0) {
				System.out.println("Blocking queue size  is " + size);
//				MyThreadPool.linkedBlockingQueue.poll().run();
				try{
					MyThreadPool.blockingQueue.poll().run();
					System.out.println("Future run result");
				} catch (Exception e){
					System.out.println("Caught exception");
				}
			}
		}
	}
}
