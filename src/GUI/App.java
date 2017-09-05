package GUI;

import us.monoid.json.JSONException;

import javax.swing.*;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, JSONException {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setSize(1900, 1080);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
