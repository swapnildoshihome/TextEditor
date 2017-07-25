package GUI;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class ToolBar extends JToolBar {
    ToolBarListener toolBarListener ;
    boolean wrapTextFlag;
    private JButton wrapText;
    private JButton refreshText;
    private JButton saveText;

    public ToolBar() {
        Icon text_icon = new ImageIcon(getClass().getResource("/Assets/wrap_text.png"));

        wrapText = new JButton(text_icon);
        wrapText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toolBarListener.wraptext(!wrapTextFlag);
                wrapTextFlag = !wrapTextFlag;

            }
        });
        add(wrapText);
        wrapTextFlag = false;

        refreshText = new JButton(new ImageIcon(getClass().getResource("/Assets/refresh.png")));
        refreshText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toolBarListener.refreshText();
            }
        });
        add(refreshText);

        saveText = new JButton(new ImageIcon(getClass().getResource("/Assets/save.png")));
        saveText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    toolBarListener.saveText();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        add(saveText);

    }

    public void setToolBarListener(ToolBarListener toolBarListener) {
        this.toolBarListener = toolBarListener;
    }

}
