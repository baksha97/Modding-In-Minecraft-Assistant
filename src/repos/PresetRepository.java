package repos;

import enums.CurriculumType;
import enums.ImportType;
import javaxt.io.Directory;

import java.io.File;

public class PresetRepository {
    //PATH CONSTANTS - may want to change "/" to File.separator eventually.
    private final String FIRE_POST_LESSON_PATH = "/Minecraft Code/FIRE/Post Lesson Repo";
    private final String FIRE_PRE_LESSON_PATH = "/Minecraft Code/FIRE/Pre Lesson Repo";
    private final String ICE_POST_LESSON_PATH = "/Minecraft Code/ICE/Post Lesson Repo";
    private final String ICE_PRE_LESSON_PATH = "/Minecraft Code/ICE/Pre Lesson Repo";

    private String selectedRepoPath;

    public PresetRepository(CurriculumType curriculumType, ImportType importType, String minecraftFolderPath){
        setSelectedDir(curriculumType, importType, minecraftFolderPath);
    }

    public PathTuple getLessonPaths(String selectedLessonName){
        String java = selectedRepoPath + selectedLessonName + File.separator + "JavaLessons";
        String minecraft = selectedRepoPath + selectedLessonName + File.separator + "Minecraft";
        PathTuple paths = new PathTuple(java, minecraft);
        return paths;
    }

    public Directory[] getLessonDirectories(){
        Directory repo = new Directory(selectedRepoPath);
        Directory[] directories = repo.getSubDirectories();
        return  directories;
    }

    public String[] getLessonFolderNames(){
        Directory[] directories = getLessonDirectories();
        String[] names = new String[directories.length];

        for(int i=0; i<directories.length; i++){
            names[i] = directories[i].getName();
        }

        return names;
    }

    private void setSelectedDir(CurriculumType curriculumType, ImportType importType, String minecraftFolderPath){
        if(importType == ImportType.PRE){
            setAsPreLessonDir(minecraftFolderPath, curriculumType);
        }else if(importType == ImportType.POST){
            setAsPostLessonDir(minecraftFolderPath, curriculumType);
        }
    }

    private void setAsPreLessonDir(String minecraftFolderPath, CurriculumType curriculumType){
        if(curriculumType == CurriculumType.FIRE){
            this.selectedRepoPath = minecraftFolderPath + FIRE_PRE_LESSON_PATH;
        }
        else if(curriculumType == CurriculumType.ICE){
            this.selectedRepoPath = minecraftFolderPath + ICE_PRE_LESSON_PATH;
        }
    }

    private void setAsPostLessonDir(String minecraftFolderPath, CurriculumType curriculumType){
        if(curriculumType == CurriculumType.FIRE){
            this.selectedRepoPath = minecraftFolderPath + FIRE_POST_LESSON_PATH;
        }
        else if(curriculumType == CurriculumType.ICE){
            this.selectedRepoPath = minecraftFolderPath + ICE_POST_LESSON_PATH;
        }
    }

    public class PathTuple {
        private String javaLessonPath;
        private String minecraftPath;

        public PathTuple(String javaLessonPath, String minecraftPath){
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
            return "[" + "Java: " + javaLessonPath +" ||| "+ "Minecraft: " + minecraftPath + "]";
        }
    }
}
