package engine.io.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Set;
import java.util.HashSet;

public class InputManager implements KeyListener {
    private static Set<Integer> pressedKeys = new HashSet<>();

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        pressedKeys.add(keyCode);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        pressedKeys.remove(keyCode);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public Set<Integer> getPressedKeys() {
        return pressedKeys;
    }


    public static boolean isKeyDown(int keyCode){
        return pressedKeys.contains(keyCode);
    }


}
