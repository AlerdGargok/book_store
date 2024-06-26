package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

//filemanager para salvar a lista de livros atualizada em um arquivo.txt;
/**
 * FileManager
 */
public class FileManager {

     private String filename;

    public FileManager(String filename) {
        this.filename = filename;
    }

    public void saveToFile(List<String> data) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, false))) {
            for (String line : data) {
                writer.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> readFromFile() {
        List<String> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
