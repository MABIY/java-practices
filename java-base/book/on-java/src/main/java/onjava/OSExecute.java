package onjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author lh
 */
public class OSExecute {
    public static void command(String command) {
        boolean err = false;
        try {
            Process process = new ProcessBuilder(command.split(" ")).start();
            try(BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream()));
                BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()))
            ) {
                results.lines().forEach(System.out::println);
                err = errors.lines().peek(System.out::println).count() > 0;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(err) {
            throw  new OSExecuteException("Error executing "  + command);
        }
    }
}
