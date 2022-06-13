package com.tw.cn.cap.gtb.todo;

import java.util.Objects;

public class Task {
    private final int id;
    private final String name;
    private final boolean completed;
    private boolean deleted;


    public Task(int id, String name, boolean isCompleted, boolean deleted) {
        this.id = id;
        this.name = name;
        this.completed = isCompleted;
        this.deleted = deleted;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    String format() {
        return String.format("%d %s", getId(), getName());
    }

    public boolean isCompleted() {
        return this.completed;
    }

    @Override
    public String toString(){
//        return id + " " + name + " " + isCompleted;
        return id + " " + completed + " " + name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,name, completed);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return  false;
        Task task = (Task) obj;
        return id == task.id && completed == task.completed && name.equals(task.name);
    }

    public void delete() {
        this.deleted = true;
    }

    public boolean isDeleted() {
        return this.deleted;
    }
}
