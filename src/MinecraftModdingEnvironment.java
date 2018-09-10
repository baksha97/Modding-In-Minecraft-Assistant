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

    private StudentRepository studentRepository;

    public static Directory[] getAvailableStudentsDirs(){
        String path = System.getProperty("user.home") + "/Desktop/Minecraft/Students";
        Directory studentsDirectory = new Directory(path);

        Directory[] studentDirs = studentsDirectory.getSubDirectories();

        return studentDirs;
    }

    public MinecraftModdingEnvironment(Directory studentDir) {
        this.environmentPath = System.getProperty("user.home") + "/Desktop/Minecraft";
        this.studentRepository = new StudentRepository(studentDir.getPath());
    }

    public String[] getAvailableLessons(CurriculumType curriculumType, ImportType importType){
        PresetRepository repo = new PresetRepository(curriculumType, importType, environmentPath);
        return repo.getLessonFolderNames();
    }

    public void performImport(CurriculumType curriculumType, ImportType importType, String selectedLessonName){
        PresetRepository repo = new PresetRepository(curriculumType, importType, environmentPath);
        PresetRepository.PathTuple paths = repo.getLessonPaths(selectedLessonName);
        studentRepository.importWithPaths(paths.getJavaLessonPath(), paths.getMinecraftPath());
    }

    public void gradleSetup() throws IOException, InterruptedException {
        CommandInterface.gradleSetup(studentRepository.getStudentFolderPath());
    }

    public void openEclipse() throws IOException, InterruptedException {
        CommandInterface.openEclipse(studentRepository.getStudentFolderPath());
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