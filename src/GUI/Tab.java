package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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

    public void AddText(ArrayList<String> data) {


        String text = "";

        for (String s : data) {
            text = text + "\n" + s;
        }
        textArea.setText(text.replaceFirst("\n", ""));
    }

    public ArrayList<String> getText() {
        ArrayList<String> text = new ArrayList<>();
        for (String s : textArea.getText().split("\\n")) {
            text.add(s);
        }
        return text;
    }
}
