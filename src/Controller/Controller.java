package Controller;

import GUI.Tab;
import Model.Model;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TimerTask;


public class Controller {
    private Model md;
    private Scheduler sc;
    public Controller() {
        md = new Model();
    }

    public ArrayList<String> readData(){
        return md.readData();
    }

    public void saveData(ArrayList<String> data) throws IOException {
        md.saveData(data);
    }

    public void autoSave(Tab tab) {
        sc = new Scheduler(new TimerTask() {

            @Override
            public void run() {
                try {
                    md.saveData(tab.getText());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
