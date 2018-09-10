import enums.CurriculumType;
import enums.ImportType;
import helper.StreamGobbler;
import repos.PresetRepository;
import repos.StudentRepository;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;

public class MinecraftModdingEnvironment {

    private PresetRepository presetRepository;
    private StudentRepository studentRepository;


    public MinecraftModdingEnvironment(String environmentPath, String studentFolderPath) {
        CurriculumType curriculumType = CurriculumType.FIRE;
        ImportType importType = ImportType.POST;
        String path = environmentPath;

        PresetRepository presetRepository = new PresetRepository(curriculumType, importType, path);
        this.presetRepository = presetRepository;

        StudentRepository studentRepository = new StudentRepository(studentFolderPath);
        this.studentRepository = studentRepository;
    }

    class ViewModel {
        final String HEADING = "Modding in Minecraft: Assistant"; //2.0
        final String MODDING_ENVIRONMENT_HINT = "Select Modding Environment Folder: ";
        final String STUDENT_SELECTION_HINT = "Pick the current coder: ";
        final String STUDENT_MOD_TYPE_SELECTION_HINT = "Pick the curriculum: ";
        final String IMPORT_HEADING = "Choose import repository: ";

    }


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


/**    FOLDER LAYOUT IS NOT DYNAMIC; MUST CONFORM;
 *
 * MinecraftModdingEnvironment
        ├── Minecraft Code
        │   └── /FIRE
        │   │   └── /Pre Lesson Repo
        │   │       └── /Lesson 01
        │   │           └── /JavaLessons
        │   │           └── /Minecraft
        │   │       ...
        │   │   └── /Post Lesson Repo
        │   │       └── /Lesson 01
        │   │       ...
        │   └── /ICE
        │       └── /Pre Lesson Repo
        │           ...
        │       └── /Post Lesson Repo
        │           ...
        ├── Students
        │   └── Travie
        │       └── /src
        │       └── /textures {the student's custom textures}
        │       └── /eclipse
        │           └── /JavaLessons
        ├── ?
        │   └── /?
        └── README.md
**/