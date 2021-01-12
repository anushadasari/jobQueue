package com.practice.jobQueue.api;


import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * @author Anusha Dasari [anusha.dasari@zoomcar.com] on 2021-01-12
 * <p>
 * Zoomcar.com
 */

public interface JobQueue {
	 void enQueue(Runnable r);
	Future<Integer> enQueueJob(Callable r);
}
