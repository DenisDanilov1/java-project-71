package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import java.util.concurrent.Callable;

        @Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 4.0",
                description = "Compares two configuration files and shows a difference.")
        class App implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            return null;
        }

        public static void main(String... args) {
            int exitCode = new CommandLine(new App()).execute(args);
            System.exit(exitCode);
        }
}
