package com.practice.jobQueue.api;

import java.util.HashMap;

/**
 * @author Anusha Dasari [anusha.dasari@zoomcar.com] on 2021-01-12
 * <p>
 * Zoomcar.com
 */
public class Job implements Runnable {
	int jobId;
	HashMap<String, String> params;

	public Job(int jobId, HashMap<String, String> params) {
		this.jobId = jobId;
		this.params = params;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(2000);
			//Do the job and notify caller of result
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Job ID " + jobId + " Thread Name " + Thread.currentThread().getName());
	}
}
