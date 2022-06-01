package com.tw.cn.cap.gtb.todo;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class App {

    public static void main(String[] args) {
        throw new UnsupportedOperationException();
    }

    public List<String> run() {
//        return List.of("Task 01","Task 02","Task 03");
        try {
//            return Files.readAllLines(Path.of("C:\\Users\\86130\\.todo\\tasks"));
            return Files.readAllLines(Constants.TASKS_FILE_PATH);
        } catch (IOException e) {
            throw new TodoCannotReadFileException();
        }
//        return Files.readAllLines(Path.of("C:\\Users\\86130\\.todo\\tasks"));
    }
}
