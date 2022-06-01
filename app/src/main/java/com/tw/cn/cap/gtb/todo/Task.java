package com.tw.cn.cap.gtb.todo;

public class Task {
    private final int id;
    private final String name;

    public Task(int id, String name) {
        this.id = id;
        this.name = name;
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
}
