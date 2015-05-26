package Engine;
import Display.*;
import Graphics.*;
import Input.KeyManager;
import States.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

    private Display mDisplay;
    private int mWidth;
    private int mHeight;
    private String mTitle;
    private boolean mRunning = false;
    private Thread mThread;
    private BufferStrategy mBs; // This is a hidden screen that the computer uses to preload
    private Graphics mPaintBrush;

    // Initialize all the States
    private StateManager mStateManager;

    // Input
    private KeyManager mKeyManager;

    // Game Camera
    private GameCamera mGameCamera;

    public Game(String title, int width, int height) {
        mWidth = width;
        mHeight = height;
        mTitle = title;
        mKeyManager = new KeyManager();
    }

    // initilizes all of our graphics
    private void init() {
        mDisplay = new Display(mTitle, mWidth, mHeight);
        mDisplay.getFrame().addKeyListener(mKeyManager);
        GraphicAssets.init();

        mGameCamera = new GameCamera(this, 0, 0);

        mStateManager = new StateManager(this);
    }

    private void update() {
        mKeyManager.update();

        if(StateManager.getCurrentState() != null)
            StateManager.getCurrentState().update();
    }

    private void render() { // draw stuff to the screen
        mBs = mDisplay.getCanvas().getBufferStrategy();
        if (mBs == null) {
            mDisplay.getCanvas().createBufferStrategy(3);
            return;
        }

        mPaintBrush = mBs.getDrawGraphics();
        // must clear the screen before dumping something onto it
        // clear the screen
        mPaintBrush.clearRect(0, 0, mWidth, mHeight);

        // Draw here

        if(StateManager.getCurrentState() != null)
            StateManager.getCurrentState().render(mPaintBrush);

        // End draw
        mBs.show();
        mPaintBrush.dispose();
    }

    @Override
    public void run() {

        init();

        int fps = 60;
        double timePerUpdate = 1000000000 / fps;
        double delta = 0.0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (mRunning) { // Engine.Game loop
            now = System.nanoTime();
            delta += (now - lastTime) / timePerUpdate; // delta tells us how much time we need to wait
            timer += now -lastTime;
            lastTime = now;

            if (delta >= 1) {
                update();
                render();
                ticks++;
                delta--;
            }

            if(timer >= 1000000000) {
                System.out.println("Frames Per Second: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }

        stop();
    }

    public KeyManager getKeyManager() {
        return mKeyManager;
    }

    public GameCamera getGameCamera(){
        return mGameCamera;
    }

    public int getWidth(){
        return mWidth;
    }

    public int getHeight(){
        return mHeight;
    }

    //Start a new Thread
    public synchronized void start() {
        if(mRunning)
            return;
        mRunning = true;
        mThread = new Thread(this);
        mThread.start();  // calls the run method
    }

    //Stops the Thread
    public synchronized void stop() {
        if(!mRunning)
            return;
        mRunning = false;
        try {
            mThread.join();
        } catch (InterruptedException e) {

        }
    }

}
