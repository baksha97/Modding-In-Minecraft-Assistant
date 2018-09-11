package repos;

import javaxt.io.Directory;
import utils.enums.CurriculumType;
import utils.enums.ImportType;

public class PresetRepository {
    //PATH CONSTANTS - may want to change "/" to File.separator eventually.
    private static final String FIRE_POST_LESSON_PATH = "/Minecraft Code/FIRE/Post Lesson Repo";
    private static final String FIRE_PRE_LESSON_PATH = "/Minecraft Code/FIRE/Pre Lesson Repo";
    private static final String ICE_POST_LESSON_PATH = "/Minecraft Code/ICE/Post Lesson Repo";
    private static final String ICE_PRE_LESSON_PATH = "/Minecraft Code/ICE/Pre Lesson Repo";

    private String selectedRepoPath;

    private PresetRepository(CurriculumType curriculumType, ImportType importType, String minecraftFolderPath) {
        setSelectedRepoPath(curriculumType, importType, minecraftFolderPath);
    }

    public static PresetRepository get(CurriculumType curriculumType, ImportType importType, String minecraftFolderPath) {
        return new PresetRepository(curriculumType, importType, minecraftFolderPath);
    }

    public PathTuple getLessonPaths(String selectedLessonName) {
        String java = selectedRepoPath + selectedLessonName + "/JavaLessons";
        String minecraft = selectedRepoPath + selectedLessonName + "/Minecraft";
        return new PathTuple(java, minecraft);
    }

    private Directory[] getLessonDirectories() {
        Directory repo = new Directory(selectedRepoPath);
        return repo.getSubDirectories();
    }

    public String[] getLessonFolderNames() {
        Directory[] directories = getLessonDirectories();
        String[] names = new String[directories.length];

        for (int i = 0; i < directories.length; i++) {
            names[i] = directories[i].getName();
        }

        return names;
    }

    private void setSelectedRepoPath(CurriculumType curriculumType, ImportType importType, String minecraftFolderPath) {
        if (importType == ImportType.PRE) {
            setAsPreLesson(minecraftFolderPath, curriculumType);
        } else if (importType == ImportType.POST) {
            setAsPostLesson(minecraftFolderPath, curriculumType);
        }
    }

    private void setAsPreLesson(String minecraftFolderPath, CurriculumType curriculumType) {
        if (curriculumType == CurriculumType.FIRE) {
            this.selectedRepoPath = minecraftFolderPath + FIRE_PRE_LESSON_PATH;
        } else if (curriculumType == CurriculumType.ICE) {
            this.selectedRepoPath = minecraftFolderPath + ICE_PRE_LESSON_PATH;
        }
    }

    private void setAsPostLesson(String minecraftFolderPath, CurriculumType curriculumType) {
        if (curriculumType == CurriculumType.FIRE) {
            this.selectedRepoPath = minecraftFolderPath + FIRE_POST_LESSON_PATH;
        } else if (curriculumType == CurriculumType.ICE) {
            this.selectedRepoPath = minecraftFolderPath + ICE_POST_LESSON_PATH;
        }
    }

    public class PathTuple {
        private final String javaLessonPath;
        private final String minecraftPath;

        PathTuple(String javaLessonPath, String minecraftPath) {
            this.javaLessonPath = javaLessonPath;
            this.minecraftPath = minecraftPath;
        }

        public String getJavaLessonPath() {
            return javaLessonPath;
        }

        public String getMinecraftPath() {
            return minecraftPath;
        }

        @Override
        public String toString() {
            return "[" + "Java: " + javaLessonPath + " ||| " + "Minecraft: " + minecraftPath + "]";
        }
    }
}
