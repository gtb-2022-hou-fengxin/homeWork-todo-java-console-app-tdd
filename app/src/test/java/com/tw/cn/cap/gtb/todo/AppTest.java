package com.tw.cn.cap.gtb.todo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;


class AppTest {

    @BeforeEach
    void setUp(){
        writeDataFile(List.of(
                "+ Task 01",
                "+ Task 02",
                "+ Task 03",
                "* Task 04",
                "* Task 05"));
    }

    @Test
    void should_list_existing_tasks(){
        final var result = new App().run();
        Assertions.assertEquals(List.of(
                "# To be done",
                "1 Task 01",
                "2 Task 02",
                "3 Task 03",
                "# Completed",
                "4 Task 04",
                "5 Task 05"),result);
    }

    @Test
    void should_add_task_single_word_as_name(){
        new App().run("add","foobar");
        final var result = new App().run();
        Assertions.assertEquals(List.of(
                "# To be done",
                "1 Task 01",
                "2 Task 02",
                "3 Task 03",
                "6 foobar",
                "# Completed",
                "4 Task 04",
                "5 Task 05"),result);
    }

    private void writeDataFile(List<String> lines) {
        try (var bw = Files.newBufferedWriter(Constants.TASKS_FILE_PATH)) {
            for(String line : lines){
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getCause());
        }
    }
}
