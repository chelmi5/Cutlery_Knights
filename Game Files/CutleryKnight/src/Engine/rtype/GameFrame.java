package rtype;

import javax.swing.JFrame;

public class GameFrame extends JFrame {

    public GameFrame() {

        add(new ExplorationState());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setTitle("Test Moving");
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GameFrame();
    }
}