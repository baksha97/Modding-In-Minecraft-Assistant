package repos;

import javaxt.io.Directory;
import javaxt.io.File;

public class StudentRepository {

    private final String studentFolderPath;

    private final String minecraftSrcPath;
    private final String javaLessonPath;
    private final String studentTexturePath;

    public StudentRepository(String studentFolderPath) {
        this.studentFolderPath = studentFolderPath; // contains a "/" at the end
        this.minecraftSrcPath = studentFolderPath + "src";
        this.javaLessonPath = studentFolderPath + "eclipse/JavaLessons";
        this.studentTexturePath = studentFolderPath + "Textures";
    }

    public void importWithPaths(String javaPathUpdate, String minecraftPathUpdate) {
        //start with saving textures
        saveTexturesFromSrc();

        //java lesson import
        Directory inputJL = new Directory(javaPathUpdate);
        Directory outputJL = new Directory(javaLessonPath);
        outputJL.delete(); //TODO: see if it still works like this, if not delete
        inputJL.copyTo(outputJL, true);
        System.out.println("Copied JavaLessons to: " + outputJL.getPath());

        //MDK lesson import
        Directory inputMDK = new Directory(minecraftPathUpdate);
        //TODO: See if I should leave it as is, and change the repo dir to contain the src FILES instead of the src FOLDER...
        Directory outputMDK = new Directory(minecraftSrcPath);
        outputMDK.delete(); //TODO: see if it still works like this, if not delete
        inputMDK.copyTo(outputMDK, true);
        System.out.println("Copied MDK/src to: " + outputMDK.getPath());

        //end with save current textures to have any updated textures in the project ready
        saveTexturesFromSrc();
        //finalize with add customized textures, included the newly added default ones to the SRC
        addTexturesToSrc();
    }

    private void saveTexturesFromSrc() {
        Directory srcDic = new Directory(minecraftSrcPath);
        Directory texturesDic = new Directory(studentTexturePath);

        javaxt.io.File[] currentTextures = srcDic.getFiles("*.png", true);
        for (File currentTexture : currentTextures) {
            currentTexture.copyTo(texturesDic, false); //false, not overwriting any textures! --> must delete default textures in this folder to make sure that the newer textures are copied over!
        }
    }

    private void addTexturesToSrc() {
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
