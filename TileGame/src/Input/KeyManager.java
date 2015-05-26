package Input;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{

    private boolean[] mKeys;
    public boolean up;
    public boolean wup;
    public boolean down;
    public boolean sdown;
    public boolean right;
    public boolean dright;
    public boolean left;
    public boolean aleft;

    public boolean one;

    public KeyManager() {
        mKeys = new boolean[256];
    }

    public void update() {
        wup = mKeys[KeyEvent.VK_W];
        up = mKeys[KeyEvent.VK_UP];

        sdown = mKeys[KeyEvent.VK_S];
        down = mKeys[KeyEvent.VK_DOWN];

        aleft = mKeys[KeyEvent.VK_A];
        left = mKeys[KeyEvent.VK_LEFT];

        dright = mKeys[KeyEvent.VK_D];
        right = mKeys[KeyEvent.VK_RIGHT];

        one = mKeys[KeyEvent.VK_1];
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // nothing yet
    }

    @Override
    public void keyPressed(KeyEvent e) {
        mKeys[e.getKeyCode()] = true;
        System.out.println("Pressed! ");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        mKeys[e.getKeyCode()] = false;
    }
}
