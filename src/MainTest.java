import enums.CurriculumType;
import enums.ImportType;
import javaxt.io.Directory;
//import javaxt.io.File;
import repos.PresetRepository;

import java.io.File;
import java.io.IOException;

public class MainTest {
    public static void main (String[] args){
        CurriculumType c = CurriculumType.ICE;
        ImportType i = ImportType.POST;
        String mc = "/mc";

        PresetRepository.PathTuple lessonPaths = (new PresetRepository(c, i, mc)).getLessonPaths("/item");

//        System.out.println(lessonPaths.getJavaLessonPath());
//        System.out.println(lessonPaths.getMinecraftPath());

//        String path = System.getProperty("user.home") + "/Desktop/app_screens";
//        Directory d = new Directory(path);
//        for(File x: d.getFiles()){
//            System.out.println(x.getName());
//        }
//        System.out.println(d.getFiles().toString(
///Users/loaner/Documents/Eclipse_Projects/Learn
//        ProcessBuilder builder = new ProcessBuilder();
//        builder.command("sh", "-c", "./" + "eclipse -data /Users/loaner/Documents/Eclipse_Projects/Learn");
//        builder.directory(new File("/Applications/eclipse.app/Contents/MacOS"));
//        try {
//            Process process = builder.start();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
            CommandInterface.openEclipse("/Users/loaner/Documents/Eclipse_Projects/Learn");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
