package GUI;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ToolBar extends JPanel implements ActionListener{
    ToolBarListener toolBarListener ;
    boolean wrapTextFlag;
    private JButton wrapText;

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
