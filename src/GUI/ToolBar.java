package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ToolBar extends JPanel implements ActionListener{
    private JButton wrapText;
    ToolBarListener toolBarListener ;
    boolean wrapTextFlag;

    public ToolBar() {
        wrapText = new JButton("Wrap Text");
        add(wrapText);
        wrapTextFlag = false;
        wrapText.addActionListener(this);

    }

    public void setToolBarListener(ToolBarListener toolBarListener) {
        this.toolBarListener = toolBarListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand() == "Wrap Text"){
            toolBarListener.wraptext(!wrapTextFlag);
            wrapTextFlag = !wrapTextFlag;
        }
     }
}
