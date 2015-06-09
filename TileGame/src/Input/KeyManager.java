package Input;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{

    private boolean[] mKeys;

    public boolean escape;
    public boolean enter;
    public boolean backspace;

    public boolean up;
    public boolean down;
    public boolean right;
    public boolean left;

    public boolean one;
    public boolean two;
    public boolean three;
    public boolean four;
    public boolean five;

    public boolean jay;
    public boolean kay;
    public boolean sss;

    public KeyManager() {
        mKeys = new boolean[256];
    }

    public void update() {
        up = mKeys[KeyEvent.VK_UP] || mKeys[KeyEvent.VK_W];
        down = mKeys[KeyEvent.VK_DOWN] ||  mKeys[KeyEvent.VK_S];
        left = mKeys[KeyEvent.VK_LEFT] || mKeys[KeyEvent.VK_A];
        right = mKeys[KeyEvent.VK_RIGHT] ||  mKeys[KeyEvent.VK_D];

        one = mKeys[KeyEvent.VK_1];
        two = mKeys[KeyEvent.VK_2];
        three = mKeys[KeyEvent.VK_3];
        four = mKeys[KeyEvent.VK_4];
        five = mKeys[KeyEvent.VK_5];

        escape = mKeys[KeyEvent.VK_ESCAPE];
        enter = mKeys[KeyEvent.VK_ENTER];
        backspace = mKeys[KeyEvent.VK_BACK_SPACE];

        jay = mKeys[KeyEvent.VK_J];
        kay = mKeys[KeyEvent.VK_K];
        sss = mKeys[KeyEvent.VK_S];
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
