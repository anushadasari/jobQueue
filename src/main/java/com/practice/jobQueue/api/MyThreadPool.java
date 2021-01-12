package com.practice.jobQueue.api;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Anusha Dasari [anusha.dasari@zoomcar.com] on 2021-01-12
 * <p>
 * Zoomcar.com
 */
public class MyThreadPool implements JobQueue {
	static int maxCapacity;
	static int currentCapacity;
	static LinkedBlockingQueue<Runnable> linkedBlockingQueue;
	static LinkedBlockingQueue<FutureTask> blockingQueue;
	Executor executor;
	CallExecutor callExecutor;


	MyThreadPool(int maxCapacity) {
		this.maxCapacity = maxCapacity;
		this.currentCapacity = 0;
		this.linkedBlockingQueue = new LinkedBlockingQueue<>();
		blockingQueue = new LinkedBlockingQueue<>();
		executor = new Executor();
	}

	@Override
	public void enQueue(Runnable r) {
		linkedBlockingQueue.add(r);
		executor.executeMyMethod();
	}

	@Override
	public Future<Integer> enQueueJob(Callable c) {
		FutureTask<Integer> ft = new FutureTask<Integer>(c);
		blockingQueue.add(ft);
		executor.executeMyMethod();
		return ft;
	}
}
