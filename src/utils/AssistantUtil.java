package utils;

import utils.output.TextAreaOutputStream;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.PrintStream;

public class AssistantUtil {
    public static String toTitleCase(String s) {

        final String ACTIONABLE_DELIMITERS = " '-/"; // these cause the character following
        // to be capitalized


        StringBuilder sb = new StringBuilder();
        boolean capNext = true;

        for (char c : s.toCharArray()) {
            c = (capNext)
                    ? Character.toUpperCase(c)
                    : Character.toLowerCase(c);
            sb.append(c);
            capNext = (ACTIONABLE_DELIMITERS.indexOf((int) c) >= 0); // explicit cast not needed
        }
        return sb.toString();
    }

    public static void showSystemOut() {
        // String text = "one two three four five six seven eight nine ten ";
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setColumns(30);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        PrintStream printStream = new PrintStream(new TextAreaOutputStream(textArea));
        PrintStream standardOut = System.out;

        // re-assigns standard output stream and error output stream
        System.setOut(printStream);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(500, 500));//<-----any size you want
        JOptionPane.showMessageDialog(null, scrollPane, "System.out", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void presentAboutDialog(){
        JOptionPane.showMessageDialog(null,
                "Developed by Travis \n" +
                        "@ https://github.com/baksha97/");
    }

    public static void deleteFolder(File folder) {
        File[] files = folder.listFiles();
        if (files != null) { //some JVMs return null for empty dirs
            for (File f : files) {
                if (f.isDirectory()) {
                    deleteFolder(f);
                } else {
                    f.delete();
                }
            }
        }
        folder.delete();
    }

    public static void deleteFolder(String path) {
        File folder = new File(path);
        File[] files = folder.listFiles();
        if (files != null) { //some JVMs return null for empty dirs
            for (File f : files) {
                if (f.isDirectory()) {
                    deleteFolder(f);
                } else {
                    f.delete();
                }
            }
        }
        folder.delete();
    }
}
