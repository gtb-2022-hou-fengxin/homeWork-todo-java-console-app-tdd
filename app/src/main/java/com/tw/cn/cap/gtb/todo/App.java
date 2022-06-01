package com.tw.cn.cap.gtb.todo;

import java.util.ArrayList;
import java.util.List;

public class App {

    private final TaskRepository taskRepository = new TaskRepository();

    public static void main(String[] args) {
        throw new UnsupportedOperationException();
    }

    public List<String> run() {
        final List<Task> tasks = taskRepository.loadTasks();
        final List<String> result = new ArrayList<>();
        result.addAll(Section.toBeDone().format(tasks));
        result.addAll(Section.completed().format(tasks));
        return result;
    }


}
