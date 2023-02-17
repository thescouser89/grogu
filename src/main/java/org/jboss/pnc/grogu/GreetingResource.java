package org.jboss.pnc.grogu;

import org.jobrunr.scheduling.JobScheduler;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @Inject
    JobScheduler jobScheduler;


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {

        jobScheduler.enqueue(() -> System.out.println("Hello"));

        return "Hello from RESTEasy Reactive";
    }
}