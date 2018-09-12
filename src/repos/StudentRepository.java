package repos;

import javaxt.io.Directory;
import javaxt.io.File;
import utils.AssistantUtil;

public class StudentRepository {

    private final String studentFolderPath;

    private final String minecraftSrcPath;
    private final String javaLessonPath;
    private final String studentTexturePath;
    private final String javaLessonSrcPath;

    public String getEclipseProjectPath() {
        return eclipseProjectPath;
    }

    private final String eclipseProjectPath;

    public StudentRepository(String studentFolderPath) {
        this.studentFolderPath = studentFolderPath; // contains a "/" at the end
        this.minecraftSrcPath = studentFolderPath + "src";
        this.eclipseProjectPath = studentFolderPath + "eclipse";
        this.javaLessonPath = studentFolderPath + "eclipse/JavaLessons";
        this.javaLessonSrcPath = studentFolderPath + "eclipse/JavaLessons/src";
        this.studentTexturePath = studentFolderPath + "Textures";
    }

    //For some untraceable reason, the current file handling library does not allow us to delete the "SRC" folders in
    // the Eclipse projects.
    private void deleteCurrentMDK(){
        AssistantUtil.deleteFolder(this.minecraftSrcPath);
    }

    private void deleteCurrentJL(){
        AssistantUtil.deleteFolder(this.javaLessonSrcPath);
    }

    public String importWithPaths(String javaPathUpdate, String minecraftPathUpdate) {
        String importedTo = "";
        //start with saving textures
        saveTexturesFromSrc();

        //java lesson import
        Directory inputJL = new Directory(javaPathUpdate);
        Directory outputJL = new Directory(javaLessonPath);
        deleteCurrentJL();
        inputJL.copyTo(outputJL, true);
        importedTo = "[SR]: JavaLessons ->" + outputJL.getPath();

        //MDK lesson import
        Directory inputMDK = new Directory(minecraftPathUpdate);
        //The post repo contains the SRC folder, so we will set the outputMDK to the parent folder.
        Directory outputMDK = new Directory(this.studentFolderPath);
        deleteCurrentMDK();
        inputMDK.copyTo(outputMDK, true);
        importedTo = importedTo + "\n" + "[SR]: MDK/src -> " + outputMDK.getPath();

        //end with save current textures to have any updated textures in the project ready
        saveTexturesFromSrc();
        //finalize with add customized textures, included the newly added default ones to the SRC
        addTexturesToSrc();

        return importedTo;
    }

    private void saveTexturesFromSrc() {
        Directory srcDic = new Directory(minecraftSrcPath);
        Directory texturesDic = new Directory(studentTexturePath);

        javaxt.io.File[] currentTextures = srcDic.getFiles("*.png", true);
        for (File currentTexture : currentTextures) {
            //false overwrite, not overwriting any textures! -->
            // must delete default textures in this folder to make sure that the newer textures are copied over!
            currentTexture.copyTo(texturesDic, false);
        }
    }

    public void addTexturesToSrc() {
        //makes sure that the addition of new textures are the latest
        saveTexturesFromSrc();

        Directory srcDic = new Directory(minecraftSrcPath);
        Directory texturesDic = new Directory(studentTexturePath);

        javaxt.io.File[] lessonTextures = srcDic.getFiles("*.png", true);
        javaxt.io.File[] studentTextures = texturesDic.getFiles("*.png", true);
        //Replace lesson textures with student textures.
        //Can get a Dictionary to hash each file and make operation more efficient at a later time.
        for (File studentTexture : studentTextures) {
            for (File lessonTexture : lessonTextures) {
                if (studentTexture.getName().equals(lessonTexture.getName())) {
                    studentTexture.copyTo(lessonTexture, true);
                    System.out.println();
                    System.out.println("Texture: " + studentTexture);
                    System.out.println(" -> moved to path: " + lessonTexture);
                }
            }
        }
    }

    public String getStudentFolderPath() {
        return studentFolderPath;
    }

}
