package GUI;

import Controller.Controller;
import us.monoid.json.JSONException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.nio.file.Path;

public class MainFrame extends JFrame{

    private Tab tab;
    private ToolBar toolBar;
    private JFileChooser jFileChooser;
    private Path activePath;


    public MainFrame() throws IOException, JSONException {
        super("Text Editor");
        tab = new Tab();
        toolBar = new ToolBar();
        setLayout(new BorderLayout());
        add(toolBar,BorderLayout.NORTH);
        add(tab,BorderLayout.CENTER);
        Controller c = new Controller();
        activePath = c.activePath;
        tab.AddText(c.readData());
        jFileChooser = new JFileChooser();



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

            @Override
            public void saveAs() throws IOException, JSONException {
                jFileChooser.showSaveDialog(MainFrame.this);
                activePath = jFileChooser.getSelectedFile().toPath();
                c.saveData(tab.getText(), activePath);
                c.saveMetaData(activePath);
            }
        });

        c.autoSave(tab, activePath);


        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                try {
                    c.saveMetaData(activePath);
                    c.terminateController();
                } catch (JSONException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                dispose();
                System.gc();
            }
        });

    }
}
