package GUI;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setSize(750, 750);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
