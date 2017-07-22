package GUI;

import javax.swing.*;
import java.awt.*;

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

        toolBar.setToolBarListener(new ToolBarListener() {
            @Override
            public void wraptext(boolean flag) {
                tab.wrapText(flag);
            }
        });

    }
}
