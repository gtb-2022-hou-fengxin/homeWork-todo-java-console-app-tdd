package com.tw.cn.cap.gtb.todo;

import java.util.ArrayList;
import java.util.List;

public class Section {

    private final String title;
    private final boolean flag;

    public Section( String title, boolean flag) {

        this.title = title;
        this.flag = flag;
    }

    static  Section toBeDone() {
        return new Section("# To be done", false);
    }

    static Section completed() {
        return new Section("# Completed", true);
    }


    public String getTitle() {
        return title;
    }

//    public boolean isFlag() {
//        return flag;
//    }

    List<String> format(List<Task> tasks) {
        final List<String> result = new ArrayList<>();
        result.add(getTitle());
        tasks.stream()
                .filter(this::isTypeMatched)
                .map(Task::format)
                .forEach(result::add);
        return result;
    }

    private boolean isTypeMatched(Task task) {
        return flag == task.isCompleted();
    }
}
