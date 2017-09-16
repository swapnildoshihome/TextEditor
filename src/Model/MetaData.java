package Model;

import us.monoid.json.JSONException;
import us.monoid.json.JSONObject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class MetaData {
    public JSONObject metadata ;
    private Path metaFilePath;
    public boolean metaExist;
    private Charset charset;

    public MetaData() throws IOException, JSONException {
        metadata = new JSONObject();
        metaFilePath = FileSystems.getDefault().getPath("/Users/swapnil.doshi/Documents/TextEditor", "metadata.json");
        charset = Charset.forName("US-ASCII");
        setMetaData();
        metaExist = Files.exists(metaFilePath);
    }

    public void addToMetaObj(String key,String value) throws JSONException {
        metadata.put(key,value);
    }

    public void saveMetaData() throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(metaFilePath, charset);
        writer.write(metadata.toString());
        writer.close();
    }

    public void setMetaData() throws IOException, JSONException {
         metadata = new JSONObject(Files.newBufferedReader(metaFilePath, charset).readLine());
    }

}
