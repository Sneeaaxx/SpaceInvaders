package main.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HighscoreTXT {

    private File datei;
    private Scanner scan;
    private String[] highscores;

    public HighscoreTXT(String path) {
        highscores = new String[10];

        laden(path);
    }

    private void laden(String path) {
        datei = new File(path);

        if (!datei.isFile()) {
            System.out.println("ERROR-HighscoreTXT: Couldn't load file '" + path + "'");
        }

        scan = null;
        try {
            scan = new Scanner(datei);
        } catch (FileNotFoundException e) {
            System.out.println("ERROR-HighscoreTXT: Couldn't load scanner");
        }
    }

    public void lesen() {
        for (int i = 0; i < 10; i++) {
            assert scan != null;

            if (scan.hasNext()) {
                highscores[i] = scan.nextLine();
            }
        }
    }

    public void highscoreHinzufuegen(String highscore) {
        
        if (highscores[0] == null) {
            highscores[0] = highscore;
            return;
        }

        String space = null;

        for (int i = 0; i < highscores.length; i++) {
            if (highscores[i] != null) {
                if (Integer.parseInt(highscores[i].substring(highscores[i].indexOf(" ") + 1)) < Integer.parseInt(highscore.substring(highscore.indexOf(" ") + 1))) {
                    space = highscores[i];
                    highscores[i] = highscore;
                    highscore = space;

                }
            } else {
                highscores[i] = highscore;
                return;
            }
        }
    }

    public String[] getHighscores() {
        return highscores;
    }
}
