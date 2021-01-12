package com.practice.jobQueue;

import com.practice.jobQueue.api.CustomExecutorService;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class JobQueueApplication extends Application<JobQueueConfiguration> {

    public static void main(final String[] args) throws Exception {
        new JobQueueApplication().run(args);
    }

    @Override
    public String getName() {
        return "JobQueue";
    }

    @Override
    public void initialize(final Bootstrap<JobQueueConfiguration> bootstrap) {

    }

    @Override
    public void run(final JobQueueConfiguration configuration,
                    final Environment environment) {
        CustomExecutorService.trigger(3);

    }

}
