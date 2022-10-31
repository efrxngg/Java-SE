package edu.java.se.functional;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class CliArgumentsUtil {

    static void showHelper(CliArguments cliArguments) {
        Consumer<CliArguments> consumerHelper = cliargs -> {
            if (cliargs.isHelp()) {
                System.out.println("The manual has been requested");
            }
        };
        consumerHelper.accept(cliArguments);
    }

    static CliArguments generateCli() {
        Supplier<CliArguments> generator = () -> new CliArguments();
        return generator.get(); 
    }

    public static void main(String[] args) {
        System.out.println(generateCli());          
    }
}
