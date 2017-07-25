package GUI;

import Model.Model;

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
        Model model = new Model();
        tab.AddText(model.readData());


        toolBar.setToolBarListener(new ToolBarListener() {
            @Override
            public void wraptext(boolean flag) {
                tab.wrapText(flag);
            }

            @Override
            public void refreshText() {
                tab.AddText(model.readData());
            }

            @Override
            public void saveText() throws IOException {
                model.saveData(tab.getText());
            }
        });

    }
}
