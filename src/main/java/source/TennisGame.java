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


//        if (firstPlayerScore == 4
//                && lessThanThree(secondPlayerScore)) {
//            return FIRST_PLAYER + BLANK + WIN;
//        } else if (secondPlayerScore == 4
//                && lessThanThree(firstPlayerScore)) {
//            return SECOND_PLAYER + BLANK + WIN;
//        } else if (firstPlayerScore == secondPlayerScore
//                && !lessThanThree(firstPlayerScore)) {
//            return DEUCE;
//        } else if (difference(firstPlayerScore, secondPlayerScore, 1)
//                && !lessThanThree(secondPlayerScore)) {
//            return FIRST_PLAYER + BLANK + ADVANTAGE;
//        } else if (difference(firstPlayerScore, secondPlayerScore, 1)
//                && !lessThanThree(firstPlayerScore)) {
//            return SECOND_PLAYER + BLANK + ADVANTAGE;
//        } else if (difference(firstPlayerScore, secondPlayerScore, 2)
//                && !lessThanThree(secondPlayerScore)) {
//            return FIRST_PLAYER + BLANK + WIN;
//        } else if (difference(firstPlayerScore, secondPlayerScore, 2)
//                && !lessThanThree(firstPlayerScore)) {
//            return SECOND_PLAYER + BLANK + WIN;
//        }


        /*
         * ?????????????????????
         * 1.Deuce
         * 2.Advantage
         * 3.Win
         */
        if (greaterThanThree(firstPlayerScore, secondPlayerScore)) {
            if (isDeuce(firstPlayerScore, secondPlayerScore)) {
                return DEUCE;
            }
            String ahead = whoAhead(firstPlayerScore, secondPlayerScore);

            String advantageOrWin = advantageOrWin(firstPlayerScore, secondPlayerScore);

            return ahead + BLANK + advantageOrWin;
        }

        /*
         * ????????????????????????
         */
        if (firstPlayerScore == 4) {
            return FIRST_PLAYER + BLANK + WIN;
        } else if (secondPlayerScore == 4) {
            return SECOND_PLAYER + BLANK + WIN;
        }

        return firstPlayerTotalScoreMapping + BLANK + secondPlayerTotalScoreMapping;
    }

    /**
     * ??????????????????
     *
     * @param firstPlayerScore
     * @param secondPlayerScore
     * @return
     */
    private String advantageOrWin(int firstPlayerScore, int secondPlayerScore) {
        return Math.abs(firstPlayerScore - secondPlayerScore) == 1 ? ADVANTAGE : WIN;
    }

    /**
     * ???????????????
     *
     * @param firstPlayerScore
     * @param secondPlayerScore
     * @return
     */
    private String whoAhead(int firstPlayerScore, int secondPlayerScore) {
        return firstPlayerScore > secondPlayerScore ? FIRST_PLAYER : SECOND_PLAYER;
    }

    /**
     * ??????????????????.
     *
     * @param firstPlayerScore
     * @param secondPlayerScore
     * @return
     */
    private boolean isDeuce(int firstPlayerScore, int secondPlayerScore) {
        return firstPlayerScore == secondPlayerScore;
    }

    /**
     * ?????????????????????.
     */
    public void firstPlayerScore() {
        firstPlayerScore++;
    }

    /**
     * ?????????????????????.
     */
    public void secondPlayerScore() {
        secondPlayerScore++;
    }

    /**
     * ???????????????????????????.
     *
     * @param firstPlayerScore
     * @param secondPlayerScore
     * @return
     */
    public boolean greaterThanThree(int firstPlayerScore, int secondPlayerScore) {
        return firstPlayerScore >= 3 && secondPlayerScore >= 3;
    }

}
