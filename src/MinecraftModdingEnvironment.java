import enums.CurriculumType;
import enums.ImportType;
import helper.StreamGobbler;
import javaxt.io.Directory;
import repos.PresetRepository;
import repos.StudentRepository;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;


public class MinecraftModdingEnvironment {

    private String environmentPath;

    private String[] studentNames;
    private Directory[] studentDirs;

    private StudentRepository studentRepository;

    public static String[] getAvailableStudents(){
        String path = System.getProperty("user.home") + "/Desktop/Minecraft/Students";
        Directory studentsDirectory = new Directory(path);

        Directory[] studentDirs = studentsDirectory.getSubDirectories();
        String[] studentNames = new String[studentDirs.length];
        for(int i=0; i<studentNames.length; i++){
            studentNames[i] = studentDirs[i].getName();
        }

        return studentNames;
    }

    public MinecraftModdingEnvironment(int studentIndex) {
        setEnvironmentPath();
        setStudents();
        this.studentRepository = new StudentRepository(studentDirs[studentIndex].getPath());
    }

    public void performImport(CurriculumType curriculumType, ImportType importType, String selectedLessonName){
        PresetRepository repo = new PresetRepository(curriculumType, importType, environmentPath);
        PresetRepository.PathTuple paths = repo.getLessonPaths(selectedLessonName);
        studentRepository.importWithPaths(paths.getJavaLessonPath(), paths.getMinecraftPath());
    }

    public String[] getLessonsAvailable(CurriculumType curriculumType, ImportType importType){
        PresetRepository repo = new PresetRepository(curriculumType, importType, environmentPath);
        return repo.getLessonFolderNames();
    }


    private void setEnvironmentPath(){
        this.environmentPath = System.getProperty("user.home") + "/Desktop/Minecraft";
    }

    private void setStudents(){
        Directory studentsDirectory = new Directory(this.environmentPath + "/Students");
        this.studentDirs = studentsDirectory.getSubDirectories();
        this.studentNames = new String[studentDirs.length];
        for(int i=0; i<studentNames.length; i++){
            studentNames[i] = studentDirs[i].getName();
        }
    }


//TODO: IMPLEMENT LATER like this as reference...
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