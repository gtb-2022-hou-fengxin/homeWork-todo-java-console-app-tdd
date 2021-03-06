package com.tw.cn.cap.gtb.todo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;


class AppTest {

    private App app;

    @BeforeEach
    void setUp(){
        writeDataFile(List.of(
                "+ + Task 01",
                "+ + Task 02",
                "+ + Task 03",
                "* + Task 04",
                "* + Task 05"));
        app = new App();
    }

    @Nested
     class ListCommand{
        @Nested
        class WhenThereAreExistingTasks{
            @Test
            void should_list_existing_tasks(){
                //Given
                //When
                final var result = app.run();
                //Then
                Assertions.assertEquals(List.of(
                        "# To be done",
                        "1 Task 01",
                        "2 Task 02",
                        "3 Task 03",
                        "# Completed",
                        "4 Task 04",
                        "5 Task 05"),result);
            }

        }

    }

    @Nested
    class AddCommand{
        @Nested
        class WhenSingleWordProvidedAsName{
            @Test
            void should_add_task_single_word_as_name(){
                //ctrl +alt + Tæååé
//                final var app =new App();
                app.run("add","foobar");
                final var result = app.run();
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
        }
//        @Nested
//        class WhenMultipleWordsProvidedAsName{
//            @Test
//            void should_add_task_all_words_as_name(){
//                //ctrl +alt + Tæååé
////                final var app =new App();
//                app.run("add","fizz","buzz");
//                final var result = app.run();
//                Assertions.assertEquals(List.of(
//                        "# To be done",
//                        "1 Task 01",
//                        "2 Task 02",
//                        "3 Task 03",
//                        "6 fizz buzz",
//                        "# Completed",
//                        "4 Task 04",
//                        "5 Task 05"),result);
//            }
//        }

    }

    @Nested
    class RemoveTask{
        @Nested
        class WhenSingleIdProvided{
            @Test
            void should_remove_single_task(){
                app.run("remove","1");
                final var result = app.run();
                Assertions.assertEquals(List.of(
                        "# To be done",
                        "2 Task 02",
                        "3 Task 03",
                        "# Completed",
                        "4 Task 04",
                        "5 Task 05"),result);
            }
        }
        @Nested
        class WhenRemoveMultipleTasks{
            @Test
            void should_remove_them_all(){
                app.run("remove","1","4");
                final var result = app.run();
                Assertions.assertEquals(List.of(
                        "# To be done",
                        "2 Task 02",
                        "3 Task 03",
                        "# Completed",
                        "5 Task 05"),result);
            }
        }
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
