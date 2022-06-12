package com.tw.cn.cap.gtb.todo;

import java.util.List;
import java.util.stream.Collectors;

public class Addcommand {
    private final String[] args;
    final TaskRepository taskRepository = new TaskRepository();

    public Addcommand(String[] args) {
        this.args = args;
    }



    List<String> execute() {
        final var taskName=List.of(args).stream()
                .skip(1)
                .collect(Collectors.joining(" "));
        return taskRepository.create(new Task(0,taskName,false));
    }

}
