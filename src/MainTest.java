import enums.CurriculumType;
import enums.ImportType;
import javaxt.io.Directory;
//import javaxt.io.File;
import repos.PresetRepository;

import java.io.*;

public class MainTest {
    public static void main (String[] args){
        File log = new File("latest_stack_trace_error.txt");
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(log, true));
            pw.append("TEXT");
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
