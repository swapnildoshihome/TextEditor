package Controller;

import GUI.Tab;
import Model.Model;
import Model.MetaData;
import us.monoid.json.JSONException;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.TimerTask;


public class Controller {
    private Model md;
    private Scheduler sc;
    public Path activePath;
    private MetaData metaData ;
    public Boolean lastOpenedFileExist ;


    public Controller() throws IOException, JSONException {
        metaData = new MetaData();
        setActivePath();
        md = new Model(activePath);
        setLastOpenedFileExist();
    }

    public ArrayList<String> readData(){

        if (lastOpenedFileExist){
        return md.readData();
        }else{
            return null;
        }
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


    public void setLastOpenedFileExist() {
        if (metaData.metaExist) {
            lastOpenedFileExist = Files.exists(activePath);
        }else {
            lastOpenedFileExist = false ;

        }

    }

    public void setActivePath() throws JSONException, IOException {
        activePath = FileSystems.getDefault().getPath(metaData.metadata.getString("lastOpenedFile").toString());
        if (!(Files.exists(activePath))){
            String filename = "document";
            int filecounter = 1;
            String documentName ;

            do{
                documentName = filename + filecounter;
                filecounter++;
                activePath = FileSystems.getDefault().getPath("/Users/swapnil.doshi/Documents/TextEditor",documentName+".txt");
            } while(Files.exists(activePath));

            File file = new File(activePath.toString());
            file.createNewFile();
        }
    }

    public void terminateController(){
        sc.terminateTimer();
    }
}
