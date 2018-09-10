import enums.CurriculumType;
import enums.ImportType;
import javaxt.io.Directory;
import repos.PresetRepository;
import repos.StudentRepository;

import java.io.IOException;


public class MinecraftModdingEnvironment {

    private static final String environmentPath = System.getProperty("user.home") + "/Desktop/Minecraft";
    private static String eclipsePath = environmentPath + "/eclipse";;

    private StudentRepository studentRepository;

    public static Directory[] getAvailableStudentsDirs(){
        String path = environmentPath + "/Students";
        Directory studentsDirectory = new Directory(path);
        Directory[] studentDirs = studentsDirectory.getSubDirectories();
        return studentDirs;
    }

    public MinecraftModdingEnvironment(Directory studentDir) {
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
        CommandExecutor.gradleSetup(studentRepository.getStudentFolderPath());
    }

    public void openEclipse() throws IOException, InterruptedException {
        CommandExecutor.openEclipse(studentRepository.getStudentFolderPath(), this.eclipsePath);
    }

}


/**    FOLDER LAYOUT IS NOT DYNAMIC; MUST CONFORM;
 *
 * [/Desktop/Minecraft]
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
        │   └── /Travie
        │       └── /src
        │       └── /textures {the student's custom textures}
        │       └── /eclipse
        │           └── /JavaLessons
        ├── eclipse
        │   └── /eclipse.exe
        └── README.md
**/