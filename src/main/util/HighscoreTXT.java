package main.util;

import java.io.*;

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

    public void sort() {
        for (int i = 0; i < hs.length; i++) {
            for (int j = 0; j < hs.length - i - 1; j++) {
                if (hs[j] != null && hs[j + 1] != null) {
                    if (Integer.parseInt(hs[j].substring(hs[j].indexOf(" ") + 1)) < Integer.parseInt(hs[j+1].substring(hs[j+1].indexOf(" ") + 1))) {
                        String temp = hs[j];
                        hs[j] = hs[j + 1];
                        hs[j + 1] = temp;
                    }
                }
            }
        }
    }

    public void addHighScore(String highscore) {
        for (int i = 0; i < hs.length; i++) {
            if (hs[i] == null) {
                hs[i] = highscore;
                break;
            }
        }

        sort();
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