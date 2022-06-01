package com.tw.cn.cap.gtb.todo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;


class AppTest {

    @Test
    void should_list_existing_tasks(){
        final var result = new App().run();
        Assertions.assertEquals(List.of(
                "# To be done",
                "Task 01","Task 02","Task 03"),result);
    }
}
