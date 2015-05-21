package Objects;

public class Map {
    private int currentLevel = 1;
    private char[][] LevelArray;

    public void buildLevel(int row, int col) {

        for (int i = 0; i < col; i++) {
            LevelArray[0][i] = '*';
        }

        for (int i = 0; i < col; i++) {
            LevelArray[row - 1][i] = '*';
        }

        for (int i = 0; i < row; i++) {
            LevelArray[i][0] = '*';
        }

        for (int i = 0; i < col; i++) {
            LevelArray[col - 1][i] = '*';
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (LevelArray[i][j] != '*') {
                    LevelArray[i][j] = '.';
                }
            }
        }

    }

    public boolean isValid(int x, int y) {
        return LevelArray[x][y] == '.';
    }

    public void setLevel(int level) {
        currentLevel = level;
    }
}
