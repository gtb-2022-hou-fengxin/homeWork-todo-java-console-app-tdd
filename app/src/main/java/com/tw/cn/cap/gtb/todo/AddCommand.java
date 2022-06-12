package com.tw.cn.cap.gtb.todo;

import java.util.List;
import java.util.stream.Collectors;

public class AddCommand {
    private final String[] args;
    final TaskRepository taskRepository = new TaskRepository();

    public AddCommand(String[] args) {
        this.args = args;
    }

    public String[] getArgs() {
        return args;
    }

    List<String> execute() {
        return taskRepository.create(new Task(0,getArgs()[1],false));
    }

//    List<String> execute() {
//        final var taskName=List.of(args).stream()
//                .skip(1)
//                .collect(Collectors.joining(" "));
//        return taskRepository.create(new Task(0,taskName,false));
//    }

}
