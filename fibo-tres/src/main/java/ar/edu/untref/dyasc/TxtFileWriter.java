package ar.edu.untref.dyasc;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

public class TxtFileWriter {

    private FileWriter fileWriter;

    public TxtFileWriter(String fileName) throws IOException{
        fileWriter = new FileWriter(fileName+".txt");
    }

    public void writeLine(String text) throws IOException{
        fileWriter.write(text + "\n");
    }

    public void close() throws IOException{
        if (fileWriter != null) {
            fileWriter.close();
        }
    }
}
