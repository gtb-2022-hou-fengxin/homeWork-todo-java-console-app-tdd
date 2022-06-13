package com.tw.cn.cap.gtb.todo;

import java.util.List;

public class RemoveCommand {
    private final TaskRepository taskRepository;
    private final String[] args;

    public RemoveCommand(TaskRepository taskRepository, String... args) {

        this.taskRepository = taskRepository;
        this.args = args;
    }

    public List<String> execute() {
        this.taskRepository.delete(Integer.valueOf(args[0]));
        return List.of();
    }
}
