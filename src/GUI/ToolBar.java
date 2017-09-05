package GUI;


import us.monoid.json.JSONException;

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
    private JButton saveAs;


    public ToolBar() {
        Icon text_icon = new ImageIcon(getClass().getResource("/Assets/AlignJustify24.gif"));
        wrapText = new JButton(text_icon);
        wrapText.setToolTipText("Wrap Text");
        wrapText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toolBarListener.wraptext(!wrapTextFlag);
                wrapTextFlag = !wrapTextFlag;

            }
        });
        add(wrapText);
        wrapTextFlag = false;

        refreshText = new JButton(new ImageIcon(getClass().getResource("/Assets/Refresh24.gif")));
        refreshText.setToolTipText("Refresh");
        refreshText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toolBarListener.refreshText();
            }
        });
        add(refreshText);

        saveText = new JButton(new ImageIcon(getClass().getResource("/Assets/Save24.gif")));
        saveText.setToolTipText("Save");
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


        saveAs = new JButton(new ImageIcon(getClass().getResource("/Assets/SaveAs24.gif")));
        saveAs.setToolTipText("Save As");
        saveAs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    toolBarListener.saveAs();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (JSONException e1) {
                    e1.printStackTrace();
                }
            }
        });
        add(saveAs);

    }

    public void setToolBarListener(ToolBarListener toolBarListener) {
        this.toolBarListener = toolBarListener;
    }

}
