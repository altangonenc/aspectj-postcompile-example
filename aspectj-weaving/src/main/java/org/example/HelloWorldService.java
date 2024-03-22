package org.example;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class HelloWorldService {
    private String message = "Sorry no message today";
    private ScheduledExecutorService scheduler;
    public String getMessage()
    {
        return message;
    }
    public void setMessage(String message)
    {
        this.message = message;
    }
    public void printMessage()
    {
        System.out.println(message);
    }
    // The lifecycle

    public void start() throws Exception
    {
        System.out.println(">>>>Starting with message=" + message);

        // Schedule the task to run every 30 seconds
        scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(this::logTask, 0, 30, TimeUnit.SECONDS);
    }
    public void stop() throws Exception
    {
        System.out.println(">>>>Stopping with message=" + message);
    }

    // Log task to be scheduled
    public void logTask() {
        System.out.println("Logging: " + message);
    }
}
