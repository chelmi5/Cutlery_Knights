import Engine.Game;

public class Launcher {

    public static void main(String [] args) {
        Game game = new Game("Cutlery Knight", 1200, 720);
        game.start();
    }
}
