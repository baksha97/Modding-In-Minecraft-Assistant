import repos.PresetRepository;
import repos.StudentRepository;

/*    MinecraftModdingEnvironment Folder
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
        ├── local
        │   └── /the usual stuff/
        └── README.md

*/

public class MinecraftModdingEnvironment {

    private PresetRepository presetRepository;
    private StudentRepository studentRepository;


    public MinecraftModdingEnvironment(PresetRepository presetRepository, StudentRepository studentRepository) {
        this.presetRepository = presetRepository;
        this.studentRepository = studentRepository;
    }

}
