package com.example.todolist.Common;

public class DataModel {
    String Task;
    String Date;
    int Priority;

    public DataModel(String task, String date, int priority) {
        Task = task;
        Date = date;
        Priority = priority;
    }

    public String getTask() {
        return Task;
    }

    public void setTask(String task) {
        this.Task = task;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        this.Date = date;
    }

    public int getPriority() {
        return Priority;
    }

    public void setPriority(int priority) {
        this.Priority = priority;
    }
}
