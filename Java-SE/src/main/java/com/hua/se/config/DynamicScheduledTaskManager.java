package com.hua.se.config;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.*;

@Component
public class DynamicScheduledTaskManager {
    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
    private Map<String, ScheduledFuture<?>> scheduledTasks = new ConcurrentHashMap<>();

    public void scheduleTask(String taskId, Runnable task, long initialDelay, long period, TimeUnit unit) {
        ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(task, initialDelay, period, unit);
        scheduledTasks.put(taskId, scheduledFuture);
    }

    public void cancelTask(String taskId) {
        ScheduledFuture<?> scheduledFuture = scheduledTasks.get(taskId);
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            scheduledTasks.remove(taskId);
        }
    }
}
