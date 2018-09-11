package utils.output;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class AssistantLogger {

    private static PrintWriter pw;

    public static void log(String s) {
        try {
            File log = new File("latest_stack_trace_error.txt");
            pw = new PrintWriter(new FileOutputStream(log, true));
            pw.append(s + "\n\n\n");
        } catch (FileNotFoundException fnfe) {
            System.out.println("<<<Unable to add to log>>");
            fnfe.printStackTrace();
        }
        pw.close();
    }

    public static void saveStackTrace(Exception e) {
        try {
            File log = new File("latest_stack_trace_error.txt");
            pw = new PrintWriter(new FileOutputStream(log, true));
            pw.append(e.toString() + "\n\n\n");
        } catch (FileNotFoundException fnfe) {
            System.out.println("<<<UNABLE TO SAVE ERROR STACKTRACE>>>");
            fnfe.printStackTrace();
        }
        pw.close();
    }
}
