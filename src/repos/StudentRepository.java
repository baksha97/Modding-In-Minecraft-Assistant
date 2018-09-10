package repos;

import javaxt.io.Directory;

public class StudentRepository {

    private String studentFolderPath;

    private String minecraftSrcPath;
    private String javaLessonPath;
    private String studentTexturePath;

    public StudentRepository(String studentFolderPath) {
        this.studentFolderPath = studentFolderPath;
        this.minecraftSrcPath = studentFolderPath + "/src";
        this.javaLessonPath = studentFolderPath + "/eclipse/JavaLessons";
        this.studentTexturePath = studentFolderPath + "/Textures";
    }

    public void importWithPaths(String javaPathUpdate, String minecraftPathUpdate){
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
        for(int i=0; i<currentTextures.length; i++){
            currentTextures[i].copyTo(texturesDic, false); //false, not overwriting any textures! --> must delete default textures in this folder to make sure that the newer textures are copied over!
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
        //Can create a Dictionary to hash each file and make operation more efficient at a later time.
        for(int x=0; x<studentTextures.length; x++){
            for(int y=0; y<lessonTextures.length; y++){
                if(studentTextures[x].getName().equals(lessonTextures[y].getName())){
                    studentTextures[x].copyTo(lessonTextures[y], true);
                    System.out.println();
                    System.out.println("Texture: " + studentTextures[x]);
                    System.out.println(" -> moved to path: " + lessonTextures[y]);
                }
            }
        }
    }


}
