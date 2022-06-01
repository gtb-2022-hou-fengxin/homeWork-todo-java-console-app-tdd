package com.tw.cn.cap.gtb.todo;

import java.nio.file.Path;

public class Constants {
    /**
     * 实用类的Class需要添加一个无参构造函数，因为不希望去new constants实例
     * */

    private Constants(){

    }

    // public static final String USER_HOME_PATH = "C:\\Users\\86130";
    public static final String USER_HOME_PATH = System.getProperty("user.home");
    public static final String TODO_CONFIG_ROOT = ".todo";
    public static final String TASKS_FILENAME = "tasks";
    public static final Path TASKS_FILE_PATH = Path.of(USER_HOME_PATH, TODO_CONFIG_ROOT, TASKS_FILENAME);
}