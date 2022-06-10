package com.tw.cn.cap.gtb.todo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    public TaskRepository() {
    }

    List<Task> loadTasks() {
        final List<String> lines = readTaskLines();

        final List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
//            final Task task = TaskFactory.createTask(i+1,lines.get(i));
            tasks.add(TaskFactory.createTask(i+1,lines.get(i)));
        }
        return tasks;
    }

    List<String> readTaskLines() {
        try {
            return Files.readAllLines(Constants.TASKS_FILE_PATH);
        } catch (IOException e) {
            throw new TodoCannotReadFileException();
        }
    }

    List<String> create(Task task) {
        final var taskName = task.getName();
        try (var bw = Files.newBufferedWriter(Constants.TASKS_FILE_PATH, StandardOpenOption.APPEND)) {
            bw.write("+ " + taskName);
        } catch (IOException e) {
            throw new TodoCannotReadFileException();
        }
        return List.of();
    }
}
