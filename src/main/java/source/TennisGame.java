package source;

import java.util.HashMap;
import java.util.Map;

public class TennisGame {
    public static final String WIN = "win";
    public static final String FIRST_PLAYER = "first player";
    private static final String SECOND_PLAYER = "second player";
    public static final String DEUCE = "deuce";
    public static final String ADVANTAGE = "advantage";
    public int firstPlayerScore;
    public int secondPlayerScore;

    public Map<Integer, String> scoreMapping;

    public static final String LOVE = "love";
    public static final String FIFTEEN = "fifteen";
    public static final String THIRTY = "thirty";
    public static final String FORTY = "forty";
    public static final String BLANK = " ";

    public TennisGame() {
        scoreMapping = new HashMap<>();
        scoreMapping.put(0, LOVE);
        scoreMapping.put(1, FIFTEEN);
        scoreMapping.put(2, THIRTY);
        scoreMapping.put(3, FORTY);
    }


    public String score() {
        String firstPlayerTotalScoreMapping = scoreMapping.get(firstPlayerScore);
        String secondPlayerTotalScoreMapping = scoreMapping.get(secondPlayerScore);

//        if (firstPlayerScore == 3 && secondPlayerScore == 2) {
//            return FORTY + BLANK + THIRTY;
//        } else if (firstPlayerScore == 0 && secondPlayerScore == 1) {
//            return LOVE + BLANK + FIFTEEN;
//        } else if (firstPlayerScore == 4 && secondPlayerScore == 1) {
//            return "first player win";
//        }
        if (firstPlayerScore == 4
                && secondPlayerScore < 3) {
            return FIRST_PLAYER + BLANK + WIN;
        } else if (secondPlayerScore == 4
                && firstPlayerScore < 3) {
            return SECOND_PLAYER + BLANK + WIN;
        } else if (firstPlayerScore == secondPlayerScore
                && firstPlayerScore >= 3) {
            return DEUCE;
        } else if (firstPlayerScore - secondPlayerScore == 1
                && secondPlayerScore >= 3) {
            return FIRST_PLAYER + BLANK + ADVANTAGE;
        } else if (secondPlayerScore - firstPlayerScore == 1
                && firstPlayerScore >= 3) {
            return SECOND_PLAYER + BLANK + ADVANTAGE;
        } else if (firstPlayerScore - secondPlayerScore == 2) {
            return FIRST_PLAYER + BLANK + WIN;
        } else if (secondPlayerScore - firstPlayerScore == 2) {
            return SECOND_PLAYER + BLANK + WIN;
        }

        return firstPlayerTotalScoreMapping + BLANK + secondPlayerTotalScoreMapping;
    }

    public void firstPlayerScore() {
        firstPlayerScore++;
    }

    public void secondPlayerScore() {
        secondPlayerScore++;
    }
}
