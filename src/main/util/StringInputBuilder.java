package main.util;

public class StringInputBuilder {

    private String finalString;

    public StringInputBuilder() {
        finalString = "";
    }

    public String getFinalString() {
        return finalString;
    }

    public void inputs(KeyHandler keyH, MouseHandler mouseH) {
        keyH.tick();

        if (keyH.backspace.clicked && finalString.length() > 0) {
            finalString = finalString.substring(0, finalString.length() - 1);
        }

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
