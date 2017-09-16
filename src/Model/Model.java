package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Model {
    private String line;
    private Path path;
    private ArrayList<String> data;
    private Charset charset;

    public Model(Path p) {
        charset = Charset.forName("US-ASCII");
        line = null;
        path = p;
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
            writer.write(System.lineSeparator());
        }
        writer.close();

    }

    public void saveData(ArrayList<String> data,Path path) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(path, charset);

        for (String s : data) {
            writer.append(s + "\n");
        }
        writer.close();

    }

}
