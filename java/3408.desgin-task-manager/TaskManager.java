import java.util.*;

class Task implements Comparable<Task> {
    public int priority;
    public int userId;
    public int taskId;

    public Task(int userId, int taskId, int priority) {
        this.userId = userId;
        this.taskId = taskId;
        this.priority = priority;
    }

    @Override
    public int compareTo(Task other) {
        if (other.priority != this.priority) {
            return Integer.compare(other.priority, this.priority);
        }
        return other.taskId - this.taskId;
    }
}

class TaskManager {
    PriorityQueue<Task> taskQueue = new PriorityQueue<>();
    Map<Integer, Integer> taskUserMap = new HashMap<>();
    Map<Integer, Integer> taskPriorityMap = new HashMap<>();

    public TaskManager(List<List<Integer>> tasks) {
        for (List<Integer> task : tasks) {
            this.add(task.get(0), task.get(1), task.get(2));
        }
    }

    public void add(int userId, int taskId, int priority) {
        taskUserMap.put(taskId, userId);
        taskPriorityMap.put(taskId, priority);
        taskQueue.add(new Task(userId, taskId, priority));
    }

    public void edit(int taskId, int newPriority) {
        taskPriorityMap.put(taskId, newPriority);
        taskQueue.add(new Task(taskUserMap.get(taskId), taskId, newPriority));
    }

    public void rmv(int taskId) {
        taskUserMap.remove(taskId);
        taskPriorityMap.remove(taskId);
    }

    public int execTop() {
        Task highestPriority = this.taskQueue.poll();
        while (highestPriority != null && (taskUserMap.get(highestPriority.taskId) == null
                || taskUserMap.get(highestPriority.taskId) != highestPriority.userId
                || taskPriorityMap.get(highestPriority.taskId) != highestPriority.priority)) {
            highestPriority = this.taskQueue.poll();
        }
        if (highestPriority == null) {
            return -1;
        } else {
            this.rmv(highestPriority.taskId);
            return highestPriority.userId;
        }
    }
}