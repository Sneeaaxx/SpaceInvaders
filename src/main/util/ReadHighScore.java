package main.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadHighScore {

    private File datei;
    private String[] highscores;

    public ReadHighScore(String path) {
        highscores = new String[10];

        laden(path);
    }

    private void laden(String path) {
        datei = new File(path);

        if (!datei.isFile()) {
            System.out.println("ERROR-ReadingHighScore: Couldn't load file '" + path + "'");
        }
    }

    public void lesen() {
        Scanner scan = null;
        try {
            scan = new Scanner(datei);
        } catch (FileNotFoundException e) {
            System.out.println("ERROR-ReadingHighScore: Couldn't scan 'datei'");
        }

        for (int i = 0; i < 10; i++) {
            assert scan != null;

            if (scan.hasNext()) {
                highscores[i] = scan.nextLine();
            }
        }
    }

    public String[] getHighscores() {
        return highscores;
    }
}
