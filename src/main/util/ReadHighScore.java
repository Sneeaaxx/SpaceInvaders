package main.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadHighScore {

    private File datei;
    private String[] highscores;

    public ReadHighScore(String path) {
        laden(path);
    }

    private void laden(String path) {
        datei = new File(path);

        if (!datei.isFile()) {
            System.out.println("ERROR-ReadHighScore: '" + path + "' is not a file");
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
}
