package main.util;

public class StringInputBuilder {

    private String finalString;
    private int stringLimit;

    public StringInputBuilder() {
        finalString = "";
        stringLimit = 10;
    }

    public void setStringLimit(int i) {
        stringLimit = i;
    }

    public String getFinalString() {
        return finalString;
    }

    public void inputs(KeyHandler keyH, MouseHandler mouseH) {
        keyH.tick();

        if (keyH.backspace.clicked && finalString.length() > 0) {
            finalString = finalString.substring(0, finalString.length() - 1);
        }

        if (finalString.length() >= stringLimit) {
            finalString = finalString.substring(0, stringLimit);
        }
        else {
            if (keyH.shift.down) {
                if (keyH.a.clicked) {
                    finalString = finalString + "A";
                }
                if (keyH.b.clicked) {
                    finalString = finalString + "B";
                }
                if (keyH.c.clicked) {
                    finalString = finalString + "C";
                }
                if (keyH.d.clicked) {
                    finalString = finalString + "D";
                }
                if (keyH.e.clicked) {
                    finalString = finalString + "E";
                }
                if (keyH.f.clicked) {
                    finalString = finalString + "F";
                }
                if (keyH.g.clicked) {
                    finalString = finalString + "G";
                }
                if (keyH.h.clicked) {
                    finalString = finalString + "H";
                }
                if (keyH.i.clicked) {
                    finalString = finalString + "I";
                }
                if (keyH.j.clicked) {
                    finalString = finalString + "J";
                }
                if (keyH.k.clicked) {
                    finalString = finalString + "K";
                }
                if (keyH.l.clicked) {
                    finalString = finalString + "L";
                }
                if (keyH.m.clicked) {
                    finalString = finalString + "M";
                }
                if (keyH.n.clicked) {
                    finalString = finalString + "N";
                }
                if (keyH.o.clicked) {
                    finalString = finalString + "O";
                }
                if (keyH.p.clicked) {
                    finalString = finalString + "P";
                }
                if (keyH.q.clicked) {
                    finalString = finalString + "Q";
                }
                if (keyH.r.clicked) {
                    finalString = finalString + "R";
                }
                if (keyH.s.clicked) {
                    finalString = finalString + "S";
                }
                if (keyH.t.clicked) {
                    finalString = finalString + "T";
                }
                if (keyH.u.clicked) {
                    finalString = finalString + "U";
                }
                if (keyH.v.clicked) {
                    finalString = finalString + "V";
                }
                if (keyH.w.clicked) {
                    finalString = finalString + "W";
                }
                if (keyH.x.clicked) {
                    finalString = finalString + "X";
                }
                if (keyH.y.clicked) {
                    finalString = finalString + "Y";
                }
                if (keyH.z.clicked) {
                    finalString = finalString + "Z";
                }
            } else {
                if (keyH.a.clicked) {
                    finalString = finalString + "a";
                }
                if (keyH.b.clicked) {
                    finalString = finalString + "b";
                }
                if (keyH.c.clicked) {
                    finalString = finalString + "c";
                }
                if (keyH.d.clicked) {
                    finalString = finalString + "d";
                }
                if (keyH.e.clicked) {
                    finalString = finalString + "e";
                }
                if (keyH.f.clicked) {
                    finalString = finalString + "f";
                }
                if (keyH.g.clicked) {
                    finalString = finalString + "g";
                }
                if (keyH.h.clicked) {
                    finalString = finalString + "h";
                }
                if (keyH.i.clicked) {
                    finalString = finalString + "i";
                }
                if (keyH.j.clicked) {
                    finalString = finalString + "j";
                }
                if (keyH.k.clicked) {
                    finalString = finalString + "k";
                }
                if (keyH.l.clicked) {
                    finalString = finalString + "l";
                }
                if (keyH.m.clicked) {
                    finalString = finalString + "m";
                }
                if (keyH.n.clicked) {
                    finalString = finalString + "n";
                }
                if (keyH.o.clicked) {
                    finalString = finalString + "o";
                }
                if (keyH.p.clicked) {
                    finalString = finalString + "p";
                }
                if (keyH.q.clicked) {
                    finalString = finalString + "q";
                }
                if (keyH.r.clicked) {
                    finalString = finalString + "r";
                }
                if (keyH.s.clicked) {
                    finalString = finalString + "s";
                }
                if (keyH.t.clicked) {
                    finalString = finalString + "t";
                }
                if (keyH.u.clicked) {
                    finalString = finalString + "u";
                }
                if (keyH.v.clicked) {
                    finalString = finalString + "v";
                }
                if (keyH.w.clicked) {
                    finalString = finalString + "w";
                }
                if (keyH.x.clicked) {
                    finalString = finalString + "x";
                }
                if (keyH.y.clicked) {
                    finalString = finalString + "y";
                }
                if (keyH.z.clicked) {
                    finalString = finalString + "z";
                }
            }
        }
    }
}
