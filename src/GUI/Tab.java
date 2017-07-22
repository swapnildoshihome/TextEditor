package GUI;

import javax.swing.*;
import java.awt.*;

public class Tab extends JPanel{
    private JTextArea textArea;

    public Tab() {
        textArea = new JTextArea();
        setLayout(new BorderLayout());
        add(new JScrollPane(textArea),BorderLayout.CENTER);
    }

    public void wrapText(boolean flag){
        textArea.setLineWrap(flag);
    }
}
