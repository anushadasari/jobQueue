package com.practice.jobQueue.api;

/**
 * @author Anusha Dasari [anusha.dasari@zoomcar.com] on 2021-01-12
 * <p>
 * Zoomcar.com
 */
public class MyPoolManager {
	int capacity;

	static JobQueue myNewFixedThreadPool(int poolSize){
		return new MyThreadPool(poolSize);
	}
}
