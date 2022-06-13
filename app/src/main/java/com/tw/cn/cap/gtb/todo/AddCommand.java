package com.tw.cn.cap.gtb.todo;

import java.util.List;

public class AddCommand {
    private final String[] args;
    //dependency injection(DI)
    //do not confuse with DIP

    //DOC:depended on component
    final TaskRepository taskRepository;

    public AddCommand(TaskRepository taskRepository, String... args) {
        this.args = args;
        this.taskRepository = taskRepository;
    }

//    public String[] getArgs() {
//        return args;
//    }

    List<String> execute() {
        final var taskName = String.join(" ", args);
        taskRepository.create(new Task(0, taskName,false, false));
        return List.of();
    }


//      List<String> execute() {
//       final var taskName=List.of(args).stream()
//               .skip(1)
//               .collect(Collectors.joining(" "));
//       return taskRepository.create(new Task(0,taskName,false));
//     }


}
