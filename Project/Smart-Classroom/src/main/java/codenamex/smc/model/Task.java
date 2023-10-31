package codenamex.smc.model;

public class Task {
    private Integer priority;
    private String headline;
    private String description;
    private long deadline;
    private Boolean completed;

    public Task(){}
    public Task(Integer priority, String headline, String description, long deadline, Boolean completed) {
        this.priority = priority;
        this.headline = headline;
        this.description = description;
        this.deadline = deadline;
        this.completed = completed;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getDeadline() {
        return deadline;
    }

    public void setDeadline(long deadline) {
        this.deadline = deadline;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
