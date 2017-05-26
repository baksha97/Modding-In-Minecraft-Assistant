package helper;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by loaner on 5/19/17.
 */
public class test1 {

    private static final String FIRE_PRE_LESSON_DIR = "/Minecraft Code/ICE/Pre Lesson Repo";

    public static void main(String[] args){

        System.out.println(File.separator);
        System.out.println(File.separatorChar);
        System.out.println(File.pathSeparator);
        System.out.println(File.pathSeparatorChar);


/*
        File[] fs = getDictionaries(new File("/Users/loaner//Downloads/Minecraft" + FIRE_PRE_LESSON_DIR)); //new File(minecraftFolder.getAbsolutePath() + this.FIRE_PRE_LESSON_DIR).listFiles(File::isDirectory);

        System.out.println(fs);
        System.out.println(fs.length);

        for(int i=0; i<fs.length; i++){
            System.out.println(fs[i].getName());
        }

        System.out.println(fs[0]);
*/
    }

    private static File[] getDictionaries(File dir){
        File[] directories = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
        return directories;
    }


}

