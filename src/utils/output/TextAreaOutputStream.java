package utils.output;

import javax.swing.*;
import java.io.OutputStream;

/**
 * This class extends from OutputStream to redirect output to a JTextArea
 *
 * @author www.codejava.net
 */
public class TextAreaOutputStream extends OutputStream {
    private final JTextArea textArea;

    public TextAreaOutputStream(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void write(int b) {
        // redirects data to the text area
        textArea.append(String.valueOf((char) b));
        // scrolls the text area to the end of data
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}