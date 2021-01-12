package com.practice.jobQueue.api;

import com.practice.jobQueue.api.BasicImpl.BasicJobQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

/**
 * @author Anusha Dasari [anusha.dasari@zoomcar.com] on 2021-01-12
 * <p>
 * Zoomcar.com
 */
public class CustomExecutorService {
	public static void trigger(int poolsize) {
		JobQueue queueService = MyPoolManager.myNewFixedThreadPool(poolsize);
//		for (int i = 0; i < 10; i++) {
//			System.out.println("Iteration job submission" + i);
//			queueService.enQueue(new Job(i));
//		}

		Future<Integer> jobResult1 =
				queueService.enQueueJob(new CallableJob(1, new HashMap<>()));
		Future<Integer> jobResult2 =
				queueService.enQueueJob(new CallableJob(2, new HashMap<>()));
		System.out.println("Reached by crossing");
		try{
			System.out.println("Getting result for 1 " + jobResult1.get());
		} catch (Exception e){
			System.out.println("Caught big fish");
		}


		try{
			System.out.println("Getting result for 2 " + jobResult2.get());
		} catch (Exception e){
			System.out.println("Caught big fish");
		}

//		//Basic job queue
//		BasicJobQueue threadPoolExecutor = new BasicJobQueue(3);
//		for (int i = 0; i < 10; i++) {
//			threadPoolExecutor.enQueue(new Job(i, new HashMap<>()));
//		}
	}

}
