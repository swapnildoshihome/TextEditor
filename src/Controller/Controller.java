package Controller;

import GUI.Tab;
import Model.Model;
import Model.MetaData;
import us.monoid.json.JSONException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.TimerTask;


public class Controller {
    private Model md;
    private Scheduler sc;
    public Path activePath;
    private MetaData metaData ;


    public Controller() throws IOException, JSONException {
        metaData = new MetaData();
        activePath = FileSystems.getDefault().getPath(metaData.metadata.getString("lastOpenedFile").toString());
        md = new Model(activePath);
    }

    public ArrayList<String> readData(){
        return md.readData();
    }

    public void saveData(ArrayList<String> data) throws IOException {
        md.saveData(data);
    }

    public void autoSave(Tab tab,Path path) {
        sc = new Scheduler(new TimerTask() {

            @Override
            public void run() {
                try {
                    md.saveData(tab.getText(),path);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public void saveData(ArrayList<String> data, Path path) throws IOException {
        md.saveData(data,path);
    }

    public void saveMetaData(Path p) throws JSONException, IOException {
        metaData.addToMetaObj("lastOpenedFile",p.toString());
        metaData.saveMetaData();
    }



}
