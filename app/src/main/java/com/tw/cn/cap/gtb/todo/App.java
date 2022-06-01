package com.tw.cn.cap.gtb.todo;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        throw new UnsupportedOperationException();
    }

    public List<String> run() {
//        return List.of("Task 01","Task 02","Task 03");
        try {
//            return Files.readAllLines(Path.of("C:\\Users\\86130\\.todo\\tasks"));
            final List<String> result = new ArrayList<>();
            result.add("# To be done");
            result.addAll(Files.readAllLines(Constants.TASKS_FILE_PATH));
            return result;
        } catch (IOException e) {
            throw new TodoCannotReadFileException();
        }
//        return Files.readAllLines(Path.of("C:\\Users\\86130\\.todo\\tasks"));
    }
}
