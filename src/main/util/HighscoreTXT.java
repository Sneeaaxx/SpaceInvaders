package main.util;

import java.io.*;
import java.util.ArrayList;

public class HighscoreTXT {

    private String path;
    private BufferedReader reader;
    private BufferedWriter writer;
    private String[] hs;

    public HighscoreTXT(String path) {
        this.path = path;

        hs = new String[100];

        read();
    }

    public String[] getHihscoreList() {
        return hs;
    }

    public void read() {
        try {
            reader = new BufferedReader(new FileReader(path));

            for (int i = 0; i < hs.length; i++) {
                if (!reader.equals("")) {
                    hs[i] = reader.readLine();
                }
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("ERROR-HighscoreTXT: Couldn't load reader");
        }
    }

    public void addHighScore(String highscore) {
        for (int i = 0; i < hs.length; i++) {
            if (hs[i] == null) {
                hs[i] = highscore;
                break;
            }
        }
    }

    public void write() {
        try {
            writer = new BufferedWriter(new FileWriter(path));

            for (String h : hs) {
                if (h != null) {
                    writer.write(h);
                    writer.newLine();
                }
            }

            writer.close();
        } catch(IOException e) {
            System.out.println("ERROR-HighscoreTXT: writer couldn't load");
        }
    }
}