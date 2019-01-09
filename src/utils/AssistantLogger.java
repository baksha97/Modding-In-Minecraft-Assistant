package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

class AssistantLogger {

    private static final String log_file = System.getProperty("user.home") +
            "/Desktop/Minecraft/" + "latest_stack_trace_error.txt";

    private static PrintWriter pw;

    public static void log(String s) {
        try {
            File log = new File(log_file);
            pw = new PrintWriter(new FileOutputStream(log, true));
            pw.append(s).append("\n\n\n");
        } catch (@SuppressWarnings("SpellCheckingInspection") FileNotFoundException fnfe) {
            onSaveFailed(fnfe);
        }
        pw.close();
    }

    public static void saveStackTrace(Exception e) {
        try {
            File log = new File(log_file);
            pw = new PrintWriter(new FileOutputStream(log, true));
            pw.append(e.toString()).append("\n\n\n");
        } catch (FileNotFoundException fnfe) {
            onSaveFailed(fnfe);
        }
        pw.close();
    }

    private static void onSaveFailed(Exception e) {
        System.out.println("<<<UNABLE TO SAVE ERROR STACKTRACE>>>");
        e.printStackTrace();
    }
}
