package com.tw.cn.cap.gtb.todo;

public class TaskFactory {

    public TaskFactory() {
    }

//    static Task createTask(int id, String line) {
//        final var fields = line.split(" ", 2);
//        final var name = fields[1];
//        final var isCompleted = fields[0].equals("*");
//        return new Task(id, name, isCompleted, false);
//    }
    static Task createTask(int id, String line) {
        final var fields = line.split(" ", 3);
        final var name = fields[2];
        final var isCompleted = fields[0].equals("*");
        final var isDeleted = fields[1].equals("*");
        return new Task(id, name, isCompleted, isDeleted);
    }
}
