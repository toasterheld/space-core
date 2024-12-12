package engine.io.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Set;
import java.util.HashSet;

/**
 * The InputManager class is responsible for tracking the state of keyboard input, specifically which keys
 * are currently pressed or released. It implements the KeyListener interface to handle key events.
 */
public class InputManager implements KeyListener {
    // A set to store the keys that are currently pressed
    private static Set<Integer> pressedKeys = new HashSet<>();

    /**
     * Called when a key is pressed. Adds the key to the set of pressed keys.
     *
     * @param e the key event triggered by pressing a key
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        pressedKeys.add(keyCode);
    }

    /**
     * Called when a key is released. Removes the key from the set of pressed keys.
     *
     * @param e the key event triggered by releasing a key
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        pressedKeys.remove(keyCode);
    }

    /**
     * This method is called when a key is typed, but it is not used in this implementation.
     *
     * @param e the key event triggered by typing a key
     */
    @Override
    public void keyTyped(KeyEvent e) {
        // No implementation needed
    }

    /**
     * Checks whether a particular key is currently being pressed.
     *
     * @param keyCode the key code to check
     * @return true if the key is currently pressed, false otherwise
     */
    public static boolean isKeyDown(int keyCode){
        return pressedKeys.contains(keyCode);
    }
}
