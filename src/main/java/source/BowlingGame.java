package source;

public class BowlingGame {
    private int[] rows = new int[20];
    private int count = 0;
    private int score;

    public void roll(int i) {
        rows[count++] = i;
        if (rows[1] + rows[0] == 10) {
            score = rows[2] * 2 + 10;
        }
    }

    public int score() {
        return score;
    }
}
