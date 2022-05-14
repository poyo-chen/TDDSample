package source;

import java.util.Arrays;

public class BowlingGame {
    private int[] rows = new int[21];
    private int count = 0;
    private int totalScore;

    public void roll(int pinsDown) {
        rows[count++] = pinsDown;

    }

    public int score() {
        int rowNumber = 0;
        for (int round = 0; round < 10; round++) {
            int roundScore = 0;
            if (isSpare(rowNumber)) {
                //spare
                roundScore = 10 + rows[rowNumber + 2];
                rowNumber += 2;
            } else if (isStrike(rowNumber)) {
                //strike
                roundScore = 10 + rows[rowNumber + 1] + rows[rowNumber + 2];
                rowNumber++;

            } else {
                roundScore += rows[rowNumber] + rows[rowNumber + 1];
                rowNumber += 2;
            }

            totalScore += roundScore;
        }
        Arrays.stream(rows).forEach(System.out::print);
        return totalScore;
    }

    private boolean isStrike(int rowNumber) {
        return rows[rowNumber] == 10;
    }

    private boolean isSpare(int rowNumber) {
        return rows[rowNumber] + rows[rowNumber + 1] == 10;
    }
}
