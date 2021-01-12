package com.practice.jobQueue.api;

import java.util.HashMap;
import java.util.concurrent.Callable;

/**
 * @author Anusha Dasari [anusha.dasari@zoomcar.com] on 2021-01-12
 * <p>
 * Zoomcar.com
 */
public class CallableJob implements Callable {

	int jobId;
	HashMap<String, String> params;

	public CallableJob(int jobId, HashMap<String, String> params) {
		this.jobId = jobId;
		this.params = params;
	}

	@Override
	public Object call() throws Exception {
		System.out.println("Called job");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		System.out.println("Job ID " + jobId + " Thread Name " + Thread.currentThread().getName());
		return Thread.currentThread().getName();
	}
}
