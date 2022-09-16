package main.util;

import main.Panel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class KeyHandler implements KeyListener {

    public static List<Key> keys = new ArrayList<>();

    public static class Key {

        public int presses, absorbs;
        public boolean down, clicked;

        public Key(){
            keys.add(this);
        }

        public void toggle(boolean pressed) {
            if(pressed != down) {
                down = pressed;
            }
            if(pressed){
                presses++;
            }
        }

        public void tick(){
            if(absorbs < presses) {
                absorbs++;
                clicked = true;
            } else {
                clicked = false;
            }
        }
    }


    public Key a = new Key();
    public Key b = new Key();
    public Key c = new Key();
    public Key d = new Key();
    public Key e = new Key();
    public Key f = new Key();
    public Key g = new Key();
    public Key h = new Key();
    public Key i = new Key();
    public Key j = new Key();
    public Key k = new Key();
    public Key l = new Key();
    public Key m = new Key();
    public Key n = new Key();
    public Key o = new Key();
    public Key p = new Key();
    public Key q = new Key();
    public Key r = new Key();
    public Key s = new Key();
    public Key t = new Key();
    public Key u = new Key();
    public Key v = new Key();
    public Key w = new Key();
    public Key x = new Key();
    public Key y = new Key();
    public Key z = new Key();

    public Key escape = new Key();
    public Key space = new Key();
    public Key F1 = new Key();

    public KeyHandler(Panel game) {
        game.addKeyListener(this);
    }

    public void releaseAll() {
        for (Key key : keys) {
            key.down = false;
        }
    }

    public void tick() {
        for (Key key : keys) {
            key.tick();
        }
    }

    public void toggle(KeyEvent event, boolean pressed) {
        if(event.getKeyCode() == KeyEvent.VK_A) a.toggle(pressed);
        if(event.getKeyCode() == KeyEvent.VK_B) b.toggle(pressed);
        if(event.getKeyCode() == KeyEvent.VK_C) c.toggle(pressed);
        if(event.getKeyCode() == KeyEvent.VK_D) d.toggle(pressed);
        if(event.getKeyCode() == KeyEvent.VK_E) e.toggle(pressed);
        if(event.getKeyCode() == KeyEvent.VK_F) f.toggle(pressed);
        if(event.getKeyCode() == KeyEvent.VK_G) g.toggle(pressed);
        if(event.getKeyCode() == KeyEvent.VK_H) h.toggle(pressed);
        if(event.getKeyCode() == KeyEvent.VK_I) i.toggle(pressed);
        if(event.getKeyCode() == KeyEvent.VK_J) j.toggle(pressed);
        if(event.getKeyCode() == KeyEvent.VK_K) k.toggle(pressed);
        if(event.getKeyCode() == KeyEvent.VK_L) l.toggle(pressed);
        if(event.getKeyCode() == KeyEvent.VK_M) m.toggle(pressed);
        if(event.getKeyCode() == KeyEvent.VK_N) n.toggle(pressed);
        if(event.getKeyCode() == KeyEvent.VK_O) o.toggle(pressed);
        if(event.getKeyCode() == KeyEvent.VK_P) p.toggle(pressed);
        if(event.getKeyCode() == KeyEvent.VK_Q) q.toggle(pressed);
        if(event.getKeyCode() == KeyEvent.VK_R) r.toggle(pressed);
        if(event.getKeyCode() == KeyEvent.VK_S) s.toggle(pressed);
        if(event.getKeyCode() == KeyEvent.VK_T) t.toggle(pressed);
        if(event.getKeyCode() == KeyEvent.VK_U) u.toggle(pressed);
        if(event.getKeyCode() == KeyEvent.VK_V) v.toggle(pressed);
        if(event.getKeyCode() == KeyEvent.VK_W) w.toggle(pressed);
        if(event.getKeyCode() == KeyEvent.VK_X) x.toggle(pressed);
        if(event.getKeyCode() == KeyEvent.VK_Y) y.toggle(pressed);
        if(event.getKeyCode() == KeyEvent.VK_Z) z.toggle(pressed);

        if(event.getKeyCode() == KeyEvent.VK_ESCAPE) escape.toggle(pressed);
        if(event.getKeyCode() == KeyEvent.VK_SPACE) space.toggle(pressed);
        if(event.getKeyCode() == KeyEvent.VK_F1) F1.toggle(pressed);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // do nothing
    }

    @Override
    public void keyPressed(KeyEvent e) {
        toggle(e, true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        toggle(e, false);
    }
}
