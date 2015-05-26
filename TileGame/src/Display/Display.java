package Display;

import javax.swing.*;
import java.awt.*;

public class Display {

    private JFrame mFrame;
    private Canvas mCanvas;
    private String mTitle;
    private int mWidth;
    private int mHeight;

    public Display(String title, int width, int height) {
        mTitle = title;
        mWidth = width;
        mHeight = height;

        createDisplay();
    }

    private void createDisplay() {
        mFrame = new JFrame(mTitle);
        mFrame.setSize(mWidth, mHeight);
        mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mFrame.setResizable(false);
        mFrame.setLocationRelativeTo(null);
        mFrame.setVisible(true);


        // canvas is what we will paint onto
        mCanvas = new Canvas();
        // this will make sure we we have the right size
        mCanvas.setPreferredSize(new Dimension(mWidth, mHeight));
        mCanvas.setMaximumSize(new Dimension(mWidth, mHeight));
        mCanvas.setMinimumSize(new Dimension(mWidth, mHeight));
        mCanvas.setFocusable(false);


        mFrame.add(mCanvas);
        //.pack will make sure it trues up the edges
        mFrame.pack();
    }

    public Canvas getCanvas() {
        return mCanvas;
    }

    public JFrame getFrame() {
        return mFrame;
    }
}
