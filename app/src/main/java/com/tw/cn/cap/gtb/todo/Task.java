package com.tw.cn.cap.gtb.todo;

import java.util.Objects;

public class Task {
    private final int id;
    private final String name;
    private final boolean isCompleted;

    public Task(int id, String name, boolean isCompleted) {
        this.id = id;
        this.name = name;
        this.isCompleted = isCompleted;
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
        return this.isCompleted;
    }

    @Override
    public String toString(){
//        return id + " " + name + " " + isCompleted;
        return id + " " + isCompleted + " " + name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,name,isCompleted);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return  false;
        Task task = (Task) obj;
        return id == task.id && isCompleted == task.isCompleted && name.equals(task.name);
    }
}
