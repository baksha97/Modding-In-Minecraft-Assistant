import javaxt.io.Directory;
import repos.PresetRepository;
import repos.StudentRepository;
import utils.CommandExecutor;
import utils.enums.CurriculumType;
import utils.enums.ImportType;


public class MinecraftModdingEnvironment {

    private static final String environmentPath = System.getProperty("user.home") + "/Desktop/Minecraft";
    private static final String eclipsePath = environmentPath + "/eclipse";
    private final StudentRepository studentRepository;

    public MinecraftModdingEnvironment(Directory studentDir) {
        this.studentRepository = new StudentRepository(studentDir.getPath());
    }

    public static Directory[] getAvailableStudentsDirs() {
        String path = environmentPath + "/Students";
        Directory studentsDirectory = new Directory(path);
        return studentsDirectory.getSubDirectories();
    }

    public static String[] getAvailableStudentsNames() {
        Directory[] studentDirs = getAvailableStudentsDirs();
        String[] names = new String[studentDirs.length];
        for (int i = 0; i < studentDirs.length; i++) {
            names[i] = studentDirs[i].getName();
        }
        return names;
    }

    public String[] getAvailableLessons(CurriculumType curriculumType, ImportType importType) {
        return PresetRepository.get(curriculumType, importType, environmentPath).getLessonFolderNames();
    }

    public String performImport(CurriculumType curriculumType, ImportType importType, String selectedLessonName) {
        PresetRepository.PathTuple paths =
                PresetRepository.get(curriculumType, importType, environmentPath)
                        .getLessonPaths(selectedLessonName);
        return studentRepository.importWithPaths(paths.getJavaLessonPath(), paths.getMinecraftPath());
    }

    public void gradleSetup() {
            CommandExecutor.gradleSetup(studentRepository.getStudentFolderPath());
    }

    public void openEclipse() {
            CommandExecutor.openEclipse(studentRepository.getStudentFolderPath(), eclipsePath);

    }

}


/**
 * FOLDER LAYOUT IS NOT DYNAMIC; MUST CONFORM;
 * <p>
 * [/Desktop/Minecraft]
 * ├── Minecraft Code
 * │   └── /FIRE
 * │   │   └── /Pre Lesson Repo
 * │   │       └── /Lesson 01
 * │   │           └── /JavaLessons
 * │   │           └── /Minecraft
 * │   │       ...
 * │   │   └── /Post Lesson Repo
 * │   │       └── /Lesson 01
 * │   │       ...
 * │   └── /ICE
 * │       └── /Pre Lesson Repo
 * │           ...
 * │       └── /Post Lesson Repo
 * │           ...
 * ├── Students
 * │   └── /Travie
 * │       └── /src
 * │       └── /textures {the student's custom textures}
 * │       └── /eclipse
 * │           └── /JavaLessons
 * ├── eclipse
 * │   └── /eclipse.exe
 * └── README.md
 **/