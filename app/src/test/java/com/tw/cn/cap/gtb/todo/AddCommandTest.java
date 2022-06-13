package com.tw.cn.cap.gtb.todo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class AddCommandTest {

    //ctrl+alt+F 将变量进行提取
    private TaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        taskRepository = mock(TaskRepository.class);
    }

    @Test
    void should_compose_task_name_using_multiple_args(){
        final AddCommand addCommand = createCommandFrom("fizz", "buzz");

        addCommand.execute();
//        final var taskName = taskRepository.getTaskName();
//        assertEquals("fizz buzz", taskName);
        verify(taskRepository).create(new Task(0,"fizz buzz",false, false));
    }
    @Test
    void should_use_empty_name_when_no_args_provides(){
        final AddCommand addCommand = createCommandFrom();

        addCommand.execute();
        verify(taskRepository).create(new Task(0,"",false, false));
    }

    private AddCommand createCommandFrom(String... strings) {
        return new AddCommand(taskRepository, strings);
    }

}
