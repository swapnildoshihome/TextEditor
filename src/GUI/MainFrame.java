package GUI;

import Controller.Controller;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainFrame extends JFrame{

    private Tab tab;
    private ToolBar toolBar;

    public MainFrame(){
        super("Text Editor");
        tab = new Tab();
        toolBar = new ToolBar();
        setLayout(new BorderLayout());
        add(toolBar,BorderLayout.NORTH);
        add(tab,BorderLayout.CENTER);
        Controller c = new Controller();
        tab.AddText(c.readData());

        toolBar.setToolBarListener(new ToolBarListener() {
            @Override
            public void wraptext(boolean flag) {
                tab.wrapText(flag);
            }

            @Override
            public void refreshText() {
                tab.AddText(c.readData());
            }

            @Override
            public void saveText() throws IOException {
                c.saveData(tab.getText());
            }
        });

        c.autoSave(tab);

    }
}
