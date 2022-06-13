package com.tw.cn.cap.gtb.todo;

import java.util.Arrays;
import java.util.List;

public class App {

    private final ListCommand listCommand = new ListCommand();

    public static void main(String[] args) {
//        throw new UnsupportedOperationException();
        new App().run().forEach(System.out::println);
    }

    public List<String> run(String... args) {
        if (args.length <= 0) {
            return listCommand.run();
        }
        if (args[0].equals("add")) {
            final var restArgs = Arrays.copyOfRange(args, 1, args.length);
            return new AddCommand(new TaskRepository(), restArgs).execute();
        }
        if(args[0].equals("remove")){
            final var restArgs = Arrays.copyOfRange(args,1,args.length);
            return new AddCommand(new TaskRepository(), restArgs).execute();
        }
        return listCommand.run();

    }


}
