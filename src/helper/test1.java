package helper;

import javaxt.io.Directory;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by loaner on 5/19/17.
 */
public class test1 {

    private static final String FIRE_PRE_LESSON_DIR = "/Minecraft Code/ICE/Pre Lesson Repo";

    public static void main(String[] args) throws IOException {
        Runtime rt = Runtime.getRuntime();
       // File s1 = new File("/Users/loaner/Documents/Minecraft/Student 1");
      // System.out.println(s1.getAbsolutePath()

          //  Process workspaceSetup = rt.exec( "loaner/bin/bash open Doc*");

        List<String> cmds = new ArrayList<String>();
        cmds.add("/bin/sh");
        cmds.add("-c");
        cmds.add("open Doc*");

        Process workspaceSetup = rt.exec("/bin/bash -c open Doc*");








    }

    private static void runGradleSetup(File minecraftFolder){

        Directory t = new Directory(minecraftFolder.getAbsoluteFile());

        String operatingSystem = System.getProperty("os.name");
/*
        if(operatingSystem.contains("Windows")) {
            System.out.println("Operating System: " + operatingSystem);
            Runtime rt = Runtime.getRuntime();
            try{
                System.out.println("STARTING SETUP... -close windows after completion");
                Process workspaceSetup = rt.exec("cmd.exe /c start /wait gradlew setupDecompWorkspace", null, minecraftFolder);
                System.out.println("Starting Workspace Setup...");
                workspaceSetup.waitFor();
                Process eclipseSetup = rt.exec("cmd.exe /c start /wait gradlew eclipse", null, minecraftFolder);
                System.out.println("Starting Eclipse Setup...");
                eclipseSetup.waitFor();
                System.out.println("... SETUP COMPLETE");
            }catch(InterruptedException e){
                System.out.println("Error: Interrupted Exception");
            }catch(IOException e){
                System.out.println("Error: IOException Exception");
            }
        }
*/
         if(operatingSystem.contains("Mac")){
            System.out.println("Operating System: " + operatingSystem);
            Runtime rt = Runtime.getRuntime();
            try{
                System.out.println("STARTING SETUP... -close windows after completion");

               //Process workspaceSetup = rt.exec("/bin/bash/ -c ./gradlew setupDecompWorkspace", null, minecraftFolder);
               // Process workspaceSetup = rt.exec(minecraftFolder.getAbsolutePath() + " ");
                Process workspaceSetup = rt.exec( minecraftFolder.getAbsolutePath() + "/ ./gradlew setupDecompWorkspace");
                System.out.println("Starting Workspace Setup...");




                workspaceSetup.waitFor();
                Process eclipseSetup = rt.exec("cmd.exe /c start /wait gradlew eclipse", null, minecraftFolder);
                System.out.println("Starting Eclipse Setup...");
                eclipseSetup.waitFor();
                System.out.println("... SETUP COMPLETE");



            }catch(InterruptedException e){
                System.out.println("Error: Interrupted Exception");
            }catch(IOException e){
                System.out.println("Error: IOException Exception");
            }
        }
    }


}

