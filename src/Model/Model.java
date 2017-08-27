package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Model {
    private String line;
    private Path path;
    private ArrayList<String> data;
    private Charset charset;

    public Model() {
        charset = Charset.forName("US-ASCII");
        line = null;
        path = FileSystems.getDefault().getPath("/Users/swapnil.doshi/Documents/TextEditor", "sample.txt");
    }

    public ArrayList<String> readData() {
        ArrayList<String> data = new ArrayList<>();

        try {
            BufferedReader reader = Files.newBufferedReader(path, charset);
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
            return null;
        }

        return data;
    }

    public void saveData(ArrayList<String> data) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(path, charset);

        for (String s : data) {
            writer.append(s + "\n");
        }
        writer.close();

    }
}
