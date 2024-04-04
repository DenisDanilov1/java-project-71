package hexlet.code;

import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.util.concurrent.Callable;
import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;

        @Command(name = "gendiff", mixinStandardHelpOptions = true,
                description = "Compares two configuration files and shows a difference.")

        class App implements Callable<Integer> {
            @Parameters(index = "0", paramLabel = "filepath1", description = "path to first file")
            private File filepath1;

            @Parameters(index = "0", paramLabel = "filepath2", description = "path to second file")
            private File filepath2;

            @Option(names = {"-f", "--format"}, paramLabel = "format", description = "output format [default: stylish]")
            private String format;

        @Override
        public Integer call() throws Exception {
            byte[] fileContents1 = Files.readAllBytes(filepath1.toPath());
            byte[] fileContents2 = Files.readAllBytes(filepath1.toPath());
            byte[] digest1 = MessageDigest.getInstance(format).digest(fileContents1);
            byte[] digest2 = MessageDigest.getInstance(format).digest(fileContents2);
            System.out.printf("%0" + (digest1.length*2) + "x%n", new BigInteger(1, digest1));
            System.out.printf("%0" + (digest2.length*2) + "x%n", new BigInteger(1, digest2));
            return 0;
        }

        public static void main(String... args) {
            int exitCode = new CommandLine(new App()).execute(args);
            System.exit(exitCode);
        }
}
