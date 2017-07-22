package GUI;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ToolBar extends JPanel implements ActionListener{
    ToolBarListener toolBarListener ;
    boolean wrapTextFlag;
    private JButton wrapText;

    public ToolBar() {
        Icon text_icon = new ImageIcon(getClass().getResource("/Assets/wrap_text.png"));
        wrapText = new JButton(text_icon);
        wrapText.addActionListener(this);
        add(wrapText);
        wrapTextFlag = false;


    }

    public void setToolBarListener(ToolBarListener toolBarListener) {
        this.toolBarListener = toolBarListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            toolBarListener.wraptext(!wrapTextFlag);
            wrapTextFlag = !wrapTextFlag;

    }
}
