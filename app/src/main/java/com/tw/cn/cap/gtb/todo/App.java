package com.tw.cn.cap.gtb.todo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class App {

    public static void main(String[] args) {
        throw new UnsupportedOperationException();
    }

    public List<String> run() {
//        return List.of("Task 01","Task 02","Task 03");
        try {
            return Files.readAllLines(Path.of("/c/Users/86130/.todo/tasks"));
        } catch (IOException e) {
            throw new TodoCannotReadFileException();
        }
    }
}
