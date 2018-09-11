package utils;

import utils.helper.StreamGobbler;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;

public class CommandExecutor {

    public static void openEclipse(String projectPath, String eclipsePath) throws IOException, InterruptedException {
        int completed;
        String operatingSystem = System.getProperty("os.name");
        System.out.println(operatingSystem + "Opening eclipse...");

        if (operatingSystem.contains("Windows")) {
            completed = execute(eclipsePath, "eclipse -data " + projectPath); //TODO: CHECK
            assert completed == 0;
        } else if (operatingSystem.contains("Mac")) {
            completed = execute("/Applications/eclipse.app/Contents/MacOS", "eclipse -data " + projectPath);
            assert completed == 0;
        }
    }

    public static void gradleSetup(String studentFolderPath) throws IOException, InterruptedException {
        int completed;
        completed = execute(studentFolderPath, "gradlew setupDecompWorkspace");
        assert completed == 0;
        completed = execute(studentFolderPath, "gradlew eclipse");
        assert completed == 0;
    }

    private static int execute(String inPath, String command) throws IOException, InterruptedException {
        File executionFolder = new File(inPath);
        String operatingSystem = System.getProperty("os.name");
        System.out.println(operatingSystem);
        if (operatingSystem.contains("Windows")) {
            return executeOnWindows(executionFolder, command);
        } else if (operatingSystem.contains("Mac")) {
            return executeOnMac(executionFolder, command);
        }

        return 0;
    }

    private static int executeOnWindows(File executionFolder, String command) throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder();
        builder.command("cmd.exe", "/c", command);
        builder.directory(executionFolder);
        Process process = builder.start();

        StreamGobbler streamGobbler = new StreamGobbler(process.getInputStream(), System.out::println);
        Executors.newSingleThreadExecutor().submit(streamGobbler);

        //Todo: implement a loading task
        return process.waitFor();
    }

    private static int executeOnMac(File executionFolder, String command) throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder();
        builder.command("sh", "-c", "./" + command);
        builder.directory(executionFolder);
        Process process = builder.start();

        StreamGobbler streamGobbler = new StreamGobbler(process.getInputStream(), System.out::println);
        Executors.newSingleThreadExecutor().submit(streamGobbler);

        //Todo: implement a loading task
        return process.waitFor();
    }


}
