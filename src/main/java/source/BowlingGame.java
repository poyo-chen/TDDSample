package source;

import java.util.Arrays;
import java.util.stream.Stream;

public class BowlingGame {
    private int[] rows = new int[20];
    private int count = 0;
    private int score;

    public void roll(int i) {
        rows[count] = i;
        count++;
    }

    public int score() {
        for (int i = 0; i < rows.length; i++){
            score+=rows[i];
        }
        Arrays.stream(rows).forEach(System.out::println);
        return score;
    }
}
