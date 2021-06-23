package com.example.todolist.Common;

import java.util.ArrayList;
import java.util.List;

public class common {

    ArrayList<String> Tasks = new ArrayList<>();
    ArrayList<String> dates = new ArrayList<>();
    ArrayList<Integer> Priorities = new ArrayList<>();

    public common() {
    }

    public common(ArrayList<String> tasks, ArrayList<String> dates, ArrayList<Integer> priorities) {
        this.Tasks = tasks;
        this.dates = dates;
        this.Priorities = priorities;
    }

    public ArrayList<String> getTasks() {
        return Tasks;
    }

    public void setTasks(ArrayList<String> tasks) {
        this.Tasks = tasks;
    }
    public void addTask(String Task){
        this.Tasks.add(Task);
    }

    public ArrayList<String> getDates() {
        return dates;
    }

    public void setDates(ArrayList<String> dates) {
        this.dates = dates;
    }
    public void addDate(String Date){
        this.dates.add(Date);
    }

    public ArrayList<Integer> getPriorities() {
        return Priorities;
    }

    public void setPriorities(ArrayList<Integer> priorities) {
        this.Priorities = priorities;
    }
    public void addPriority(int Priority){
        this.Priorities.add(Priority);
    }

}
