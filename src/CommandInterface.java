import helper.StreamGobbler;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;

public class CommandInterface {

    public static void openEclipse(String projectPath) throws IOException, InterruptedException {
        execute("/Applications/eclipse.app/Contents/MacOS", "eclipse -data " + projectPath);

    }
    //new File(this.minecraftFolder.getAbsoluteFile() + File.separator + STUDENT1_DIR);
    public static void gradeSetup(String environmentPath) throws IOException, InterruptedException{
        int completed;
        completed = execute(environmentPath, "gradlew setupDecompWorkspace");
        completed = execute(environmentPath, "gradlew eclipse");
    }

    public static int execute(String inPath, String command) throws IOException, InterruptedException {
        File executionFolder = new File(inPath);
        String operatingSystem = System.getProperty("os.name");
        System.out.println(operatingSystem);
        if (operatingSystem.contains("Windows")) {
            return executeOnWindows(executionFolder, command);
        } else if (operatingSystem.contains("Mac")) {
            return executeOnMac(executionFolder, command);
        }

        return -1;
    }

    private static int executeOnWindows(File executionFolder, String command) throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder();
        builder.command("cmd.exe", "/c", command);
        builder.directory(executionFolder);
        Process process = builder.start();
        //Todo: implement a loading task
        return process.waitFor();
    }

    private static int executeOnMac(File executionFolder, String command) throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder();
        builder.command("sh", "-c", "./" + command);
        builder.directory(executionFolder);
        Process process = builder.start();
        //Todo: implement a loading task
        return process.waitFor();
    }


    //new File(this.minecraftFolder.getAbsoluteFile() + File.separator + STUDENT1_DIR);
    private void runGradleSetup(File s1Folder) throws IOException, InterruptedException {
        String operatingSystem = System.getProperty("os.name");
        StreamGobbler streamGobbler;
        int exitCode;
        int i;

        if (operatingSystem.contains("Windows")) {
            System.out.println("Operating System: " + operatingSystem);

            ProcessBuilder builder = new ProcessBuilder();

            System.out.println("Beginning Windows Workspace Setup...");
            builder.command("cmd.exe", "/c", "gradlew setupDecompWorkspace");
            builder.directory(s1Folder);
            Process process = builder.start();

            streamGobbler = new StreamGobbler(process.getInputStream(), System.out::println);
            Executors.newSingleThreadExecutor().submit(streamGobbler);
            exitCode = process.waitFor();
            assert exitCode == 0;

            i = process.waitFor();
            System.out.println("Workspace Installation COMPLETE");

            System.out.println("Beginning Windows Eclipse Setup...");
            builder.command("cmd.exe", "/c", "gradlew eclipse");
            builder.directory(s1Folder);
            process = builder.start();

            streamGobbler = new StreamGobbler(process.getInputStream(), System.out::println);
            Executors.newSingleThreadExecutor().submit(streamGobbler);
            exitCode = process.waitFor();
            assert exitCode == 0;

            i = process.waitFor();
            System.out.println("Eclipse Workspace Installation COMPLETE");

        } else if (operatingSystem.contains("Mac")) {
            System.out.println("Operating System: " + operatingSystem);

            ProcessBuilder builder = new ProcessBuilder();

            System.out.println("Beginning Mac Workspace Setup...");
            builder.command("sh", "-c", "./gradlew setupDecompWorkspace");
            builder.directory(s1Folder);
            Process process = builder.start();

            streamGobbler = new StreamGobbler(process.getInputStream(), System.out::println);
            Executors.newSingleThreadExecutor().submit(streamGobbler);
            exitCode = process.waitFor();
            assert exitCode == 0;

            i = process.waitFor();
            System.out.println("Workspace Installation COMPLETE");

            System.out.println("Beginning Mac Eclipse Setup...");
            builder.command("sh", "-c", "./gradlew eclipse");
            builder.directory(s1Folder);
            process = builder.start();

            streamGobbler =
                    new StreamGobbler(process.getInputStream(), System.out::println);
            Executors.newSingleThreadExecutor().submit(streamGobbler);
            exitCode = process.waitFor();
            assert exitCode == 0;

            i = process.waitFor();
            System.out.println("Eclipse Workspace Installation COMPLETE");
        }
    }
}
