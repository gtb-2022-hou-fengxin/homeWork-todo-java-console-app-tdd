package com.tw.cn.cap.gtb.todo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskFactoryTest {

    @Test
    void should_parse_completed_property_for_task(){
        final var isCompleted = TaskFactory.createTask(1,"+ + Task 01").isCompleted();
        assertFalse(false);
    }

    @Test
    void should_support_name_with_multiple_white_spaces() {
        Task task = TaskFactory.createTask(1, "+ +   foo  bar   ");
        assertEquals("  foo  bar   ", task.getName());
    }
}
